package lesson.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloWorld implements Servlet {
	
	ServletConfig config;
	
	@Override
	public void destroy() {
		
		System.out.println("destroy() 호출");
	}

	@Override
	public ServletConfig getServletConfig() {
		
		System.out.println("getServletConfig() 호출");
		return this.config;
	}

	@Override
	public String getServletInfo() {
		
		System.out.println("getServletInfo() 호출");
		return "서블릿정보 돌려줌";
		
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println("init() 호출");
		this.config = config;

	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		
		System.out.println("service() 호출");
		
	}

}
