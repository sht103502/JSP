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

/**
 * Servlet implementation class ProcessController
 */
@WebServlet("/ModifyProcess")
public class ProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessController() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		 String jsname=request.getParameter("jsname");
		 String email =request.getParameter("email");
		 String id= (String)session.getAttribute("loginId");
		
		 MemberDTO member= new MemberDTO();
		
		 member.setId(id);
		 member.setJsname(jsname);
		 member.setEmail(email);
		 
		 ProcessService prosvc=new ProcessService();
		int modifyResult =prosvc.memberModify(member);
		
		if(modifyResult>0) {
			response.sendRedirect("LoginSuccess.jsp");
		}else {
			response.sendRedirect("ModifyFail.jsp");
		}
		
	}

}
