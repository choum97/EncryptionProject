<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="proSecurity.Security"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%
	String saveDirectory = application.getRealPath("/upload");
	int maxPostSize = 10 * 1024 * 1024;
	String encoding = "utf-8";
	
	//파일 생성
	File folder = new File(saveDirectory);  
	if(!folder.exists()) folder.mkdir();
	
	
	MultipartRequest mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding);
	String fileName = mr.getFilesystemName("attachedFile");
	String category = mr.getParameter("category");
	
	String fileFullName = saveDirectory + File.separator + fileName;
	
	System.out.println("파일명 : " + fileFullName);
	System.out.println("유형 : " + category);
	
	Security securityBean = Security.getInstance();
	
	if(category.equals("encrypt")) {
		securityBean.encrypt(fileFullName);
	}
	else if(category.equals("decrypt")) {
		securityBean.decrypt(fileFullName);
	}
	
%>