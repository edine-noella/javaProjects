<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 5/14/2021
  Time: 6:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>View student</title>
</head>
<body>
<div style = "margin:20px">
    <p><label>Id:  </label><c:out value="${viewStudent.id}"/></p>
    <p><label>FirstName:  </label><c:out value="${viewStudent.firstName}"/></p>
    <p><label>LastName:  </label><c:out value="${viewStudent.lastName}"/></p>
    <p><label>Gender:  </label><c:out value="${viewStudent.gender}"/></p>
</div>
</body>
</html>
