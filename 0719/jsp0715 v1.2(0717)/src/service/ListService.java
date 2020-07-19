package service;

import static db.JdbcUtil.*;

import java.sql.*;
import java.util.*;

import dao.MemberDAO;
import dto.MemberDTO;

public class ListService {

	public List<MemberDTO> memberList() {
		MemberDAO dao= MemberDAO.getInstance();//sql초기화
		Connection con=getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
		
		List<MemberDTO> memberList =new ArrayList<MemberDTO>();
//		arrayList배열의 새로운객체를 (변수명:memberList) 만들어준다.
		memberList =dao.memberList();

		////////////////////////////////////////
//		MemberDAO에서 다시 돌아와서 DB를 close(con)으로 닫고
//		dao에서 return 받은값(memberList)를 그대로 리턴한다. 그리고 다시 ListController로 간다.
		close(con);
		
		
		return memberList;
	}

}
