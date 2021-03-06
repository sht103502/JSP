package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class ViewService {

	public MemberDTO memberView(String id) {
		System.out.println("가져가는 id : "+id);
		MemberDAO dao=MemberDAO.getInstance();//sql초기화
		Connection con = getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
		
		MemberDTO memberView =dao.memberView(id);
		
		////////////////////////////////////////
//		MemberDAO에서 다시 돌아와서 DB를 close(con)으로 닫고
//		dao에서 return 받은값(memberView)를 그대로 리턴한다. 그리고 다시 ViewController로 간다.
		
		close(con);// 굳이 안해도 상관 없지만 혹여나 DB가 멈출수 있기 때문에 사용한다.
		
		
		return memberView;
	}

}
