package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;


@WebServlet("/test")
public class testTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	    
	 
	    protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
	 
	            throws ServletException, IOException {

      response.setContentType("text/html;charset=UTF-8");

      //對Post中文參數進行解碼

      request.setCharacterEncoding("UTF-8");

      //取得Ajax傳入的參數

      String userName = request.getParameter("userName");

      String[] arrayUserInterest = request.getParameterValues("userInterest");

      //建構要回傳JSON物件

      HashMap userInfoMap = new HashMap();

      userInfoMap.put("userName", userName);

      

      ArrayList userInterestList = new ArrayList();

      userInterestList.addAll(Arrays.asList(arrayUserInterest));

      userInfoMap.put("userInterest", userInterestList);

      

      JSONObject responseJSONObject = new JSONObject(userInfoMap);

      

      PrintWriter out = response.getWriter();

      out.println(responseJSONObject);

  }
	 
	 
	 
	    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	 
	    /**
	 
	     * Handles the HTTP <code>GET</code> method.
	 
	     *
	 
	     * @param request servlet request
	 
	     * @param response servlet response
	 
	     * @throws ServletException if a servlet-specific error occurs
	 
	     * @throws IOException if an I/O error occurs
	 
	     */
	 
	    @Override
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	 
	            throws ServletException, IOException {
	 
	        processRequest(request, response);
	 
	    }
	 
	 
	 
	    /**
	 
	     * Handles the HTTP <code>POST</code> method.
	 
	     *
	 
	     * @param request servlet request
	 
	     * @param response servlet response
	 
	     * @throws ServletException if a servlet-specific error occurs
	 
	     * @throws IOException if an I/O error occurs
	 
	     */
	 
	    @Override
	 
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	 
	            throws ServletException, IOException {
	 
	        processRequest(request, response);
	 
	    }
	 
	 
	 
	    /**
	 
	     * Returns a short description of the servlet.
	 
	     *
	 
	     * @return a String containing servlet description
	 
	     */
	 
	    @Override
	 
	    public String getServletInfo() {
	 
	        return "Short description";
	 
	    }// </editor-fold>
	 
	 
	 
	

}
