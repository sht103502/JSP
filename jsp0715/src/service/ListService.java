package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class ListService {

	public List<MemberDTO> memberList() {
		MemberDAO dao= MemberDAO.getInstance();
		Connection con=getConnection();
		dao.setConnection(con);
		
		List<MemberDTO> memberList =new ArrayList<MemberDTO>();
		memberList =dao.memberList();
		
		close(con);
		
		
		return memberList;
	}

}
