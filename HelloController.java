package com.hello.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//hello라는 요청이 클라이언트로부터 넘어오면 실행되는 서블릿
public class HelloController extends HttpServlet {
	private String contextParam;
	private String initParam;
	
	public HelloController() {
		System.out.println("HelloController 서블릿 생성자!");
	}
	
	@Override
	public void init(ServletConfig config) {
		//서블릿 객체가 생성될때 초기화할 수 있는 메소드
		contextParam = config.getServletContext().getInitParameter("url");
		System.out.println(contextParam);
		
		initParam = config.getInitParameter("id");
		System.out.println("initParam: " + initParam);
		
	}
	//첫 요청이 들어왔을때만 서블릿객체가 만들어진다. 한번 만들어지면 유지가 되며 다른 요청을 보내더라도 만들어진 서블릿 객체가 받아서 해결한다. (다시 서블릿 객체 생성X)
	

	//같은 a라는 요청이 들어와도 get이냐 post냐에 따라 다르게 작동한다. (doGet, doPoset 둘 중에 하나가 작동)
	//hello라는 요청이 get방식을 넘어올때 실행
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get 방식!");
		String command = request.getParameter("command");
		System.out.println("command: " + command);
		
		
		//응답
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<h1 style='background-color:skyblue;'>HelloServlet</h1>");
		out.print("<span>서블릿 연습</span>");
		out.print("<span><b>"+contextParam+"</b></span>");
		out.print("<span><s>"+initParam+"</s></span>");
		out.print("<a href='home.html'>돌아가기</a>");
	}
	
	//hello라는 요청이 post방식을 넘어올때 실행
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글이 깨지는 것을 방지하기 위한 코드 (한글로 요청할때 !)
		response.setContentType("text/html; charset=UTF-8"); //한글로 응답할때 !
		System.out.println("post 방식!");
		String command = request.getParameter("command");
		System.out.println("command: " + command);
		
		response.sendRedirect("Test.jsp");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet 종료!!!");  
	}
}

//웹 어플리케이션은 main이 없어도 동작이된다. 서블릿에서 객체를 만들고 동작시키기 때문이다.
//doGet(req,res)로 req와 res객체를 만들면서 실행한다.
//Java 코드가 바뀌면 무조건 서버를 restart해야한다.





//서블릿 객체 -> Controller
//배포 서술자: WEB-INF -> web.xml로 저장. 이름이 바뀌어도 안되고 위치가 바뀌어도 안됨 그러면 톰캣이 읽을 수가 없음
//서블릿 매핑: url의 노출을 줄일 수 있다.
//서블릿: controller를 java로 옮기는 것이라 생각하면 된다.


//front(view)는 html, controller는 servlet(java), model은 변화X -> MVC 구조



