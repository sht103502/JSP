package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.DeleteService;


@WebServlet("/memberDelete")
//servlet의 이름을 ("/memberDelete ")으로 바꾼다.
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
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
		//     2)String delId : String 타입의 변수 delId 선언(변수는 우리맘대로)
		//     3)request.getParameter("id") :JoinForm 에서 name ="id"로 넘겨준 정보값
		//     4) 가져온 정보들은 deleteRsult 변수에 담기 위해 DeleteService 객체 선언 및 import
		request.setCharacterEncoding("UTF-8");
		
		String delId=request.getParameter("id"); 
		
		DeleteService delsvc =new DeleteService();
		int deleteResult =delsvc.memberDelete(delId);
		
		if(deleteResult > 0) {
//			deleteResult 값이 0보다 크다면 (정상실행시)
//			memberList 이동
			//memberList.jsp 로 가는것이 아닌 memberList로 간다.
			response.sendRedirect("memberList");
		}else {
//			deleteResult 값이 0이거나 0보다 작다면
//			DeleteFail.jsp 페이지로 이동
			response.sendRedirect("DeleteFail.jsp");
		}
		
	}

}
