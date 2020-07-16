package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class ProcessService {

	public int memberModify(MemberDTO member) {
		MemberDAO dao= MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		
		int modifyResult =dao.memberModify(member);
		if(modifyResult>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return modifyResult;		
	}

}
