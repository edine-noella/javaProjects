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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<body>
<center>
<h1 style="font-size: 40px">Students Management</h1>
<h2>
    <a href="/demo_war_exploded/new" style="font-size: 40px;color: darkblue">Add New Student</a>
    &nbsp;&nbsp;&nbsp;
    <a href="/demo_war_exploded/list" style="font-size: 40px;color: darkblue">List All Students</a>
</h2>
</center>
<div style = "margin:30px" >
    <p><label style="padding: 5px; font-weight: bold; color: darkblue">Student Id:  </label><c:out value="${viewStudent.id}"/></p>
    <p><label style="padding: 5px; font-weight: bold; color: darkblue">FirstName:  </label><c:out value="${viewStudent.firstName}"/></p>
    <p><label style="padding: 5px; font-weight: bold; color: darkblue">LastName:  </label><c:out value="${viewStudent.lastName}"/></p>
    <p><label style="padding: 5px; font-weight: bold; color: darkblue">Gender:  </label><c:out value="${viewStudent.gender}"/></p>
    <p><a href="/demo_war_exploded/edit?id=<c:out value='${student.id}' />">Edit</a>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <a href="/demo_war_exploded/delete?id=<c:out value='${student.id}' />">Delete</a></p>
</div>
</body>
</html>

