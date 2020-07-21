package service;

import java.sql.*;
import static db.JdbcUtil.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class FileService {

	public int BoardWrite(BoardDTO board) {

		BoardDAO dao= BoardDAO.getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		int svcResult =dao.BoardWrite(board);
		//dao.BoardWrite(board) 
		//=> BoardDAO 의 BoardWrite(BoardDTO board) 메소드의
		// return 값 svcResult
		
		if(svcResult> 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		return svcResult;
		//controller로 가져간다.
	}

}
