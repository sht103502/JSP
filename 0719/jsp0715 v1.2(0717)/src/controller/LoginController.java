package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;


@WebServlet("/memberLogin")
//servlet의 이름을 ("/memberLogin ")으로 바꾼다.
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
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
		request.setCharacterEncoding("UTF-8");
//  4 doProcess 안에 request.setCharacterEncodiing("UTF-8");로 입력
//  5 doprocess안에 
//     1) LoginForm 에서 넘겨준 정보를 각각 변수에 저장한다.
//     2)String id : LoginForm.jsp에서 입력한 name=id값을 출력해 변수 String id 에 저장
//	   3)String password : LoginForm.jsp에서 입력한 name=password값을 출력해 변수 String password 에 저장
//     4)LogiService라는 새로운 객체 loginsvc 를 선언
//	   5)loginsvc에서memberLogin(id,password)값을 가져와 새로운변수 String loginId에 저장
//     4) 가져온 정보들은 member 변수에 담기 위해 MemberDTO 객체 선언 및 import
		HttpSession session =request.getSession();
//		세션 값을 저장하기 위해 session값에 대한  새로운 객체를 선언 및 초기화를 한다. 
		String id=request.getParameter("id");
		String password =request.getParameter("password");
		 
		LoginService loginsvc= new LoginService();
		String loginId =loginsvc.memberLogin(id,password);
		
		///////////////////////////////////////////////////
		
		if(loginId!=null) {
//			dao>Loginservice 순서대로 return 받은 값(loignId)가 null이아니라면 실행!
//			session.setAttribute("name", value);>> name="loginId"의 속성에 value=loginId를 저장한다. 
			session.setAttribute("loginId",loginId);
//			특정조건이 처리된후 페이지를 이동하고 싶은경우 response.sendRedirect("");를 사용
//			LoginSusccess.jsp로 이동
			response.sendRedirect("LoginSuccess.jsp");
		}else {
//			dao>Loginservice 순서대로 return 받은 값(loignId)가 null이라면! 실행
//			resopnse.sendRedirect("")로 LoginFail.jsp 로 이동!
			response.sendRedirect("LoginFail.jsp");
		}
	}

}
