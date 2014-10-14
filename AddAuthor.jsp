<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加作者</title>
</head>
	<body>
		<h1>添加作者信息</h1>
		<s:form action="AddAuthor">
			AuthorID:<s:textfield name="AuthorID"/>
			Name:<s:textfield name="Name"/>
			Age:<s:textfield name="Age"/>
			Country:<s:textfield name="Country"/>
			<s:submit value="Submit"/>
    </s:form>
	</body>
</html>