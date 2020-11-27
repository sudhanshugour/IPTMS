<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!doctype html>
<html lang="en">
	<head>
		<title>Insurer Page</title>
		<%@ include file="headlink.jsp"%>
		<link href="css/basic.css" rel="stylesheet" type="text/css">
		<script src="js/basic.js"></script>
		
	</head>
	<body>
		<div class="container-fluid">
		<%@ include file="header.jsp"%>
		
		
		<!-- Start Your code from here   -->
		
		<hr></hr>
		<h1 class="text-center">Available Insurers</h1>
		<hr></hr>
			<div>
				<table class="table table-hover table-bordered">
				  <thead>
				    <tr>
				      <th scope="col">Column1</th>
				      <th scope="col">Column2</th>
				      <th scope="col">Column3</th>
				      <th scope="col">Column4</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">1</th>
				      <td>Mark</td>
				      <td>Otto</td>
				      <td>@mdo</td>
				    </tr>
				   
				  </tbody>
				</table>
			</div>
		
		</div>
	</body>
</html>