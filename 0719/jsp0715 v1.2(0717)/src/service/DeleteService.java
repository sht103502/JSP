package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class DeleteService {

	public int memberDelete(String delId) {

		MemberDAO dao=MemberDAO.getInstance();//sql초기화
		Connection con = getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.

//		int deleteResult =결과에 따라 commit 을 할지rollback 을 할지 정하기 위해 선언해준 변수		
		int deleteResult =dao.memberDelete(delId);
//		dao.memberDelete(delId) Dao에 있는 memberDelete(delId)의 return 값

		//MemberDAO 클래스에 있는 memberDelete 메소드의 return 값
		//dao.result=?


		
		if(deleteResult>0) {
//			deleteResult 값이 0보다 크다면 (정상실행시) commit 실행			
			commit(con);
		}else {
//			deleteResult 값이 0이라면 or 0보다 작다면 rollback 실행			
			rollback(con);
		}
		
		////////////////////////////////////////
//		MemberDAO에서 다시 돌아와서 DB를 close(con)으로 닫고
//		dao에서 return 받은값(deleteResult)를 그대로 리턴한다. 그리고 다시 DeleteController로 간다.
		close(con);
//		메소드의 결과값을 return 한다 .		
		return deleteResult;
	}

}
