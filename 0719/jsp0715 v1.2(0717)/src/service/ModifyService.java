package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class ModifyService {

	public MemberDTO memberModify(String id) {
		MemberDAO dao=MemberDAO.getInstance();//sql초기화
		Connection con = getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
		
		MemberDTO mbmodify =dao.memberView(id);

		////////////////////////////////////////
//		MemberDAO에서 다시 돌아와서 DB를 close(con)으로 닫고
//		dao에서 return 받은값(mbmodify)를 그대로 리턴한다. 그리고 다시 ModifyController로 간다.
		close(con);
		
		return mbmodify;
	}

}
