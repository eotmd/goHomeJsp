<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div style="background-color: #000086; color: #ffffff; 
	height: 20px; padding: 5px;">

	SPMS(Simple Project Management System)
	<span style="float:right;">
		<c:if test="${sessionScope.member != null}">
			<a href="<%=request.getContextPath()%>/member/modify?no=${member.mno}"	style="color:white;">
				${sessionScope.member.name}
			</a>
			<a href="<%=request.getContextPath()%>/member/logout"	style="color:white;">
				로그아웃
			</a>
		</c:if>
		<c:if test="${sessionScope.member == null}">
			<a href="<%=request.getContextPath()%>/member/login"	style="color:white;">
				로그인
			</a>
		</c:if>
		
	</span>

</div>