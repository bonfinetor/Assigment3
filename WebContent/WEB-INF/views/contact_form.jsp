<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="//cdn.muicss.com/mui-0.10.3/css/mui.min.css" rel="stylesheet" type="text/css" />
    	<script src="//cdn.muicss.com/mui-0.10.3/js/mui.min.js"></script>
    	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" />
		<title>New/Edit Contact</title>
	</head>
	<body>
    	<div align="center" class="mui-container">
	        <div class="mui--text-display4" align="center">New/Edit Contact</div>
	        <form:form action="save" method="post" modelAttribute="contact">
	        <table>
	            <form:hidden path="id"/>
	            <tr>
	                <td class="mui--text-display1" >Name:</td>
	                <td class="mui-textfield"><form:input path="name" /></td>
	            </tr>
	            <tr>
	                <td class="mui--text-display1" >Email:</td>
	                <td class="mui-textfield"><form:input path="email" /></td>
	            </tr>
	            <tr>
	                <td class="mui--text-display1" >Address:</td>
	                <td class="mui-textfield"><form:input path="address" /></td>
	            </tr>
	            <tr>
	                <td class="mui--text-display1" >Phone:</td>
	                <td class="mui-textfield"><form:input path="phone" /></td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center"><input type="submit" value="Save" class="mui-btn mui-btn--raised mui-btn--primary"></td>
	            </tr>
	        </table>
	        </form:form>
	    </div>
	</body>
</html>