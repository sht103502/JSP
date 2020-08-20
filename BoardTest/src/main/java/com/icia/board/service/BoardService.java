package com.icia.board.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dao.BoardDAO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;

@Service
public class BoardService {

	ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BoardDAO bdao;
	
	// 게시판 글쓰기
	public ModelAndView boardWriteFile(BoardDTO board) throws IllegalStateException, IOException {
		
		MultipartFile bFile = board.getBfile();
		String fileName = bFile.getOriginalFilename();
		
		String savePath = "C:/Users/1/Documents/workspace-spring-tool-suite-4-4.7.1.RELEASE/BoardTest/src/main/webapp/resources/fileUpload/" + fileName;
		
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}
		board.setBfilename(fileName);
		
		int writeResult = bdao.boardWriteFile(board);
		
		if(writeResult>0) {
			mav.setViewName("index");
		} else {
			mav.setViewName("index");
		}
		return mav;
	}
	//게시판 목록 보기
	public ModelAndView boardList(BoardDTO board) {
		mav = new ModelAndView();
	List<BoardDTO> boardlist = bdao.boardList(board);
	mav.addObject ("board", boardlist);
	mav.setViewName("boardList"); 
//	값을 가지고 dispatcher와 같은 거고 값을 가지고 boardList로 넘어간다.
	
	return mav;
	}
	
	//페이지 설정!
	private static final int PAGE_LIMIT =5;//한페이지에 보여중 글 갯수
	private static final int BLOCK_LIMIT =5; // 화면에 보여줄 페이지 번호 갯수
	//페이지 리스트
	public ModelAndView pagingList(int page) {
		PageDTO paging =new PageDTO();
		
		//게시글 갯수 조회
		int listCount = bdao.listCount();
		
		int startrow =(page-1) * PAGE_LIMIT+1;
		int endrow =page * PAGE_LIMIT;
		
		paging.setPage(page);
		paging.setStartrow(startrow);
		paging.setEndrow(endrow);
		
		/*
		 *  maxpage startpage endpage
		 * */
		int maxpage = (int) (Math.ceil((double)listCount/PAGE_LIMIT));
		int startpage = (((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1) * BLOCK_LIMIT +1;
		int endpage =startpage +BLOCK_LIMIT -1 ;
		
		if(endpage >maxpage) {
			endpage = maxpage;
		}
		/*
		 * 올림 : Math.ceil 
		 * 내람Math.floor
		 * 반올림 Math.round
		 * 
		 * */
		paging.setMaxpage(maxpage);
		paging.setStartpage(startpage);
		paging.setEndpage (endpage);
		
		List<BoardDTO> paginglist =bdao.pagingList(paging);
		
			mav.addObject("paginglist", paginglist);
			mav.addObject("paging", paging);
			mav.setViewName("pagingList");
			
			return mav;
		}
	
	//게시글조회
	public ModelAndView boardView(int bnum, int page) {
		//조회수 증가
		bdao.boardHit(bnum);
		
		//상세보기
		BoardDTO boardView =bdao.boardView(bnum);
		
		System.out.println(boardView);
		mav.addObject("boardView", boardView);
		mav.addObject("page",page);
		mav.setViewName("boardView");
		return mav;
	}
	
	
	public ModelAndView boardDelete(int bnum, int page) {
//		bnum만 가져가지고 넘어간다.
		int delResult =bdao.boardDelete(bnum);
		if(delResult >0) {
			mav.setViewName("redirect:/pagingList?page="+page);
		}else {
			mav.setViewName("index");
		}
		return mav;
	}
	
	//조회수 증가
	public void boardHit(int bnum) {
		bdao.boardHit(bnum);		
	}
	//수정페이지 이동!
	public ModelAndView boardModify(int bnum, int page) {
		//BoardDTO boardModify = bdao.boardModify(bnum);
		BoardDTO boardModify =bdao.boardView(bnum);
		
		mav.addObject("page",page);
		mav.addObject("boardModify",boardModify);
		mav.setViewName("boardModify");
		
		
		return mav;
	}
	
	public ModelAndView modifyProcess(BoardDTO board, int page) throws IllegalStateException, IOException {
		MultipartFile bFile = board.getBfile();
		//실제로 업로드 된 파일 
		
		
		String fileName = bFile.getOriginalFilename();
		//업로드 된 파일의 이름 
		//우리는 파일의 이름만 데이터베이스로 가져갈것이다.
		
		String savePath = "C:/Users/1/Documents/workspace-spring-tool-suite-4-4.7.1.RELEASE/BoardTest/src/main/webapp/resources/fileUpload/" + fileName;
		
		
		//파일이 업로드 될경우 (첨부파일 선택 할 경우)
		if(!bFile.isEmpty()) {
			bFile.transferTo(new File(savePath));
		}
		System.out.println("=========================확인 1=========================");
		System.out.println(board);
		
		board.setBfilename(fileName);
		System.out.println("=========================확인 2=========================");
		System.out.println(board);
		
		int modifyResult =bdao.modifyProcess(board);
		
		if(modifyResult>0) {
			mav.addObject("page",page);
			mav.setViewName("redirect:/boardView?bnum="+board.getBnum());
			
		}else {
			mav.setViewName("paginList?page="+page);
		}
		return mav;
	}
	public ModelAndView boardSearch(String type, String keyword) {
		List<BoardDTO> searchList = bdao.boardSearch(type, keyword);
		
		mav.addObject("paginglist",searchList);
		mav.setViewName("pagingList");
		return mav;
	}
	
}

