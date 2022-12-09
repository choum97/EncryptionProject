<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20224003 김요한 암호화</title>
</head>
<body>
	<h3>파일업로드 (암호화/복호화)</h3>
	<form action="uploadProc.jsp" method="post" enctype="multipart/form-data">
		유형 :	
		<input type="radio" name="category" value="encrypt" checked /> 암호화 
		<input type="radio" name="category" value="decrypt"/> 복호화<br>
		<input type="file" name="attachedFile"/><br>
		<input type="submit" value="업로드"/>
	</form>
	
	<hr>
	<h3>해쉬값 구하기</h3>
	<form action="hashProc.jsp">
		문자열 : <input type="text" name="plainText"><br>
		<input type="radio" name="algorithm" value="MD5"> md5
		<input type="radio" name="algorithm" value="SHA-1"> sha-1
		<input type="radio" name="algorithm" value="SHA-256" checked="checked"> sha-256
		<input type="radio" name="algorithm" value="SHA-384"> sha-384
		<input type="radio" name="algorithm" value="SHA-512"> sha-512<br>
		
		<input type="submit" value="해쉬값 구하기">
	</form>
</body>
</html>