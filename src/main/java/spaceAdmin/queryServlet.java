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

@WebServlet("/queryServlet")
public class queryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8"); //文字
		String city = request.getParameter("city");
		spaceRentalDAO dao = new spaceRentalDAO();
		List<spaceRentalBEAN> list;
		try {
			list = dao.readByCity(city);
			request.setAttribute("Qresult", list);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Class:queryServlet 發生例外: " 
					+ e.getMessage());
		}
		
//		request.setAttribute("query", list);
		RequestDispatcher rd = request.getRequestDispatcher("/spaceRental/queryResultNew.jsp");
//		RequestDispatcher rd = request.getRequestDispatcher("/spaceAdmin/showAllSpaceServlet");
		rd.forward(request, response);	
		return;
	}
	



}
