package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class LoginService {

	public String memberLogin(String id, String password) {
		
	MemberDAO dao=MemberDAO.getInstance();//sql초기화
	Connection con = getConnection();//DB연결
	dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
	String loginId =dao.memberLogin(id,password);
	//dao.memberLogin(id,password)=> dao에서 return 받은 값
	
	////////////////////////////////////////
//	MemberDAO에서 다시 돌아와서 DB를 close(con)으로 닫고
//	dao에서 return 받은값(loginId)를 그대로 리턴한다. 그리고 다시 LoginController로 간다.
	close(con);
	return loginId;
	}

}
