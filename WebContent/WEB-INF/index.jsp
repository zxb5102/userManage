<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
	index.jsp

	<h2>文件上传示例</h2>
	<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
		<label>name<input type="text" name="name" /></label> <label><input
			type="file" name="file" /> <input type="submit" /></label>
	</form>
</body>
</html>