package com.hello.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HiController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: " + command);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글이 깨지는 것을 방지하기 위한 코드 (한글로 요청할때 !)
		response.setContentType("text/html; charset=UTF-8"); //한글로 응답할때 !
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command: " + command);
	}
}



