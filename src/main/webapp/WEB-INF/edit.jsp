<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${lang.name}"/></title>
</head>
<body>
<a href="/languages/<c:out value="${lang.id }"/>/delete">Delete</a>
<a href="/languages">Dashboard</a>
<form:form action="/languages" method="put" modelAttribute="preLang">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input value="${lang.name }" path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:input value="${lang.creator }" path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input value="${lang.currentVersion }" path="currentVersion"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>