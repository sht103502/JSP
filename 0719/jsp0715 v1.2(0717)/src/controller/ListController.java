package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.ListService;


@WebServlet("/memberList")
//servlet의 이름을 ("/memberList ")으로 바꾼다.
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ListController() {
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
		
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		//MemeberDTO의 Array를 새로운 객체로 생성
		ListService listsvc =new ListService(); 
//		ListService 라는 새로운 객체 생성
		memberList =listsvc.memberList();
//		listsvc에서 memberList() 를 가져와!
		
		request.setAttribute("memberList",memberList);
//		name "memberList"의 속성값을 memberList로 저장
		RequestDispatcher dispatcher =request.getRequestDispatcher("MemberList.jsp");
//		   MemberList.jsp로 이동하는 RequestDisptcher dispatcher 객체를 선언  
		dispatcher.forward(request, response);
//		설정된 dispatcher에 불러오고, 응답권한을 준다.
	}

}
