package evaluation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import regist.MemberBean;

@WebServlet("/evaluation/AddToProjectCart")
public class AddToProjectCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		EvaluationBean ev = null;
		EvaluationDaoImpl_JDBC dao = new EvaluationDaoImpl_JDBC();
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		Map<String, String> errorMsg = new HashMap<String, String>();
		request.setAttribute("ErrorMsgKey", errorMsg);
		int pjID = 0;
		int pjPrice = 0;
		if ((request.getParameter("pj_ID")) != null) {
			pjID = Integer.parseInt(request.getParameter("pj_ID"));
		}
		String mbID = mb.getMemberId();
		String tbMbID = request.getParameter("memberID");
		if ((request.getParameter("pj_Price")) != null) {
			pjPrice = Integer.parseInt(request.getParameter("pj_Price"));
		}

		ev = dao.findByMember(pjID, mbID);
		if (ev == null && mbID != tbMbID) {
			dao.saveEvaluation(pjID, mbID, tbMbID, pjPrice);
			ev = dao.findByMember(pjID, mbID);
		} else {
			errorMsg.put("AddToCart", "存入清單失敗");
		}
	}
}
