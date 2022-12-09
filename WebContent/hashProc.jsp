<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="proSecurity.Hash"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String plainText = request.getParameter("plainText");
		String algorithm = request.getParameter("algorithm");
		Hash hash = new Hash();
			
		String md = hash.getHash(plainText, algorithm);
	%>
	입력받은 값 : <%=plainText %><br>
	알고리즘 : <%=algorithm %> <br>
	Message Digest : <%=md %>
</body>
</html>