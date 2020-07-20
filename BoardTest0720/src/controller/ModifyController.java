package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BoardDTO;
import service.ModifyService;


@WebServlet("/boardModify")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ModifyController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session= request.getSession();
	
		String bTitle=(String) session.getAttribute("bTitle");
		String bContent=(String) session.getAttribute("bContent");
		ModifyService modifysvc =new ModifyService();
	
		BoardDTO bomodify=modifysvc.BoardModify(bTitle);
		
		request.setAttribute("bomodify", bomodify);
		bomodify.setbWriter(bTitle);
		bomodify.setbContent(bContent);
		
		RequestDispatcher dispatcher =request.getRequestDispatcher("BoardModify.jsp");
		dispatcher.forward(request, response);
		
	}
	


}
