package com.study.board;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value="/main")
public class BoardList extends HttpServlet{
	
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

			sql = "SELECT B.BOARDNO, B.TITLE, M.EMAIL, B.CRE_DATE";
			sql += " FROM MEMBERS M, BOARD B";
			sql += " WHERE M.MNO = B.MNO";
			sql += " ORDER BY B.BOARDNO ASC";
			
			
			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			System.out.println("퀴리수행 성공");
			
//			res.setContentType("text/html");
//			res.setCharacterEncoding("UTF-8");
			//리퀘스트에 회원목록 데이터 보관
			ArrayList<BoardDto> boardList = new ArrayList<BoardDto>();
			
			
			int bno = 0;
			String btitle = "";
			String id = "";
			Date createDate = null;
			//데이터베이스에서 회원정보를 가져와 MemberDto에 담는다 그리고 MemberDto객체를 어레이리스트에 추가한다.
			BoardDto boardDto = null;
			while (rs.next()) {
				bno = rs.getInt("BOARDNO");
				btitle = rs.getString("TITLE");
				id = rs.getString("EMAIL");
				createDate = rs.getDate("CRE_DATE");

				boardDto = new BoardDto(bno, btitle, id, createDate);
				boardList.add(boardDto);
				
			} // while end
			//리스트에 있는 데이터를 키 설정을 해주고 값을 넣는다.
			req.setAttribute("boardList", boardList);//맵형태
			
			
			//req(HttpServletRequest)와 res(HttpServletResponse)를 포함시켜서 jsp로 출력을 위임한다.
			RequestDispatcher dispatcher = req.getRequestDispatcher("./form/boardListForm.jsp");
			
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
		// TODO Auto-generated method stub
		
		
		
		
	}
}
