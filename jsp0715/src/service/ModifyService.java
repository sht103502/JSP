package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class ModifyService {

	public MemberDTO memberModify(String id) {
		MemberDAO dao=MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO mbmodify =dao.memberView(id);
		
		close(con);
		
		return mbmodify;
	}

}
