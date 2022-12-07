package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/FindUserPassword")
public class FindUserPassword implements Filter {
String requestURI;
	
//	private static Logger log = LoggerFactory.getLogger(FindUserPassword.class);
	
	public FindUserPassword() {

	}	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 容器會在遠方客戶端提出請求、要求容器執行_02_login/login.jsp前，先執行本程式
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
			// **********Remember Me****************
			String cookieName = "";
			String memberId = "";
			String password = "";
			String rememberMe = "";
			// 取出瀏覽器送來的Cookie
			Cookie[] cookies = req.getCookies();
			if (cookies != null) {   						// 如果含有Cookie
				for (int i = 0; i < cookies.length; i++) {	// 檢視每個Cookie
					cookieName = cookies[i].getName();
					if (cookieName.equals("memberId")) {
						//找到user這個Cookie
						memberId = cookies[i].getValue();
					} else if (cookieName.equals("password")) {
						//找到password這個Cookie						
						password  = cookies[i].getValue();
						// 將密碼解密
//						if (tmp!= null){
//							password = 	GlobalService.decryptString(
//									        GlobalService.KEY, tmp);
//						}
					} 
					else if (cookieName.equals("rm")) {
						//找到rm這個Cookie(rm: rememberMe)
						rememberMe = cookies[i].getValue();
					}
				}
			} else {
				// 找不到Cookie，沒有關係，讓使用者輸入資料即可。
			}
//			log.info("user=" + user + ", password=" + password);
			// 將這三項資料存入request物件內，接下來執行的login.jsp就能取得這三份資料
			request.setAttribute("rememberMe", rememberMe);
			request.setAttribute("memberId", memberId);
			request.setAttribute("password", password);
		}
		chain.doFilter(request, response);   // 請容器找出下一棒程式: login.jsp，然後執行它
	}
	
	
	
	
	public void init(FilterConfig fConfig) throws ServletException {
	}
	@Override
	public void destroy() {
	}
    

}
