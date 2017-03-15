package com.imooc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
	public static void main(String[] args) {
		JdbcTest jt = new JdbcTest();
		//jt.testPlain();
		jt.testTransaction();

	}

	public void testTransaction() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itop", "root", "root");
			conn.setAutoCommit(false);
			String sql1 = "UPDATE ticket SET title=CONCAT(title,'','+1') WHERE id=1";
			String sql2 = "UPDATE ticket SET title=CONCAT(title,'','+2') WHERE id=2";
			Statement stmt = conn.createStatement();
			stmt.execute(sql1);
			String s = null;
			s.charAt(0);
			stmt.execute(sql2);
			conn.commit();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			if(conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void testPlain() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://168.46.6.19:3306/itop", "root", "passw0rd");
			String sql = "SELECT * FROM ticket WHERE id=238";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("title"));
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
