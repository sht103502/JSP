package com.icia.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.PageDTO;



@Repository
public class BoardDAO {

	@Autowired
	private SqlSessionTemplate sql;
	
	public int boardWriteFile(BoardDTO board) {
		return sql.insert("Board.boardWriteFile", board) ;
	}
	//게시판 목록 보기
	public List<BoardDTO> boardList(BoardDTO board) {
		
		return sql.selectList("Board.boardList");
	}
	
//	방금 추가시킴!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//리스트 숫자
	
	//페이지 보기
	
	public int listCount() {
		return sql.selectOne("Board.listCount");
	}
	
	public List<BoardDTO> pagingList(PageDTO paging){
		return sql.selectList("Board.pagingList", paging);
	}
	public BoardDTO boardView(int bnum) {
		return sql.selectOne("Board.boardView", bnum);
	}


	public int boardHit(int bnum) {
		return sql.update("Board.boardHit", bnum);
	}
	
	public int boardDelete(int bnum) {
		return sql.delete("Board.boardDelete", bnum);
	}
	//수정페이지
	public BoardDTO boardModify(int bnum) {
		return sql.selectOne("Board.boardModify",bnum);
	}
	public int modifyProcess(BoardDTO board) {
		return sql.update("Board.modifyProcess",board);
	}
	//
	public List<BoardDTO> boardSearch(String type, String keyword) {
		Map<String, String>map =new HashMap<String, String>();
		map.put("type",type);
		map.put("keyword",keyword);
		return sql.selectList("Board.search",map);
		
		/*
		 * if(type.contentEquals("1")) { return sql.selectList("Board.search1",
		 * keyword); }else { return sql.selectList("Board.search2", keyword); }
		 */
		
	}

}
