package service;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.BoardDAO;

public class DeleteService {

	public int boardDelete(String bNum) {
		BoardDAO dao = BoardDAO.getInstance();// sql초기화
		Connection con = getConnection();// DB연결
		dao.setConnection(con);// 데이터베이스와 dao를 연결시켜준다.

		int deleteResult = dao.boardDelete(bNum);

		if (deleteResult > 0) {
			System.out.println("glgl");
//			deleteResult 값이 0보다 크다면 (정상실행시) commit 실행			
			commit(con);
		} else {
//			deleteResult 값이 0이라면 or 0보다 작다면 rollback 실행			
			rollback(con);
		}

		close(con);

		return deleteResult;
	}

}
