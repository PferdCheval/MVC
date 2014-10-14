
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新书籍</title>
</head>
	<body>
		<h1>更新书籍数据</h1>
			<s:form action = "Bookupdate">
				AuthorName:<s:textfield name="Name"/>
				Publisher:<s:textfield name="Publisher"/>
				PublishDate:<s:textfield name="PublishDate"/>
				Price:<s:textfield name="Price"/>
				ISBN:<s:textfield name="ISBN"/>
				<s:submit value = "Submit"/>
			</s:form>
	</body>
</html>