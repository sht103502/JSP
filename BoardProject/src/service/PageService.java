package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/*import controller.BoardDTO;
import controller.List;*/

import static db.JdbcUtil.*;
import dao.BoardDAO;
import dto.BoardDTO;

public class PageService {

	public int ListCount() {
		BoardDAO dao= BoardDAO.getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		int listCount =dao.ListCount();
		
		
		close(con);
		
		return listCount;
	}

	public List<BoardDTO> BoardList(int startRow, int endRow) {
		System.out.println("svc startRow : "+ startRow);
		System.out.println("svc endRow : "+ endRow);
		
		BoardDAO dao= BoardDAO.getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		List<BoardDTO> boardList =dao.BoardList(startRow, endRow);
			close(con);
			return boardList;
		
				
		
		
	}

}
