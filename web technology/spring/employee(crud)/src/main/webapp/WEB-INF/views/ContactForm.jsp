<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New/Edit Contact</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Contact</h1>
		<form:form action="saveContact" method="post" modelAttribute="contact">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name" required="required"/></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" required="required"/></td>
				</tr>
				<tr>
					<td>Telephone:</td>
					<td><form:input path="telephone" required="required"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>