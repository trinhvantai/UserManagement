<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css\bootstrap-3.3.7-dist\css\bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/signup.css">
<title>SignUp</title>
</head>
<body>
	<div class="col-md-4 col-md-offset-4 form">
		<h2>SIGN UP</h2>
		<form action="edit" method="post">
			<div class="row">
				<label class="lb"> Username: </label><input class="inp" type="text"
					name="name" value="<c:out value=" ${user.name}" />" />
			</div>
			<br>
			<div class="row">
				<label class="lb"> Password: </label> <input class="inp" type="text"
					name="password" value="<c:out value=" ${user.password}"/>" />
			</div>
			<br>
			<div class="row">
				<label class="lb"> Address: </label> <input class="inp" type="text"
					name="address" value="<c:out value=" ${user.address}"/>" />
			</div>
			<br>
			<div class="row">
				<label class="lb"> Birthday: </label> <input class="inp" type="text"
					name="birthday" value="<c:out value=" ${user.birthday}"/>" />
			</div>
			<br>
			<div class="row">
				<label class="lb"> Marital: </label> <input class="inp" type="text"
					name="marital" value="${user.marital}"
					value="<c:out value=" ${user.marital}" />" />
			</div>
			<br>
			<div class="row">
				<label class="lb"> Job: </label> <input class="inp" type="text"
					name="job" value="<c:out value=" ${user.job}" />" />
			</div>
			<div class="row div-submit">
				<button type="submit" class="btn btn-primary col-md-12">Submit</button>
			</div>

		</form>
	</div>

</body>
</html>