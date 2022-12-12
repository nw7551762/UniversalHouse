package myProject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import project.ProjectBean;
import project.ProjectDaoImpl_JDBC;

@WebServlet("/myProject/UpdateProjectServlet")
public class UpdateProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request,HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
			
			int pjID = Integer.parseInt(request.getParameter("pj_ID"));
			ProjectDaoImpl_JDBC dao = new ProjectDaoImpl_JDBC();
			ProjectBean bean = dao.findBypjID(pjID);
			
			if((request.getParameter("fieldName"))!=null) {
				bean.setFieldName(request.getParameter("fieldName"));
			}
			if((request.getParameter("pj_Name"))!=null) {
				bean.setPjName(request.getParameter("pj_Name")); 
			}
				bean.setPjInstruction(request.getParameter("pj_Instruction"));
			if((request.getParameter("pj_ServerLocation"))!=null) {
				bean.setPjServerLocation(request.getParameter("pj_ServerLocation")); 
			}
			if((request.getParameter("pj_Price"))!=null) {
				bean.setPjPrice(Integer.parseInt(request.getParameter("pj_Price")));
			}
			if((request.getParameter("pj_ExCompletionDate"))!=null && (bean.getPjClass()).equals("委託")  ) {
				Date exCompletionDate;
				try {
					exCompletionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pj_ExCompletionDate"));
					bean.setPjExCompletionDate(exCompletionDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if((request.getParameter("pj_ExecutionTime"))!=null && (bean.getPjClass()).equals("服務") ) {
				bean.setPjExecutionTime(request.getParameter("pj_ExecutionTime")); 
			}
			
			Date date = new Date();
			bean.setPjLastUpdate(date);
			
			if((request.getParameter("pj_Status"))!= null) {
				bean.setPjStatus(request.getParameter("pj_Status"));
			}
			
			dao.updateProject(bean);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
