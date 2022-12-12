package spaceAdmin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spaceRental.spaceRentalDAO;

@WebServlet("/spaceAdmin/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		spaceRentalDAO dao = new spaceRentalDAO();
		String spaceNo = request.getParameter("no");

		
		try {
			int row = dao.deleteBySpaceNO(Integer.parseInt(spaceNo));
			request.setAttribute("row", row);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/spaceAdmin/showAllSpaceServlet");
		rd.forward(request, response);
		return;

	}

}
