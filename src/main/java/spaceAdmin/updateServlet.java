package spaceAdmin;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import spaceRental.spaceRentalBEAN;
import spaceRental.spaceRentalDAO;

@WebServlet("/spaceAdmin/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setCharacterEncoding("UTF-8");
		String spaceNo = request.getParameter("spaceNo");
		System.out.println(spaceNo);
		spaceRentalDAO dao = new spaceRentalDAO();
		spaceRentalBEAN sr = dao.readBySpaceNO(Integer.parseInt(spaceNo));
		
		request.setAttribute("update", sr);
		RequestDispatcher rd = request.getRequestDispatcher("/spaceRental/updateData.jsp");
		rd.forward(request, response);
		return;
	}
}

//		if (request.getParameter("spaceName") != null) {
//			sr.setSpaceName(request.getParameter("spaceName"));
//		}
//		if (request.getParameter("city") != null) {
//			sr.setCity(request.getParameter("city"));
//		}
//		if (request.getParameter("address") != null) {
//			sr.setAddress(request.getParameter("address"));
//		}
//		if (request.getParameter("accommodate") != null) {
//			sr.setAccommodate(Integer.parseInt(request.getParameter("accommodate")));
//		}
//		if (request.getParameter("spaceType") != null) {
//			sr.setSpaceType(request.getParameter("spaceType"));
//		}
//		if (request.getParameter("price") != null) {
//			sr.setPrice(Integer.parseInt(request.getParameter("price")));
//		}
//		if (request.getParameter("unit") != null) {
//			sr.setUnit(request.getParameter("unit"));
//		}
//		if (request.getParameter("period1") != null) {
//			sr.setPeriod1(request.getParameter("period1"));
//		}
//		if (request.getParameter("period2") != null) {
//			sr.setPeriod2(request.getParameter("period2"));
//		}
//		if (request.getParameter("facility_1") != null) {
//			sr.setFacility_1(request.getParameter("facility_1"));
//		}
//		if (request.getParameter("facility_2") != null) {
//			sr.setFacility_2(request.getParameter("facility_2"));
//		}
//		if (request.getParameter("facility_3") != null) {
//			sr.setFacility_3(request.getParameter("facility_3"));
//		}
//		if (request.getParameter("facility_4") != null) {
//			sr.setFacility_4(request.getParameter("facility_4"));
//		}
//		if (request.getParameter("facility_5") != null) {
//			sr.setFacility_5(request.getParameter("facility_5"));
//		}
//		if (request.getParameter("intro") != null) {
//			sr.setIntro(request.getParameter("intro"));
//		}
//		if (request.getParameter("comm") != null) {
//			sr.setComm(request.getParameter("comm"));
//		}
		