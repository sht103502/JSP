package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static db.JdbcUtil.*;
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

	public List<MemberDTO> memberList() {
		String sql ="SELECT *FROM MEMBERT ORDER BY JSNAME ASC";
		List<MemberDTO> memberList =new ArrayList<MemberDTO>();
		MemberDTO member =null;
		try {
			pstmt =con.prepareStatement(sql);
			rs = pstmt.executeQuery();
//			찾는사람이 한명인지 여러명인지 모르기때문에 !while 문을 사용 ()
			while(rs.next()){
//				처음에 멤버를 초기화 시켜주고
				member = new MemberDTO();
//				멤버 아이디를 가져온다.
				member.setId(rs.getString("ID"));
				member.setPassword(rs.getString("PASSWORD"));
				member.setJsname(rs.getString("JSNAME"));
				member.setBirth(rs.getString("BIRTH"));
				member.setGender(rs.getString("GENDER"));
				member.setEmail(rs.getString("EMAIL"));
				memberList.add(member);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return memberList;
	}

	public MemberDTO memberView(String id) {
		String sql ="SELECT *FROM MEMBERT WHERE ID=?";
		MemberDTO memberView =new MemberDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				memberView.setId(rs.getString("ID"));
				memberView.setPassword(rs.getString("PASSWORD"));
				memberView.setJsname(rs.getString("JSNAME"));
				memberView.setBirth(rs.getString("BIRTH"));
				memberView.setGender(rs.getString("GENDER"));
				memberView.setEmail(rs.getString("EMAIL"));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
//			JdbcUtil 에서 존재하는 메소드를 가져온것
			close(pstmt);
			close(rs);
		}
		return memberView;
	}

	public int memberDelete(String delId) {
		String sql ="DELETE FROM MEMBERT WHERE ID=?";
		int deleteResult =0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, delId);
			deleteResult =pstmt.executeUpdate();
			
			}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			
		}
		return deleteResult;
	}

	public int memberModify(MemberDTO member) {
		String sql="UPDATE MEMBERT SET JSNAME=?, EMAIL=? WHERE ID=?";
		int modifyResult =0;
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,member.getJsname());
			pstmt.setString(2,member.getEmail());
			pstmt.setString(3,member.getId());
			modifyResult =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("modifyResult 결과값 : "+modifyResult);
		return modifyResult;
	}
	
}
