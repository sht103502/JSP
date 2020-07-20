package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.WriteService;


@WebServlet("/boardWrite")
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public WriteController() {
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
		
		String bWriter =request.getParameter("bWriter");
		String bPassword =request.getParameter("bPassword");
		String bTitle =request.getParameter("bTitle");
		String bContent =request.getParameter("bContent");
		
		BoardDTO board =new BoardDTO();
		
		board.setbWriter(bWriter);
		board.setbPassword(bPassword);
		board.setbTitle(bTitle);
		board.setbContent(bContent);
		
		WriteService writesvc=new WriteService();
		
		int ctrlResult= writesvc.BoradWrite(board);
		//writesvc.BoardWriter(board) => svcResult =1;
		//ctrlResult =1;
		
		if(ctrlResult >0) {
			response.sendRedirect("boardList");
		}else {
			response.sendRedirect("WriteFail.jsp");
		}
	
	}

}
