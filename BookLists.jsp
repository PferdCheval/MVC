<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
<script type="text/javascript">
function details(e)
{
	var BookTitle = document.getElementById("BookTitle");
	window.location.href = "getDetail?BookTitle="+e.innerHTML;
}
</script>
</head>
	<body>
		<h1>该作者所著书籍</h1>
		<s:property value = "Authorname"/>
		
		<table border="1">
			<s:iterator value="BookList" id="String" status = "status">
			<tr>
			<td>
				<p id="BookTitle"><p clickable="clickable" onclick="details(this);"><s:property value="String"/> </p> </p> 
				
			</td>
			</tr>
			</s:iterator>
		</table>
	</body>
</html>