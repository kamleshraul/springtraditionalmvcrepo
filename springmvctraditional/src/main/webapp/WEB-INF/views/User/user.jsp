<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Page</title>
<!-- <link rel="stylesheet" href="css/app.css"/> -->
<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
	
		<spring:hasBindErrors name="user">
			<c:forEach var="error" items="${errors.allErrors}">
				<c:if test="${error.field=='valid'}">
					<div class="alert alert-warning" role="alert">
  						<b><spring:message message="${error}" /></b>
					</div>
				</c:if>
			</c:forEach>
    	</spring:hasBindErrors>
		<div class="row justify-content-end">
			<span class="col-4">
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">${exampleSessionAttribute}</h5>
						<h6 class="card-subtitle mb-2 text-muted">No login yet</h6>
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						<a href="#" class="card-link">Card link</a> <a href="#"
							class="card-link">Another link</a>
					</div>
				</div>
			</span>
		</div>

		<form:form method="post" modelAttribute="user" action="create-user-with-valiation">
			<form:hidden path="guid"/>
			
			
			<div class="form-group row">
				<form:label path="amount" class="col-sm-2 col-form-label">Amount</form:label>
				<form:input path="amount" type="text" required="required" class="col-sm-4 form-control"/>
				<form:errors path="amount" cssClass="text-warning col"></form:errors>
			</div>
			<div class="form-group row">
				<form:label path="userId" class="col-sm-2 col-form-label">UserId</form:label>
				<form:input path="userId" type="text" required="required" class="col-sm-4 form-control"/>
				<form:errors path="userId" cssClass="text-warning col"></form:errors>
			</div>
			<div class="form-group row">
				<form:label path="country" class="col-sm-2 col-form-label">Country</form:label>
				<form:select path="country" items="${countryList}" cssClass="col-sm-2 form-control"></form:select>
			</div>
			<div class="form-group row">
				<form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
				<form:input path="name" type="text" required="required" class="col-sm-4 form-control"/>
				<form:errors path="name" cssClass="text-warning col"></form:errors>
			</div>
			
			<div class="form-group row">
				<form:label path="birthDate" class="col-sm-2 col-form-label">Birth Date</form:label>
				<form:input path="birthDate" type="text" required="required" class="col-sm-4 form-control"/>
				
			</div>
			<div class="form-group row">
				<form:label path="password" class="col-sm-2 col-form-label">Passowrd</form:label>
				<form:password path="password" required="required" class="col-sm-4 form-control"/>
				<form:errors path="password" cssClass="text-warning col"></form:errors>
			</div>
			<div class="form-group row">
				<form:label path="password2" class="col-sm-2 col-form-label">Confirm Password</form:label>
				<form:password path="password2" required="required" class="col-sm-4 form-control"/>
				<form:errors path="password2" cssClass="text-warning col"></form:errors>
			</div>
			<div class="form-group row">
				
				<div class="col-sm-2 offset-sm-2">
					<form:button value="Submit" class="btn btn-primary">Submit</form:button>
				</div>
			</div>
		</form:form>
	
</div>


<script src="scripts/jquery/jquery.min.js"></script>
<script src="scripts/popper.js/popper.min.js"></script>
<script src="scripts/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>