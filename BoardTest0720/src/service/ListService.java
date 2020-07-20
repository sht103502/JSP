package service;

import java.sql.*;
import java.util.*;
import static db.JdbcUtil.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class ListService {

	public List<BoardDTO> BoardList() {
		BoardDAO dao =BoardDAO.getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		List<BoardDTO>svcList =dao.BoardList();
		//dao.BoardList() => daoList : BoardDTO를 List에 담아옴
//		svcList=dao.BoardList();
		
		close(con);
		
		return svcList;
	}

}
