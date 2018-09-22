<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${lang.name}"/></title>
</head>
<body>
<a href="/languages">Dashboard</a>
<p><c:out value="${lang.name}"/></p>
<p><c:out value="${lang.creator}"/></p>
<p><c:out value="${lang.currentVersion}"/></p>
<a href="/languages/${lang.id}/edit">Edit</a>
<a href="/languages/${lang.id}/delete">Delete</a>
</body>
</html>