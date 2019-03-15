package com.tg.liststudy;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/Mymember/update")
public class MemberUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

		int mNo = Integer.parseInt(req.getParameter("no"));

		String sql = "";
		

		try {

			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");

			conn = DriverManager.getConnection(url, user, password);

			sql = "";
			
			sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, PWD";
			sql += " FROM MEMBERS";
			sql += " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);
			
			rs = pstmt.executeQuery();
			
			String mName = "";
			String email = "";
			String pwd = "";
			Date CreDate = null;
			
//			ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
			
			MemberDto memberDto = null;
			
			if(rs.next()) {
				
				mNo = rs.getInt("MNO");
				mName = rs.getString("MNAME");
				email = rs.getString("EMAIL");
				CreDate = rs.getDate("CRE_DATE");
				pwd = rs.getString("PWD");
				
				memberDto = new MemberDto();
				
				memberDto.setNo(mNo);
				memberDto.setName(mName);
				memberDto.setEmail(email);
				memberDto.setCreateDate(CreDate);
				memberDto.setPasword(pwd);
				
			}
			
//			while(rs.next()) {
//				mNo = rs.getInt("MNO");
//				mName = rs.getString("MNAME");
//				email = rs.getString("EMAIL");
//				CreDate = rs.getDate("CRE_DATE");
//				pwd = rs.getString("PWD");
//				
//				memberDto = new MemberDto();
//				
//				memberDto.setNo(mNo);
//				memberDto.setName(mName);
//				memberDto.setEmail(email);
//				memberDto.setCreateDate(CreDate);
//				memberDto.setPasword(pwd);
//				
//				
//				
//			}
			
			req.setAttribute("memberDto", memberDto);
			
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("./MymemberDetailView.jsp");
			
			dispatcher.include(req, res);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end


	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("MemberUpdateServlet의 doPost를 탄다.");
		Connection conn = null;
		PreparedStatement pstmt = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

		req.setCharacterEncoding("UTF-8");

		String emailStr = req.getParameter("EMAIL");
		int mno = Integer.parseInt(req.getParameter("no"));
		String nameStr = req.getParameter("NAME");
		String pwdStr = req.getParameter("PWD");

		String sql = "";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE MEMBERS";
			sql += " SET EMAIL = ?, MNAME = ?, MOD_DATE = SYSDATE";
			sql += " WHERE MNO = ?";
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, emailStr);
			pstmt.setString(2, nameStr);
			pstmt.setInt(3, mno);

			pstmt.executeUpdate(); // 수정이 이루워졌을때 사용

			res.sendRedirect("./list");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} // finally end

	}

}
