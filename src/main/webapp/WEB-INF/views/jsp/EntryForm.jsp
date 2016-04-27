<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Entry</title>
</head>
<body>
	<div align="center">
        <h1>New/Edit Entry</h1>
        <form:form action="saveEntry" method="post" modelAttribute="entry">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>title:</td>
                <td><form:input path="title" /></td>
            </tr>
            <tr>
                <td>text:</td>
                <td><form:input path="text" /></td>
            </tr>
            <tr>
                <td>posted_timestamp:</td>
                <td><form:input path="posted_timestamp" /></td>
            </tr>
            <tr>
                <td>category:</td>
                <td><form:input path="category" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>

</body>
</html>