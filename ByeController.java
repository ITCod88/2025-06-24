package com.bye.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ByeController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: " + command);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("post 방식!");
	}
}
