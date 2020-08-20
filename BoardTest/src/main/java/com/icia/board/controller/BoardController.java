package com.icia.board.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;

@Controller
public class BoardController {

	private ModelAndView mav = new ModelAndView();
	
	@Autowired
	private BoardService bdsvc;
	
	

	// 게시판으로 이동
	@RequestMapping(value="/boardForm")
	private String boardForm() {
		return "boardWrite";
	}
	
	// 게시판 글쓰기(boardWriteFile)
	@RequestMapping(value="/boardWriteFile", method=RequestMethod.POST)
	private ModelAndView boardWriteFile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		
		mav = bdsvc.boardWriteFile(board);
		
		return mav;
	}
	
	//게시판 목록 보기
	@RequestMapping(value="/boardList")
	private ModelAndView boardList(@ModelAttribute BoardDTO board) {
		mav = bdsvc.boardList(board);
		
		return mav;
	}
	
	
	//페이지 번호 표시
	@RequestMapping(value="/pagingList")
	private ModelAndView pagingList(@RequestParam(value="page",required=false, defaultValue="1") int page) {
		//required=false => 필수로 page를 받아오지 않아도 된다.
		//defaultValue="1" => 기본값은 1
		if(page==0) {
			page=1;
		}
		mav= bdsvc.pagingList(page);
		
		return mav;
	}
	
	//게시글 조회
	@RequestMapping(value="/boardView")
	private ModelAndView boardView(@RequestParam(value="bnum")int bnum,@RequestParam(value="page",required=false, defaultValue="1") int page) {
		//System.out.println("bnum :"+bnum);
		//System.out.println("page :"+page);
		mav=bdsvc.boardView(bnum, page);
		bdsvc.boardHit(bnum);
	
		return mav;
	
	}
	
	//게시글 삭제
	@RequestMapping(value="/boardDelete")
	private ModelAndView boardDelete(@RequestParam(value="bnum") int bnum, @RequestParam(value="page",required=false, defaultValue="1") int page) {
		mav = bdsvc.boardDelete(bnum,page);
		return mav;
	}
	
	//게시글 수정페이지 이동
	@RequestMapping(value="/boardModify")
	private ModelAndView boardModify(@RequestParam(value="bnum") int bnum , @RequestParam(value="page",required=false, defaultValue="1") int page) {
	mav=bdsvc.boardModify(bnum, page);
	return mav;
	}
	
	//게시글 수정하기
	@RequestMapping(value="/modifyProcess")
	private ModelAndView modifyProcess(@ModelAttribute BoardDTO board, @RequestParam(value="page",required=false, defaultValue="1") int page) throws IllegalStateException, IOException {
		mav=bdsvc.modifyProcess(board, page);
		return mav;
	}
	
	//게시글 검색
	@RequestMapping(value ="/boardSearch")
	private ModelAndView boardSearch(@RequestParam(value="type")String type, @RequestParam(value="keyword") String keyword) {
		mav = bdsvc.boardSearch(type, keyword);
		return mav;
	}
}
