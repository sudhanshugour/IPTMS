<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!doctype html>
<html lang="en">
	<head>
		<title></title>
		<%@ include file="headlink.jsp"%>
		<link href="css/basic.css" rel="stylesheet" type="text/css">
		<script src="js/basic.js"></script>
	</head>
	<body>
	
			<div class="container-fluid">
		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="offset-md-4 col-md-4 offset-lg-4 col-lg-4 text-center">
				<form id="contact" action="/login" model="user"  method="post">
					<h3>Admin Login Form</h3>
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="User name" name="userid" type="text" tabindex="1" required>
						</div>
					</fieldset>
					
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Password" name="upassword" type="password" tabindex="1" required>
						</div>
					</fieldset>
		
					<fieldset>
						<button name="submit" type="submit" id="contact-submit"
							data-submit="...Sending">Submit</button>
					</fieldset>
					
				</form>
			</div>
		</div>
	</div>
	</body>
</html>









x