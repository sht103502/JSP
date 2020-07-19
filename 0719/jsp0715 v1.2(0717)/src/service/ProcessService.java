package service;

import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import dto.MemberDTO;

public class ProcessService {

	public int memberModify(MemberDTO member) {
		MemberDAO dao= MemberDAO.getInstance();//sql초기화
		Connection con=getConnection();//DB연결
		dao.setConnection(con);//데이터베이스와 dao를 연결시켜준다.
		
//		int modifyResult =결과에 따라 commit 을 할지rollback 을 할지 정하기 위해 선언해준 변수		
		int modifyResult =dao.memberModify(member);
//		dao.memberModify(member) Dao에 있는 memberModify(member)의 return 값		
		
		//MemberDAO 클래스에 있는 memberModify 메소드의 return 값
		//dao.result=?
				
		if(modifyResult>0) {
//			modifyResult 값이 0보다 크다면 (정상실행시) commit 실행			
			commit(con);
		}else {
//			modifyResult 값이 0이라면 or 0보다 작다면 rollback 실행
			rollback(con);
		}
		close(con);
//		메소드의 결과값을 return 한다 .		
		return modifyResult;		
	}

}
