package service;


import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;

public class ModifyService {

	public int BoardModify(BoardDTO board) {
		BoardDAO dao=BoardDAO.getInstance();//sql초기화
		Connection con = getConnection();//DB연결
		dao.setConnection(con);
		
		int modiResult=dao.BoardModify(board);
		
		
		if(modiResult>0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		return modiResult;
	}

}
