package controller;

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

import dao.impl.galleryDaoimpl;
import model.galleryBean;
@WebServlet("/ShowImgForTestResultServlet")
public class ShowImgForTestResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		galleryDaoimpl dao = new galleryDaoimpl();
		// 找照片的Number
		
		if (!request.getParameter("fraction").equals("")) {
			int fraction = Integer.parseInt(request.getParameter("fraction"));
			if (fraction >= 100) {
				galleryBean gallery = dao.showImg("A");
				Blob blob = gallery.getTestImg();
				try (InputStream is = blob.getBinaryStream(); OutputStream os = response.getOutputStream();) {
					byte[] bytes = new byte[8126];
					int len = 0;

					while ((len = is.read(bytes)) != -1) {
						os.write(bytes, 0, len);
						os.flush();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else if (fraction < 100 && fraction >= 95) {
				galleryBean gallery = dao.showImg("B");
				Blob blob = gallery.getTestImg();
				try (InputStream is = blob.getBinaryStream(); OutputStream os = response.getOutputStream();) {
					byte[] bytes = new byte[8126];
					int len = 0;

					while ((len = is.read(bytes)) != -1) {
						os.write(bytes, 0, len);
						os.flush();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(fraction < 95 && fraction >= 90){
				galleryBean gallery = dao.showImg("C");
				Blob blob = gallery.getTestImg();
				try (InputStream is = blob.getBinaryStream(); OutputStream os = response.getOutputStream();) {
					byte[] bytes = new byte[8126];
					int len = 0;

					while ((len = is.read(bytes)) != -1) {
						os.write(bytes, 0, len);
						os.flush();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if (fraction < 90 && fraction >= 85) {
				galleryBean gallery = dao.showImg("D");
				Blob blob = gallery.getTestImg();
				try (InputStream is = blob.getBinaryStream(); OutputStream os = response.getOutputStream();) {
					byte[] bytes = new byte[8126];
					int len = 0;

					while ((len = is.read(bytes)) != -1) {
						os.write(bytes, 0, len);
						os.flush();
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}else if(fraction < 85 && fraction >= 80) {
				galleryBean gallery = dao.showImg("E");
				Blob blob = gallery.getTestImg();
				try (InputStream is = blob.getBinaryStream(); OutputStream os = response.getOutputStream();) {
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
		
		
	}
}


