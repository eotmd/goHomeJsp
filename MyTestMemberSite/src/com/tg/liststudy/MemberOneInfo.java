package com.tg.liststudy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/MyMember/one")
public class MemberOneInfo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		String sql = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE";
			sql += " FROM MEMBERS";
			sql += " where email = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();	
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			
			
			int mno = 0;
			String mname = "";
			String email = "";
			String pwd = "";
			Date createDate = null;
			Date modifiedDate = null;
			
			if(rs.next()) {
				mno = rs.getInt("MNO");
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				createDate = rs.getDate("CRE_DATE");
				
				MemberDto memberDto = new MemberDto(mno, mname, email, createDate);
				
				req.setAttribute("memberDto",memberDto);
			} // while end
			
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Mymember/InfoView.jsp");
			
			dispatcher.include(req, res);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end
	}
}
