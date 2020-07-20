package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.ListService;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/boardList")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ListController() {
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
		
//		ListService service 클래스에 만들어 준다.
		ListService listsvc =new ListService();
		List<BoardDTO> ctrlList =listsvc.BoardList();
		//listsvc.BoardList() => svcList : BoardDTO를 List에 담는다.
		if(ctrlList != null) {
			request.setAttribute("jspList", ctrlList);
			RequestDispatcher dispatcher
			=request.getRequestDispatcher("BoardList.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("ListFail.jsp");
		}
		
		
	}

}
