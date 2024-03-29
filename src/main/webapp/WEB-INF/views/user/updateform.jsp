<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="kr.co.itcen.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UserVo updatevo = (UserVo) request.getAttribute("updateUser");
%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.servletContext.contextPath }/assets/css/user.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="user">
				<form id="update-form" name="updateForm" method="post"
					action="${pageContext.servletContext.contextPath }/user">
					<input type='hidden' name='a' value='update' /> <label
						class="block-label" for="name">이름</label> <input id="name"
						name="name" type="text" value=""> <label
						class="block-label" for="email">이메일</label>
					<c:forEach items='${list }' var='vo' varStatus='status'>

						<h4><%=updatevo.getEmail()%></h4>

						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="">

						<fieldset>
							<legend>성별</legend>


							<%
								if ("male".equals(updatevo.getGender())) {
							%>
							<label>여</label> <input type="radio" name="gender" value="female">
							<label>남</label> <input type="radio" name="gender" value="male"
								checked="checked">
							<%
								} else {
							%>

							<label>여</label> <input type="radio" name="gender" value="female"
								checked="checked"> <label>남</label> <input type="radio"
								name="gender" value="male">
							<%
								}
							%>

						</fieldset>

					</c:forEach>

					<input type="submit" value="수정하기">

				</form>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>