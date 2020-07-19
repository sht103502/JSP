package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/memberLogout")
//servlet의 이름을 ("/memberLogout ")으로 바꾼다.
public class LogOutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LogOutController() {
        super();
      
    }
//  (공통순서)
//  1 deget, dopost 안에 내용삭제
//  2 doprocess 생성 
//  3 deget, dopost 의 안에 doprocess(request,response)입력
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//  4 doProcess 안에 request.setCharacterEncodiing("UTF-8");로 입력
		HttpSession session =request.getSession();
//		세션초기화 !
		session.invalidate();
//		response.sendRedirect()는 조건을 실행하고 페이지를 이동하겠다라는 태그이다.
//		LoginSuccess.jsp 페이지로 이동		
		response.sendRedirect("LoginForm.jsp");
		
		
	}

}
