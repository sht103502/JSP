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
		String bTitle =request.getParameter("bTitle");
		System.out.println("제목: "+ bTitle);
		ViewService viewsvc=new ViewService();
		BoardDTO boardView =new BoardDTO();
		boardView =viewsvc.boardView(bTitle);
		
		if(boardView != null) {
			
			request.setAttribute("boardView", boardView);
			RequestDispatcher dispatcher =request.getRequestDispatcher("boardView.jsp");
			dispatcher.forward(request, response);
		}else {
			
		}
		
	}

}
