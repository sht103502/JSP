package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class LoginService {

	public String memberLogin(String id, String password) {
	MemberDAO dao=MemberDAO.getInstance();
	Connection con = getConnection();
	dao.setConnection(con);
	String loginId =dao.memberLogin(id,password);
	//dao.memberLogin(id,password)=> dao에서 return 받은 값
	close(con);
	return loginId;
	}

}
