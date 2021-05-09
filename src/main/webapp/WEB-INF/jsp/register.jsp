<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="icon" href="data:;base64,=">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet" href="/login-style.css">
<title>Guest book</title>
</head>

<body>
	<div id="logreg-forms">

		<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">
			Guest book Sign up</h1>

		<c:if test="${error ne null}">
			<div style="color: red">${error}</div>
		</c:if>

		<form:form method="post" modelAttribute="user">
			<fieldset class="form-group">
				<form:label path="userName">User Name</form:label>
				<form:input path="userName" type="text" class="form-control"
					required="required" />
				<form:errors path="userName" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="password">Password</form:label>
				<form:input path="password" type="password" class="form-control"
					required="required" />
				<form:errors path="password" cssClass="text-warning" />
			</fieldset>

			<button type="submit" class="btn btn-primary btn-block">
				<i class="fas fa-user-plus"></i>Register
			</button>
			<a href="/"><i class="fas fa-angle-left"></i> Back</a>
			<br>

		</form:form>

	</div>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script src="/scripts.js"></script>
</body>
</html>