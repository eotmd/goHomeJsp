package com.study.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(value="/boardAdd")
public class BoardAdd extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.sendRedirect("./form/boardAddForm.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";
		
//		req.setCharacterEncoding("UTF-8");
		
		String titleStr = req.getParameter("title");
		String contentsStr = req.getParameter("contents");
		int mno = Integer.parseInt(req.getParameter("mno"));
		
		String sql = "";
		
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
			sql = "INSERT INTO board";
			sql += "(boardno, mno, title,contents,cre_date, mod_date)";
			sql += "values(board_boardno_seq.nextval, ?, ?, ?, sysdate, sysdate)";
			

			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mno);
			pstmt.setString(2, titleStr);
			pstmt.setString(3, contentsStr);
			
			pstmt.executeUpdate();			//수정이 이루워졌을때 사용
			
			
			res.sendRedirect("./main");
			
			
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
			dispatcher.forward(req, res);
			
		} finally {		
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
