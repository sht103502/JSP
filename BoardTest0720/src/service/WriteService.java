package service;

import java.sql.Connection;
import dao.BoardDAO;

import dto.BoardDTO;
import static db.JdbcUtil.*;

public class WriteService {

	public int BoradWrite(BoardDTO board) {
	BoardDAO dao=BoardDAO.getInstance();
	Connection con= getConnection();
	dao.setConnection(con);
	
	int svcResult =dao.BoardWrite(board);
	//dao.BoardWrite(board) => daoResult =1;
	//daoResult=1;
	
	if(svcResult >0) {
		commit(con);
	}else {
		rollback(con);
	}
	return svcResult;
}
}
