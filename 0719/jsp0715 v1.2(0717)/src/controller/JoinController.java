package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.JoinService;


@WebServlet("/memberjoin")
//servlet의 이름을 ("/memberJoin ")으로 바꾼다.
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public JoinController() {
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
	//     2)String id : String 타입의 변수 id 선언(변수는 우리맘대로)
	//     3)request.getParameter("id") :JoinForm 에서 name ="id"로 넘겨준 정보값
	//     4) 가져온 정보들은 member 변수에 담기 위해 MemberDTO 객체 선언 및 import
		request.setCharacterEncoding("UTF-8");
		
		String id =request.getParameter("id");
		String password =request.getParameter("password");
		String jsname =request.getParameter("jsname");
		String birth =request.getParameter("birth");
		String gender =request.getParameter("gender");
		String email =request.getParameter("email");
//		값을 받아오고
		MemberDTO member = new MemberDTO();
//		MemberDTO에 받아온 값을 저장시킨다.
		
//		위에서 설정한 String id 값을 MemberDTO의 setId 값을
//		메소드에 넣는다. 
//		우리가 입력한 값들이 member객체에 제대로 들어갔는지확인하는
//		member.toString ()
		member.setId(id);
		member.setPassword(password);
		member.setJsname(jsname);
		member.setBirth(birth);
		member.setGender(gender);
		member.setEmail(email);
//		service로 넘어가기 위한 작업
//		JoinService로 보내고 받기위해 JoinService객체 (joinsvc) 생성 및 import
		JoinService joinsvc = new JoinService();
//		int result: 결과페이지로 이동하기 위해 int타입의 변수 result 를 선언 
		int result =joinsvc.memberJoin(member);
//		JoinService의 memberJoin 메소드의 return 값
//		joinsvc.result =?
		
//		joinsvc.memberJoin(member)
//		JoinService 에있는 memberJoin(member)
//		:JoinService로 보내는 역할을 한다. 
//		:JoinService에 있는 memberJoin(member)메소드의 return 값
//		joinsvc에서 처리한 값을 result에 담는다.
//		joinsvc.memberJoin(member) 는 0아니면 1의 값을 가진다
		
		if(result>0) {
//			result 값이 0보다 크다면 (정상실행시)
//			JoinSuccess.jsp 페이지로 이동
			response.sendRedirect("JoinSuccess.jsp");
		}else {
//			result 값이 0이거나 0보다 작다면
//			JoinFail.jsp 페이지로 이동
			response.sendRedirect("JoinFail.jsp");
		}
		
		
	}

}
