package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class DeleteService {

	public int memberDelete(String delId) {
		// TODO Auto-generated method stub
		MemberDAO dao=MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		int deleteResult =dao.memberDelete(delId);
		
		if(deleteResult>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return deleteResult;
	}

}
