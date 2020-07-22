package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.ViewService;

@WebServlet("/boardView")
//paging.jsp a태그
public class ViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ViewController() {
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
//		숫자를 불러올때는 Integer.parseInt(request.getParameter()) 를써라  
		int bNum =Integer.parseInt(request.getParameter("bNum")); 
		int page =Integer.parseInt(request.getParameter("page"));
		
		ViewService viewsvc =new ViewService();
		BoardDTO boardView =viewsvc.BoardView(bNum);
	
		if(boardView != null) {
			request.setAttribute("boardView", boardView);
			request.setAttribute("page", page);
			
			RequestDispatcher dispatcher =request.getRequestDispatcher("BoardView.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("ViewFail.jsp");
		}


}


}
