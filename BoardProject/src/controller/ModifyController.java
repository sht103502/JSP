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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		int bNum=Integer.parseInt(request.getParameter("bNum"));
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		String bFile=request.getParameter("bFile");
		
		BoardDTO board=new BoardDTO();
		
		board.setbTitle(bTitle);
		board.setbContent(bContent);
		board.setbFile(bFile);
		board.setbNum(bNum);
		
		ModifyService modifysvc =new ModifyService();
		int modiResult=modifysvc.BoardModify(board);
		
		if(modiResult>0) {
			response.sendRedirect("pagingList");
		}else {
			response.sendRedirect("BoardFail.jsp");
		}

	
		
	}

}
