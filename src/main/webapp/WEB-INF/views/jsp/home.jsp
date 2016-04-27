<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<div align="center">
            <h1>Contact List</h1>
            <h3><a href="/blog/newEntry">New Entry</a></h3>
            <table border="1">
            	<tr>
                <th>title</th>
                <th>text</th>
                <th>posted_timestamp</th>
                <th>category</th>
                </tr> 
                 
                <c:forEach var="entry" items="${listEntry}" varStatus="status">
                <tr>
                    <td>${entry.title}</td>
                    <td>${entry.text}</td>
                    <td>${entry.posted_timestamp}</td>
                    <td>${entry.category}</td>
                    <td>
                        <a href="/blog/editEntry?id=${contact.id}">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/blog/deleteEntry?id=${contact.id}">Delete</a>
                    </td>
                             
                </tr>
                </c:forEach>             
            </table>
        </div>
        
</body>
</html>