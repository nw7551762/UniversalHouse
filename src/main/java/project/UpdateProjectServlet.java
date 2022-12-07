package project;

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

@WebServlet("/project/UpdateProjectServlet")
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
			
			int memberPK = Integer.parseInt(request.getParameter("memberPK"));
			ProjectDaoImpl_JDBC dao = new ProjectDaoImpl_JDBC();
			ProjectBean bean = (ProjectBean) dao.findByID(memberPK);
			
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
			if((request.getParameter("pj_ExCompletionDate"))!=null && bean.getPjClass() == "委託" ) {
				Date exCompletionDate;
				try {
					exCompletionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("pj_ExCompletionDate"));
					bean.setPjExCompletionDate(exCompletionDate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if((request.getParameter("pj_ExecutionTime"))!=null && bean.getPjClass() == "服務" ) {
				bean.setPjExecutionTime(request.getParameter("pj_ExecutionTime")); 
			}
			if((request.getParameter("pj_Status"))!=null) {
				request.getParameter("pj_Status");
			}
			dao.updateProject(bean);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
