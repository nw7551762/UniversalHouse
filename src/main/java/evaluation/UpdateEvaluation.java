package evaluation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import regist.MemberBean;

@WebServlet("/evaluation/UpdateEvaluation")
public class UpdateEvaluation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) {
		EvaluationDaoImpl_JDBC evDao = new EvaluationDaoImpl_JDBC();
		EvaluationBean evBean = evDao.findByID(Integer.parseInt(request.getParameter("ev_ID")));
		evBean.setEvClientEV(Integer.parseInt(request.getParameter("ev_ClientEV")));
		evBean.setEvClientComment(request.getParameter("ev_evClientComment"));
		
		evDao.updateProject(evBean);
	}
}
