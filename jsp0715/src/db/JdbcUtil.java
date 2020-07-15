package db;

import java.sql.*;
import javax.naming.*;
import javax.sql.*;

public class JdbcUtil {

	public static Connection getConnection() {
		Connection con = null;

		try {
			Context initCtx = new InitialContext();
			
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			DataSource ds = (DataSource) envCtx.lookup("jdbc/OracleDB");

			con = ds.getConnection();
			con.setAutoCommit(false);
			System.out.println("DB접속 성공!");

		} catch (Exception e) {
			System.out.println("DB접속 실패!");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// (4) commit
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// (5) rollback
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
