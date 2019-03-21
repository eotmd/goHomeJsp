package com.study.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/boardUpdate")
public class BoardUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		int boardno = Integer.parseInt(req.getParameter("boardno"));

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
		String sql = "";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "SELECT B.BOARDNO, M.MNO, B.CONTENTS, B.TITLE, M.EMAIL, B.CRE_DATE";
			sql += " FROM MEMBERS M, BOARD B";
			sql += " WHERE M.MNO = B.MNO";
			sql += " AND B.BOARDNO = ?";
			
			
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, boardno);

			rs = pstmt.executeQuery();

			System.out.println("퀴리수행 성공");
			
			
			int bno = 0;
			int mno = 0;
			String btitle = "";
			String contents = "";
			String id = "";
			Date createDate = null;
			//데이터베이스에서 회원정보를 가져와 MemberDto에 담는다 그리고 MemberDto객체를 어레이리스트에 추가한다.
			BoardDto boardDto = null;
			if (rs.next()) {
				bno = rs.getInt("BOARDNO");
				mno = rs.getInt("MNO");
				btitle = rs.getString("TITLE");
				contents = rs.getString("CONTENTS");
				id = rs.getString("EMAIL");
				createDate = rs.getDate("CRE_DATE");

				boardDto = new BoardDto(bno, mno, btitle, contents, id, createDate);
				
				
			} // while end
			//리스트에 있는 데이터를 키 설정을 해주고 값을 넣는다.
			req.setAttribute("boardDto", boardDto);//맵형태
			
			
			//req(HttpServletRequest)와 res(HttpServletResponse)를 포함시켜서 jsp로 출력을 위임한다.
			RequestDispatcher dispatcher = req.getRequestDispatcher("./form/boardUpdateForm.jsp");
			
			
			dispatcher.forward(req, res);
			
			
			System.out.println("완료?");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			System.out.println("너냐?");
			e.printStackTrace();
			
//			req.setAttribute("error", e);
//			RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
//			dispatcher.forward(req, res);
			
		}  finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // if(rs != null) end

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

		String titleStr = req.getParameter("title");
		System.out.println(req.getParameter("boardno"));
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		String contentsStr = req.getParameter("contents");
		

		String sql = "";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "UPDATE BOARD";
			sql += " SET TITLE = ?, CONTENTS = ?, MOD_DATE = SYSDATE";
			sql += " WHERE BOARDNO = ?";
			
			
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, titleStr);
			pstmt.setString(2, contentsStr);
			pstmt.setInt(3, boardno);

			pstmt.executeUpdate(); // 수정이 이루워졌을때 사용

			res.sendRedirect("/TeamSite/boarddetail?boardno="+boardno);

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
