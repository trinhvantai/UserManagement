<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css\bootstrap-3.3.7-dist\css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/listUser.css">
<title>All user</title>
</head>
<body>
	<div class="col-md-6 col-md-offset-3">
		<table>
			<tr>
				<th>User name</th>
				<th>Address</th>
				<th>Birthday</th>
				<th>Marital</th>
				<th>Job</th>
			</tr>
			<c:forEach items="${users}" var="user">
				<tr>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.address}" /></td>
					<td><fmt:formatDate pattern="yyyy-MMM-dd"
							value="${user.birthday}" /></td>
					<td><c:out value="${user.marital}" /></td>
					<td><c:out value="${user.job}" /></td>
					<td><a
						href="signup?action=edit&name=<c:out value="${user.name}"/>"><button
								type="submit" class="btn btn-primary col-md-6">Edit</button></a> <a
						href="signup?action=delete&name=<c:out value="${user.name}"/>"><button
								type="submit" class="btn btn-danger col-md-6">Delete</button></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
</html>