package spaceRental;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testUpdate")
public class testUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request,response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			
//			spaceRentalDAO dao = new spaceRentalDAO();
//			spaceRentalBEAN a = new spaceRentalBEAN();
//			a.setSpaceName("555");
//			a.setAccommodate(5);
//			a.setAddress("555");
//			a.setCity("555");
//			a.setFacility_1("555");
//			a.setFacility_2("555");
//			a.setFacility_3("555");
//			a.setFacility_4("555");
//			a.setFacility_5("555");
//			a.setIntro("oooooo");
//			a.setPeriod1("555");
//			a.setPeriod2("666");
//			a.setPrice(123);
//			a.setSpaceType("555");
//			a.setUnit("777");
//			a.setSpaceNo(5034);
//			System.out.println("test update");
//			dao.update(a);
	
			
	
			
		}
	}


