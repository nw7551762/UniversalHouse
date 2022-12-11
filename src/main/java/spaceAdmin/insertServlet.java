package spaceAdmin;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import spaceRental.spaceRentalBEAN;
import spaceRental.spaceRentalDAO;

@MultipartConfig
@WebServlet("/spaceAdmin/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (IOException | ServletException | SQLException e) {
			e.printStackTrace();
		}
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
		request.setCharacterEncoding("UTF-8");
		
		spaceRentalDAO dao = new spaceRentalDAO();
		spaceRentalBEAN space = new spaceRentalBEAN();

		space.setSpaceName(request.getParameter("spaceName"));
		space.setCity(request.getParameter("city"));
		space.setAddress(request.getParameter("address"));
		if( !request.getParameter("accommodate").equals("")) {
			space.setAccommodate(Integer.parseInt(request.getParameter("accommodate")));
		}
		space.setSpaceType(request.getParameter("spaceType"));
		if( !request.getParameter("price").equals("")) {
			space.setPrice(Integer.parseInt(request.getParameter("price")));
		}
		space.setUnit(request.getParameter("unit"));
		space.setPeriod1(request.getParameter("period1"));
		space.setPeriod2(request.getParameter("period2"));
		space.setFacility_1(request.getParameter("facility_1"));
		space.setFacility_2(request.getParameter("facility_2"));
		space.setFacility_3(request.getParameter("facility_3"));
		space.setFacility_4(request.getParameter("facility_4"));
		space.setFacility_5(request.getParameter("facility_5"));
		space.setIntro(request.getParameter("intro"));
		
		Part imgPart = request.getPart("pic");
		Blob imgBlob = space.partToBlob(imgPart);
		space.setPic(imgBlob);
		
		space.setComm(request.getParameter("comm"));
		int row = dao.insert(space);
		
		
		request.setAttribute("space", space);
		request.setAttribute("row", row);
		RequestDispatcher rd = request.getRequestDispatcher("/spaceAdmin/showAllSpaceServlet");
		rd.forward(request, response);		
		return;
		
	}
}
