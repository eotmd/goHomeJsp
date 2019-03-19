package com.tg.liststudy;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tg.liststudy.MemberDto;


@WebServlet(value="/auth/login")
public class MemberLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = req.getSession();

		MemberDto memberDto = (MemberDto)session.getAttribute("member");
		
		if(memberDto == null) {
			RequestDispatcher rd = req.getRequestDispatcher("./LoginForm.jsp");
			rd.forward(req, res);
			
		}else {
			String contextPathStr = req.getContextPath()+"/Mymember/list";
			res.sendRedirect(contextPathStr);
		}
		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp";

		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		String name = "";

		String sql = "";
		int colIndex = 1; // 컬럼 위치

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);

			sql = "SELECT MNAME, EMAIL";
			sql += " FROM MEMBERS";
			sql += " WHERE EMAIL = ?";
			sql += " AND PWD = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(colIndex++, email);
			pstmt.setString(colIndex, pwd);

			rs = pstmt.executeQuery();

			System.out.println("퀴리수행 성공");

			// 리퀘스트에 회원목록 데이터 보관

			// 데이터베이스에서 회원정보를 가져와 MemberDto에 담는다 그리고 MemberDto객체를 어레이리스트에 추가한다.
			if (rs.next()) {

				email = rs.getString("email");
				name = rs.getString("mname");
				//생성자 방식으로 해보기
				MemberDto memberDto = new MemberDto(name,email);
				
				
				HttpSession session = req.getSession();
				session.setAttribute("member", memberDto);

				res.sendRedirect("../Mymember/list");

			} //else {
//				RequestDispatcher dispatcher = req.getRequestDispatcher("LoginFail.jsp");
//				dispatcher.forward(req, res);
//			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();

			req.setAttribute("error", e);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/error.jsp");
			dispatcher.forward(req, res);

		} finally {
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
}
