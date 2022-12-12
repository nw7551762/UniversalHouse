package article_blob;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.*;
import regist.*;

@WebServlet("/showMemberImage")
public class ShowMemberImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream os = null;
		InputStream is = null;
		Blob blob = null;
		try {
			String memberPk = request.getParameter("memberPk");
			MemberDao memberDao=new MemberDao();
			MemberBean memberBean = memberDao.findByMemberPK(Integer.parseInt(memberPk));

			if (memberBean != null) {
				blob = memberBean.getMemberImage();
				if (blob == null) {
					RequestDispatcher rd = request.getRequestDispatcher("/Test/error.jsp");
					rd.forward(request, response);
					return;	
				}
				is = blob.getBinaryStream();
			}
			os = response.getOutputStream();

			int len = 0;
			byte[] bytes = new byte[8192];
			while ((len = is.read(bytes)) != -1) {
				os.write(bytes, 0, len);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			throw new RuntimeException("發生SQLException: " + ex.getMessage());
		} finally {
			if (is != null)
				is.close();
			if (os != null)
				os.close();

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}