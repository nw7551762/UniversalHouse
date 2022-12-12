package spaceAdmin;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spaceRental.spaceRentalBEAN;
import spaceRental.spaceRentalDAO;

@WebServlet("/spaceAdmin/showSpaceImgServlet")
public class showSpaceImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doPost(request, response);
	}
	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		spaceRentalDAO dao = new spaceRentalDAO();
		String spaceNo = request.getParameter("spaceNo");
		spaceRentalBEAN sr = dao.readBySpaceNO(Integer.parseInt(spaceNo));
		Blob blob = sr.getPic();
		try (
			InputStream is = blob.getBinaryStream();
			OutputStream os = response.getOutputStream();) {
			byte[] bytes = new byte[8126];
			int len = 0;
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
				os.flush();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
