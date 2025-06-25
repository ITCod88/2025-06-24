package com.bye.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByeController extends HttpServlet {
	private String contextParam;
	private String initParam;
	
	public ByeController() {
		System.out.println("ByeController 서블릿 생성자!");
	}
	
	@Override
	public void init(ServletConfig config) {
		//서블릿 객체가 생성될때 초기화할 수 있는 메소드
		contextParam = config.getServletContext().getInitParameter("url");
		System.out.println(contextParam);
		
		initParam = config.getInitParameter("id");
		System.out.println("initParam: " + initParam);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: " + command);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("post 방식!");
	}
}
