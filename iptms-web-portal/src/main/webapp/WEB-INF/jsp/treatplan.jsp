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
				<hr></hr>
		<h1 class="text-center">Treatment Plan</h1>
		<hr></hr>
			<div>
				<table class="table table-hover table-bordered">
				  <thead>
				    <tr>
				      <th scope="col">S.No.</th>
				      <th scope="col">Name</th>
				      <th scope="col">Test Details</th>
				      <th scope="col">Package</th>
				       <th scope="col">Specialist</th>
				      <th scope="col">Cost</th>
				      <th scope="col">Start date</th>
				      <th scope="col">End date</th>
				       <th scope="col">Status</th>
				    </tr>
				  </thead>
				  <tbody>
				    <tr>
				      <th scope="row">1</th>
				      <td>${plan.ptDetail.name}</td>
				      <td>${plan.testDetails}</td>
				      <td>${plan.packageName}</td>
				      <td>${plan.specialist}</td>
				      <td>${plan.cost}</td>
				      <td>${plan.treatmentCommencementDate}</td>
				      <td>${plan.treatmentEndDate}</td>
				      <td>${plan.status}</td>
				    </tr>
				
				  </tbody>
				</table>
			</div>
		</div>
	</body>
</html>