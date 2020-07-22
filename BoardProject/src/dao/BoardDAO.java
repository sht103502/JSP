package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static db.JdbcUtil.*;
import dto.BoardDTO;

public class BoardDAO {
	private static BoardDAO dao;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();

		}
		return dao;
	}

	public void setConnection(Connection con) {
		this.con = con;

	}

	public int BoardWrite(BoardDTO board) {
		String sql = "INSERT INTO BOARDTT VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, 0, ?)";
		//BOARD_SEQ.NEXTVAL : 게시글 번호 (자동 증가)
		//SYSDATE : 현재시간
		//0(BHIT) : 조회수 
		int daoResult = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getbWriter());
			pstmt.setString(2, board.getbPassword());
			pstmt.setString(3, board.getbTitle());
			pstmt.setString(4, board.getbContent());
			pstmt.setString(5, board.getbFile());
			
			daoResult = pstmt.executeUpdate();
			//제대로 DB에 등록되면 daoResult =1;
			//오류발생하면 daoResult =0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return daoResult;
	}

	public int ListCount() {
		String sql ="SELECT COUNT(*) FROM BOARDTT";
		int listCount =0;
		try {
			pstmt=con.prepareStatement(sql);
			rs =pstmt.executeQuery();
			if(rs.next()) {
				listCount =rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
	
		return listCount;
	}

	public List<BoardDTO> BoardList(int startRow, int endRow) {
		System.out.println("dao starRow :" + startRow);
		System.out.println("dao endRow :" + endRow);
		
		String sql ="SELECT * FROM BOARDLIST WHERE RN BETWEEN ? AND ?";
		List<BoardDTO> boardList =new ArrayList<BoardDTO>();
		BoardDTO board =null;
		
		try {
			pstmt =con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				board =new BoardDTO();
				board.setbNum(rs.getInt("BNUM"));
				board.setbWriter(rs.getString("BWRITER"));
				board.setbPassword(rs.getString("BPASSWORD"));
				board.setbTitle(rs.getString("BTITLE"));
				board.setbContent(rs.getString("BCONTENT"));
				board.setbDate(rs.getString("BDATE"));
				board.setbHit(rs.getInt("BHIT"));
				board.setbFile(rs.getString("BFILE"));
				
				//BoardDTO를 List<BoardDTO>에 담기
				boardList.add(board);
			}
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);	
		}
		
		return boardList;
	}

	public int BoardHit(int bNum) {
		String sql ="UPDATE BOARDTT SET BHIT = BHIT+1 WHERE BNUM =?";
		int hitResult =0;
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			hitResult =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return hitResult;
	}

	public BoardDTO BoardView(int bNum) {
		String sql ="SELECT *FROM BOARDTT WHERE BNUM=?";
		BoardDTO boardView =new BoardDTO();
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {//sqld에한개가뜨기때문에 while이 아닌 if를쓴다.
				boardView.setbNum(rs.getInt("BNUM"));
				boardView.setbWriter(rs.getString("BWRITER"));
				boardView.setbPassword(rs.getString("BPASSWORD"));
				boardView.setbTitle(rs.getString("BTITLE"));
				boardView.setbContent(rs.getString("BCONTENT"));
				boardView.setbDate(rs.getString("BDATE"));
				boardView.setbHit(rs.getInt("BHIT"));
				boardView.setbFile(rs.getString("BFILE"));
				
				//잘들어갔는지 확인하기
				boardView.toString();
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return boardView;
	}
	public int boardDelete(String bNum) {
		String sql="DELETE FROM BOARDTT WHERE BNUM=?";
		int deleteResult =0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, bNum);
			deleteResult =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
		}
		return deleteResult;
	}
	
	public int BoardModify(BoardDTO board) {
		String sql="UPDATE BOARDTT SET BTITLE=?, BCONTENT=?,BFILE=? WHERE BNUM=?";
		int modiResult =0;
		
		try {
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,board.getbTitle());
			pstmt.setString(2,board.getbContent());
			pstmt.setString(3,board.getbFile());
			pstmt.setInt(4,board.getbNum());
			modiResult =pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		System.out.println("modifyResult 결과값 : "+modiResult);
		return modiResult;
	}

}
