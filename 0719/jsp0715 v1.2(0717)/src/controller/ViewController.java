package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.ViewService;
import sun.rmi.server.Dispatcher;


@WebServlet("/memberView")
//servlet의 이름을 ("/memberView ")으로 바꾼다.
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ViewController() {
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
		request.setCharacterEncoding("UTF-8");
		String id =request.getParameter("id");
//		String id : String 타입의 변수 id 선언(변수는 우리맘대로)
//		request.getParameter("id") :joinForm 에서  ="id"로 넘겨준 정보값
		ViewService viewsvc =new ViewService();
//		ViewService 라는새로운 객체를 생성
		MemberDTO memberView = new MemberDTO();
//		MemberDTO 를 사용하기 위해 memberView 로 객채 생성
		memberView =viewsvc.memberView(id);
//		viewsvc.memberView(id);를 호출하여 memberView로 지정
		if(memberView!=null) {
//			만약 memberView가 null값과 다르면 실행 
//			"memberView"라는 name 의 속성값memberView로 선언
			request.setAttribute("memberView", memberView);
//			didspatcher 객체를 생성하여 MemberView.jsp로 이동하여
			RequestDispatcher dispatcher =request.getRequestDispatcher("memberView.jsp");
//			설정된 dispatcher로 요청과 응답 권한을 넘기는 작업
			dispatcher.forward(request, response);
		}
		
	}

}
