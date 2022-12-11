package evaluation;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/evaluation/DealServlet")
public class DealServlet extends HttpServlet {
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
		Date date = new Date();
		evBean.setEvCompletionDate(date);
		evDao.completeProject(evBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/evaluation/ShowMyEvaluationServlet");
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
