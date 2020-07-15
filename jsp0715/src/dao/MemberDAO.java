package dao;

import java.sql.*;

import dto.MemberDTO;


public class MemberDAO {
	private static MemberDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public static MemberDAO getInstance() {
		if(dao==null) {
			dao = new MemberDAO();
		}return dao;
	}
	
	public void setConnection(Connection con) {
		this.con=con;
	}

	public int memberJoin(MemberDTO member) {
		String sql ="INSERT INTO MEMBERT VALUES(?,?,?,?,?,?)";
		int result=0;
		
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getJsname());
			pstmt.setString(4, member.getBirth());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getEmail());
			result =pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	public String memberLogin(String id, String password) {
		String sql="SELECT ID FROM MEMBERT WHERE ID=?  AND PASSWORD=?";
		String loginId =null;
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			rs= pstmt.executeQuery();
//			rs =  값이 나오게  할수 있는 코드(sql문의 값 !)를 rs 에 저장
			
			if(rs.next()) {
				loginId=rs.getString(1);
			}else {
				loginId=null;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return loginId;
	}
}
