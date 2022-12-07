package filter;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//@WebFilter(
//		urlPatterns = {"/*"},
//		initParams = {
//				@WebInitParam(name = "", value = ""),		
//		})
public class ModifyTestNullFilter implements Filter {
	
//	private static Logger log = LoggerFactory.getLogger(LoginCheckingFilter.class);
	

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("NullFilter");
		String num1 = request.getParameter("");
		
		if(num1 != null && !num1.isEmpty()) {
			chain.doFilter(request, response);
		} else {
			response.setContentType("text/plain; charset=UTF-8");
			PrintWriter printer = response.getWriter();
			printer.print("欄位不能留空");
		}
	}
}
	