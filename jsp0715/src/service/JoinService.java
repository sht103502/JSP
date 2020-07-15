package service;

import java.sql.*;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class JoinService {

	public int memberJoin(MemberDTO member) {
		MemberDAO dao =MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		int result =dao.memberJoin(member);
		//MemberDAO 클래스에 있는 memberJoin 메소드의 return 값
		//dao.result=?
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

}
