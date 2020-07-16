package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class ViewService {

	public MemberDTO memberView(String id) {
		System.out.println("가져가는 id : "+id);
		MemberDAO dao=MemberDAO.getInstance();
		Connection con = getConnection();
		dao.setConnection(con);
		
		MemberDTO memberView =dao.memberView(id);
		
		close(con);// 굳이 안해도 상관 없지만 혹여나 DB가 멈출수 있기 때문에 사용한다.
		
		
		return memberView;
	}

}
