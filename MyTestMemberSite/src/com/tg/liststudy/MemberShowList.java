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

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.tg.liststudy.MemberDto;


@WebServlet(value = "/Mymember/list")
public class MemberShowList extends GenericServlet{
	
	@Override
	public void service(ServletRequest req, ServletResponse res) 
			throws ServletException, IOException {
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
			
			sql = "SELECT MNO, MNAME,PWD ,EMAIL, CRE_DATE, MOD_DATE";
			sql += " FROM MEMBERS";
			sql += " ORDER BY MNO ASC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();	
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			List<MemberDto> memberList = new ArrayList<MemberDto>();
			
			int mno = 0;
			String mname = "";
			String email = "";
			String pwd = "";
			Date createDate = null;
			Date modifiedDate = null;
			
			while(rs.next()) {
				mno = rs.getInt("MNO");
				mname = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				pwd = rs.getString("PWD");
				createDate = rs.getDate("CRE_DATE");
				modifiedDate = rs.getDate("MOD_DATE");
				
				MemberDto memberDto = new MemberDto(mno, mname, email, pwd, createDate, modifiedDate);
				memberList.add(memberDto);
			} // while end
			
			req.setAttribute("memberList", memberList);
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Mymember/ListView.jsp");
			
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


