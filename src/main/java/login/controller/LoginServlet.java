package login.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import member.model.Member;
import member.model.MemberDao;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = LoggerFactory.getLogger(LoginServlet.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberDao dao = new MemberDao();
		// 將errorMsgMap放入request物件內，識別字串為 "ErrorMsgKey"
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		
		// 1. 讀取使用者輸入資料
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");
		String rm = request.getParameter("rememberMe");
		String requestURI = (String) session.getAttribute("requestURI");
		
		// 如果 userId 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if( memberId==null || memberId.trim().length()==0 ) {
			errorMsgMap.put("memberIdEmptyError",  "帳號欄必須輸入");
		}
		// 如果 password 欄位為空白，放一個錯誤訊息到 errorMsgMap 之內
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		
		// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給login.jsp
		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response);
			log.info("會員登入功能之Controller: 登入資料不完整，送回錯誤訊息由使用者重新登入");
			return;
		}
		
		
		// 4. 進行 Business Logic 運算

		// 將密碼加密兩次，以便與存放在表格內的密碼比對
		Member mb = null;
		try {
			// 呼叫 loginService物件的 checkIDPassword()，傳入userid與password兩個參數
//			String encodePassword = GlobalService.encryptString(password);
			mb = dao.findByMemberIdAndPassword(memberId, password);
			if (mb != null) {
				// OK, 登入成功, 將mb物件放入Session範圍內，識別字串為"LoginOK"
				session.setAttribute("LoginOK", mb);
				// 建立登出所需的LogoutBean物件
//				LogoutBean logoutBean = new LogoutBean(session);
//				session.setAttribute("logoutBean", logoutBean);
				log.info("會員登入功能之Controller: 登入成功");
				Timestamp time = new Timestamp( new Date().getTime() );
				mb.setLastLogin(time);
				dao.update(mb);
				processCookies(request, response, memberId, password, rm, mb.getMemberId());
						
			} else {
				// NG, 登入失敗, userid與密碼的組合錯誤，放相關的錯誤訊息到 errorMsgMap 之內
				errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
			}
		} catch (RuntimeException ex) {
			errorMsgMap.put("LoginError", ex.getMessage());
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap 是空的，表示沒有任何錯誤，交棒給下一棒
		if (errorMsgMap.isEmpty()) {
			Timestamp time = new Timestamp( new Date().getTime() );
			mb.setLastLogin(time);
			dao.update(mb);
			if (requestURI != null) {
				
				requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
				response.sendRedirect(response.encodeRedirectURL(requestURI));
				return;
			} else {
				response.sendRedirect(response.encodeRedirectURL(request.getContextPath()));
				return;
			}
		} else {
			// 如果errorMsgMap不是空的，表示有錯誤，交棒給login.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/member/login/login.jsp");
			rd.forward(request, response);
			return;
		}
	}
	
	
	

	private void processCookies(HttpServletRequest request, HttpServletResponse response, 
								String userId, String password, String rm, String memberId) {
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		Cookie cookieMemberId = null;
		
		// rm存放瀏覽器送來之RememberMe的選項，如果使用者對RememberMe打勾，rm就不會是null
		cookieMemberId = new Cookie("memberId", memberId);
		cookieMemberId.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
		cookieMemberId.setPath(request.getContextPath());
		
		if (rm != null) {
			cookieUser = new Cookie("user", userId);
			cookieUser.setMaxAge(7 * 24 * 60 * 60); // Cookie的存活期: 七天
			cookieUser.setPath(request.getContextPath());

//			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", password);
			cookiePassword.setMaxAge(7 * 24 * 60 * 60);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());
		} else { // 使用者沒有對 RememberMe 打勾
			cookieUser = new Cookie("user", userId);
			cookieUser.setMaxAge(0); // MaxAge==0 表示要請瀏覽器刪除此Cookie
			cookieUser.setPath(request.getContextPath());

//			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", password);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(0);
			cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieMemberId);
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
	}
	
}
