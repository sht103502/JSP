package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher =request.getRequestDispatcher("DispatcherResult.jsp");
		
		String id=request.getParameter("userID");
		String pw=request.getParameter("userPW");
		request.setAttribute("requestName","requestValue");
		dispatcher.forward(request, response);
		
	/*
	 	parameter 는 String 만 사용가능
	 	attribute는 String 외 에 Object, Array 등
	 	다양한 데이터 입력이 가능
	 	
	 	parameter 는 request 에만 저장이 가능
	 	attribute는 request외에도 session, context 에도 정장가능
	 	
	 	attribute가 좀 더 유연하다.
	  */
	}

}
