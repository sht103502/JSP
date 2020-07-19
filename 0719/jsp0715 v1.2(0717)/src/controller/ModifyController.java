package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;
import service.ModifyService;


@WebServlet("/memberModify")
//servlet의 이름을 ("/memberModify ")으로 바꾼다.
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifyController() {
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
		//     1)joinForm 에서 넘겨준 정보를 각각 변수에 저장한다.
		//     2)String id : String 타입의 변수 id 선언(변수는 우리맘대로)
		HttpSession session= request.getSession();
//		세션 값을 저장하기 위해 session값에 대한  새로운 객체를 선언 및 초기화를 한다.		
		String id=(String) session.getAttribute("loginId");
//		ModifyService 새로운 객체(변수명 :modifysvc)를 생성
		ModifyService modifysvc =new ModifyService();
//modifysvc에서memberModify(id)값을 가져와서 선언및 초기화		
		MemberDTO mbmodify=modifysvc.memberModify(id);
		
		request.setAttribute("mbmodify", mbmodify);
//		name="mbmmodify"의 속성값 mbmodify을 저장해 불러온다.
		RequestDispatcher dispatcher =request.getRequestDispatcher("MemberModify.jsp");
		dispatcher.forward(request, response);
		
	}

}
