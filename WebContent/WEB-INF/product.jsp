<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>测试 Spring 的 CustomDateEditor 的效果</h2>
	<form action="${pageContext.request.contextPath}/saveProduct/">
		name:<input value="" name="name" placeholder="不能含有  vic  三个字符"><br>
		date:<input value="" name="date" placeholder="输入  2018,6,3 时间格式">
		<input type="submit">
	</form>
	<hr>
	<h2>测试 自定义 的 ProductEditor 的效果</h2>
	<form action="${pageContext.request.contextPath}/saveProductFromText/">
		productStr:<input value="" name="productStr"
			placeholder="productName#2018,8,8"><br> <input
			type="submit">
	</form>
	<hr>
	<h2>运行结果</h2>
	${product }
</body>
</html>