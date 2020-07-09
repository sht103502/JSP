package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doProcess(request, response);
		response.getWriter().append("doGet메소드 호출!");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		doProcess(request, response);
		response.getWriter().append("doPost메소드 호출!");
	}
	//임의로  Process생성!
	//doGet과 doPost에 공통된 부분 작성
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.getWriter().append("doProcess 메소드 호출");
	
	String id=request.getParameter("userID");
	String pw=request.getParameter("userPW");
	int number=Integer.parseInt(request.getParameter("num1"));
	
	response.getWriter().append("아이디"+id+"<br/>");
	response.getWriter().append("비밀번호"+pw+"<br/>");
	response.getWriter().append("숫자"+number+"<br/>");
	}

}
