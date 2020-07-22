package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import dto.BoardDTO;
public class ViewService {

	public BoardDTO BoardView(int bNum) {
		BoardDAO dao= BoardDAO.getInstance();
		Connection con =getConnection();
		dao.setConnection(con);
		
		//(1) 조회수 1증가
		int bHit =dao.BoardHit(bNum);
		
		if(bHit >0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		
		//(2) 해당 글
		BoardDTO boardView =dao.BoardView(bNum);
		
		return boardView;
	}

	

}
