<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>图书信息检索</title>
</head>
  <body>
    <h1>作者信息检索</h1>
    <s:form action = "QueryByAuthor">
    	输入作者姓名:<s:textfield name="Authorname"/>
    		<s:submit value = "Submit"/>
    </s:form>    
  </body>
</html>