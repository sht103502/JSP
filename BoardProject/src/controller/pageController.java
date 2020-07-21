package controller;
import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import dto.PageDTO;
import service.PageService;

@WebServlet("/pagingList")
public class pageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public pageController() {
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
		
		int page =1;
		int limit =5;
		
		//page 파라미터 값 검사
		if(request.getParameter("page") != null ) {
			page= Integer.parseInt(request.getParameter("page"));
		}
		
		PageService pagesvc = new PageService();
		//전체 게시글 갯수를 가져오기 위한 Private의 LisgCount메소드를 호출
		
		int listCount = pagesvc.ListCount();
		//pagesvc.ListCount() =36;
		//따라서 listCount =36;
		
		//limit값을 걸어놓은 만큼 범위에 해당하는 글만 가져오는 방법
		int startRow =(page-1)*limit +1;
		int endRow =page *limit;
		
		//startRow =1
		//endRow =3;
		
		List<BoardDTO> boardList =pagesvc.BoardList(startRow, endRow);
		
		//최대로 필요한 페이지 갯수 계산
		int maxPage =(int)((double)listCount /limit +0.9);
		
		//현재 페이지에 보여줄 시작페이지
		//1, 11, 21, 31 ......
		int startPage =(((int)((double)page / 10+0.9))-1)*10 +1;
		
		//현재 페이지에 보여줄 끝페이지
		// 10, 20, 30, 40,.....
		int endPage =startPage +10-1;
		
		if(endPage > maxPage) {
			endPage =maxPage;
		}
		
		PageDTO paging =new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		paging.setListCount(listCount);
		
		request.setAttribute("paging", paging);
		request.setAttribute("boardList", boardList);
		RequestDispatcher dispatcher =request.getRequestDispatcher("Paging.jsp");
		dispatcher.forward(request, response);
		
		
	}

}
