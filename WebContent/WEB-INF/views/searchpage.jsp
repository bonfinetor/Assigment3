<%@ page language="java" contentType="text/html; charset= ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Contact Manager Search</title>
        <link href="//cdn.muicss.com/mui-0.10.3/css/mui.min.css" rel="stylesheet" type="text/css" />
    	<script src="//cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
    	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
    </head>
    <body>
        <div class="mui-container">
            <div class="mui--text-display4" align="center">Contact Manager</div>
            <table  align="center">
            	<td><h3><a href="home" class="mui-btn mui-btn--raised mui-btn--primary">Home</a></h3></td>
            	<td>
            		<form name="ricerca" action="search?search=" method="get" class="mui-form--inline">
            			<div class="mui-textfield"><input type="search" name="search" id="cerca" placeholder="Search here..."></div>
           				<input type="submit" value="Search" class="mui-btn mui-btn--raised mui-btn--primary">
					</form>
				</td>           		
           	</table>
            <table class="mui-table mui-table--bordered">
            	<form:hidden path="id" />
	            <tr>
	            	<th>No</th>
	                <th>Name</th>
	                <th>Email</th>
	                <th>Address</th>
	                <th>Phone</th>
	                <th>Action</th>
	            </tr>
                <c:forEach items="${listContact}" var="contact" varStatus="status">
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${contact.name}</td>
                    <td>${contact.email}</td>
                    <td>${contact.address}</td>
                    <td>${contact.phone}</td>
                    <td>
                        <a href="edit?id=${contact.id}" class="mui-btn mui-btn--raised mui-btn--primary">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="delete?id=${contact.id}" class="mui-btn mui-btn--danger">Delete</a>
                    </td>         
                </tr>
                </c:forEach>             
            </table>
        </div>
    </body>
</html>