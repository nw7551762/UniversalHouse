package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.impl.testDaoimpl;
import dao.impl.totalScoreDaoimpl;
import model.TestBean;
import model.totalBean;

@MultipartConfig
@WebServlet("/TestResultServlet")
public class TestResultServlet extends HttpServlet {
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

		try {

			testDaoimpl testDao = new testDaoimpl();

			int sum1 = 0;
			int sum2 = 0;
			//分數DB
			List<TestBean> beansa = testDao.checkFieldTest("1");
			totalScoreDaoimpl tsd = new totalScoreDaoimpl();
			String inputRadio = "a";
		 	String testLength = request.getParameter("questionCounts");
		 	System.out.println(testLength);
		 	Integer testL = Integer.parseInt(testLength);
		 	System.out.println(testL);
		 	System.out.println("------------------------");
			for (int i = 1; i < testL; i++) {
				String s = Integer.toString(i);
				inputRadio = request.getParameter(s);
				Integer inputR = Integer.parseInt(inputRadio);
				System.out.println(inputR);
				if (inputR == 1) {
					String o3 = beansa.get(i).getOptions3();
					Integer op3 = Integer.parseInt(o3);
					sum1 = sum1 + op3;
					System.out.println("op3" + sum1);
				} else if (inputR == 2) {
					String o4 = beansa.get(i).getOptions4();
					Integer op4 = Integer.parseInt(o4);
					sum2 = sum2 + op4;
					System.out.println("op4" + sum2);
				}
				
				
			}
				
					int a = sum1 + sum2;
			System.out.println(a);
			System.out.println("-----------------");
			String s1 = Integer.toString(a);
			String name = request.getParameter("name");
			String mb = name;
			System.out.println(s1);
			 tsd.addSumTest(mb, s1);
			totalBean total = new totalBean();
			total.setMemberId(mb);
			total.setFraction(s1);

			request.setAttribute("total", total);
			RequestDispatcher rd = request.getRequestDispatcher("/test/showResultEnd.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			
			
		}

	}

}
