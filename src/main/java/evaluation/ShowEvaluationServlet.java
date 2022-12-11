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

@WebServlet("/evaluation/ShowEvaluationServlet")
public class ShowEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean) session.getAttribute("LoginOK");
		EvaluationDaoImpl_JDBC evDao = new EvaluationDaoImpl_JDBC();
		List<EvaluationBean> evBean = evDao.findByMember(mb.getMemberId());
		
		request.setAttribute("evaluation", evBean);
		RequestDispatcher rd = request.getRequestDispatcher("/evaluation/showEvaluation.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
}
