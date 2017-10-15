<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="css\bootstrap-3.3.7-dist\css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<div class="background col-md-4 col-md-offset-4">
		<h2>SIGN IN</h2>
		<form action="login" method="post">
			<div class="row">
				<label class="lb col-md-4"> Username: </label> <input
					class="inp col-md-8" type="text" name="name"
					value='<c:out value="${acc.name }"></c:out>' />
			</div>
			<br>
			<div class="row">
				<label class="lb col-md-4"> Password: </label> <input
					class="inp col-md-8" type="text" name="password"
					value='<c:out value="${acc.password }"></c:out>' />
			</div>
			<div class="row div-signin">
				<button type="submit" class="btn btn-primary col-md-12">Sign
					in</button>
			</div>

		</form>
	</div>
</body>
</html>