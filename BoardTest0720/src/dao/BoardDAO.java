package dao;

import java.sql.*;
import java.util.*;

import dto.BoardDTO;


import static db.JdbcUtil.*;

public class BoardDAO {
	
private static BoardDAO dao;
Connection con;
PreparedStatement pstmt;
ResultSet rs;

	public static BoardDAO getInstance() {
		if(dao==null) {
			dao=new BoardDAO();
		}
		
		return dao;
	}
	public void setConnection(Connection con) {
		this.con= con;
	}
	public int BoardWrite(BoardDTO board) {
		String sql="INSERT INTO BOARDT1 VALUES(?,?,?,?,SYSDATE)";
		int daoResult =0;
		
		try{
			pstmt =con.prepareStatement(sql);
			
			pstmt.setString(1,board.getbWriter() );
			pstmt.setString(2,board.getbPassword() );
			pstmt.setString(3,board.getbTitle() );
			pstmt.setString(4,board.getbContent() );
			
			daoResult =pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return daoResult;
	}
	public List<BoardDTO> BoardList() {
		String sql="SELECT * FROM BOARDT1";
		List<BoardDTO>boardList =new ArrayList<BoardDTO>();
		BoardDTO board =null;
		
		try {
			pstmt =con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			while(rs.next()) {//BoardDTO 갯수만큼 반복
				board =new BoardDTO();//board를 초기화
				
				//board 필드값 설정 setter()
				board.setbWriter(rs.getString("BWRITER"));
				board.setbPassword(rs.getString("BPASSWORD"));
				board.setbTitle(rs.getString("BTITLE"));
				board.setbContent(rs.getString("BCONTENT"));
				board.setbDate(rs.getString("BDATE"));
				//rs.getString("Column_Name") :데이터베이스 검색값 
				
				boardList.add(board);//하나의 BoardDTO(board)를 List(daoList)에 추가
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			
		}
		return boardList;
	}
	public BoardDTO BoardView(String bTtitle) {
		String sql="SELECT *FROM BOARDT1 WHERE BTITLE=?";
		BoardDTO boardView =new BoardDTO();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bTtitle);
			System.out.println(bTtitle);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				boardView.setbWriter(rs.getString("BWRITER"));
				boardView.setbPassword(rs.getString("BPASSWORD"));
				boardView.setbTitle(rs.getString("BTITLE"));
				boardView.setbContent(rs.getString("BCONTENT"));
				boardView.setbDate(rs.getString("BDATE"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		return boardView;
	}
	
	public int boardDelete(String bTtitle) {
		String sql="DELETE FROM BOARDT1 WHERE BTITLE=?";
		int deleteResult =0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bTtitle);
			deleteResult =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return deleteResult;
	}
	
	public int boardModify(BoardDTO bTitle) {
		String sql="UPDATE BOARDT1 SET BTITLE=?, BCONTENT=? WHERE BWRITER=?";
		int modifyResult =0;
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,bTitle.getbTitle());
			pstmt.setString(2,bTitle.getbContent());
			pstmt.setString(3,bTitle.getbWriter());
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
