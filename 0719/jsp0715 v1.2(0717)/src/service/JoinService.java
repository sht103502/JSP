package service;

import java.sql.*;

import dao.MemberDAO;
import dto.MemberDTO;
import static db.JdbcUtil.*;

public class JoinService {

	public int memberJoin(MemberDTO member) {

		MemberDAO dao =MemberDAO.getInstance();//sql초기화
		Connection con=getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
		
//		int result =결과에 따라 commit 을 할지rollback 을 할지 정하기 위해 선언해준 변수
		int result =dao.memberJoin(member);
//		dao.memberJoin(member) Dao에 있는 memberJoin(member)의 return 값
		
		//MemberDAO 클래스에 있는 memberJoin 메소드의 return 값
		//dao.result=?
		
		if(result>0) {
//			result 값이 0보다 크다면 (정상실행시) commit 실행
			commit(con);
		}else {
//			result 값이 0이라면 or 0보다 작다면 rollback 실행
			rollback(con);
		}
		close(con);
//		메소드의 결과값을 return 한다 .
		return result;
	}

}
