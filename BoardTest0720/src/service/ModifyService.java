package service;

import dto.BoardDTO;
import dao.BoardDAO;
import static db.JdbcUtil.*;

import java.sql.*;
public class ModifyService {

	public BoardDTO BoardModify(String bTitle) {
			BoardDAO dao=BoardDAO.getInstance();//sql초기화
			Connection con = getConnection();//DB연결
			dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
			
			BoardDTO bomodify =dao.BoardView(bTitle);

			////////////////////////////////////////

			close(con);
			
			return bomodify;
	}


}
