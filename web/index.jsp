<%--
  Created by IntelliJ IDEA.
  User: Feng
  Date: 2017/1/11
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:forward page="${pageContext.request.contextPath}/IndexServlet">
    <jsp:param value="index" name="method"/>
</jsp:forward>
</body>
</html>
