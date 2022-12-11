package spaceAdmin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spaceRental.spaceRentalBEAN;
import spaceRental.spaceRentalDAO;

@WebServlet("/spaceAdmin/showAllSpaceServlet")
public class showAllSpaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
//		HttpSession session = request.getSession();
		spaceRentalDAO dao = new spaceRentalDAO();
		List<spaceRentalBEAN> list = dao.readAll();
		
		request.setAttribute("spaces", list);
		RequestDispatcher rd = request.getRequestDispatcher("/spaceRental/showAllData.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
