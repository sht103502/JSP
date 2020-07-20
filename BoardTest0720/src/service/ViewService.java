package service;

import java.sql.*;
import static db.JdbcUtil.*;

import dao.BoardDAO;
import dto.BoardDTO;

public class ViewService {

	public BoardDTO boardView(String bTitle) {
		
		System.out.println("가져가는 bTitle : "+bTitle);
		BoardDAO dao=BoardDAO.getInstance();//sql초기화
		Connection con = getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
		
		BoardDTO boardView =dao.BoardView(bTitle);
		
		close(con);
		
		return boardView;
	}

}
