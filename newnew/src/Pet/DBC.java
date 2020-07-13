package Pet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBC {
	
	public static Connection DBConnect() {
		Connection con = null;
		
		try {
			// 1. ojdbc 없이 실행
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			String user = "SHINHEETAE"; 
			String password = "1111";
			
			// 2. url, user, password 틀리고실행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB 접속 성공");
		} catch(ClassNotFoundException cne) {
			cne.printStackTrace(); // 에러 발생시 경로를 찾아준다.
			System.out.println("DB 접속 실패 : 드라이버 로딩 실패");
		} catch(SQLException se) {
			se.printStackTrace();
			System.out.println("DB 접속 실패 : url, user, password 확인");
		}
		
		return con; // Connection 의 리턴타입
	}
}
