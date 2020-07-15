package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.JoinService;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/memberjoin")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
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
		// TODO Auto-generated method stub
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
		member.setId(id);
		member.setPassword(password);
		member.setJsname(jsname);
		member.setBirth(birth);
		member.setGender(gender);
		member.setEmail(email);
		
		JoinService joinsvc = new JoinService();
		int result =joinsvc.memberJoin(member);
//		JoinService의 memberJoin 메소드의 return 값
//		joinsvc.result =?
		
		if(result>0) {
			response.sendRedirect("JoinSuccess.jsp");
		}else {
			response.sendRedirect("JoinFail.jsp");
		}
		
		
	}

}
