package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.ProcessService;


@WebServlet("/ModifyProcess")
//servlet의 이름을 ("/ModifyProcess ")으로 바꾼다.
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProcessController() {
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
		//  5 doprocess안에 
		//     1) joinForm 에서 넘겨준 정보를 각각 변수에 저장한다.
		//     2)String jsname : String 타입의 변수 jsname 선언(변수는 우리맘대로)
		//     3)String email : String 타입의 변수 email 선언(변수는 우리맘대로)
		//     4)String id : String 타입의 변수 id 선언(변수는 우리맘대로)

		//     5)request.getParameter("id") :JoinForm 에서 name ="id"로 넘겨준 정보값
		//     6) 가져온 정보들은 member 변수에 담기 위해 MemberDTO 객체 선언 및 import
		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		 String jsname=request.getParameter("jsname");
		 String email =request.getParameter("email");
		 String id= (String)session.getAttribute("loginId");
//			값을 받아오고		
		 MemberDTO member= new MemberDTO();
//			MemberDTO에 받아온 값을 저장시킨다.		
//			위에서 설정한 String id 값을 MemberDTO의 setId 값을
//			메소드에 넣는다. 
//			우리가 입력한 값들이 member객체에 제대로 들어갔는지확인하는
//			member.toString ()
		 member.setId(id);
		 member.setJsname(jsname);
		 member.setEmail(email);
//			service로 넘어가기 위한 작업
//			ProcessService로 보내고 받기위해 ProcessService객체 (prosvc) 생성 및 import		 
		 ProcessService prosvc=new ProcessService();
//			int modifyResult: 결과페이지로 이동하기 위해 int타입의 변수 result 를 선언		 
		int modifyResult =prosvc.memberModify(member);
		
		if(modifyResult>0) {
//			modifyResult 값이 0보다 크다면 (정상실행시)
//			LoginSuccess.jsp 페이지로 이동
			response.sendRedirect("LoginSuccess.jsp");
		}else {
//			modifyResult 값이 0이거나 0보다 작다면
//			ModifyFail.jsp 페이지로 이동
			response.sendRedirect("ModifyFail.jsp");
		}
		
	}

}
