<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
  
	<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
			<link rel="stylesheet" type="text/css" href="css/header.css">
<link rel="stylesheet" type="text/css" href="css/styleTable.css">
				<title>Ticket</title>

		
</head>

<body>
<p>
	<font size="5" color="blue">Ticket System</font> <font size="4"
		color="green" style="float: right"> 
		<s:if test="%{#session.logged ==true}">
		Welcome <i>${sessionScope.userName}</i>
		</s:if>
	</font>
</p>


<div id="head">
<ul>
	<li><a class="activeH" href="board">Board</a></li>
	<li><a href="listTicketsAction">Tickets</a></li>
	<li><a href="listUsersAction">Users</a></li>
	<li><a href="listProjectsAction">Projects</a></li>

<!--  <li>
 
 <a 	href=<s:url action="getBodyProject">
<s:param name="projectId" value="%{1}" />
</s:url>>
	Project
				</a>
 
 </li> -->
	<s:if test="%{#session.logged == false}">
		<li style="float: right"><a href="login">Login</a></li>
	
	<s:else>
		<li style="float: right"><a href="logout">Logout</a></li>
	</s:else>
</s:if>
</ul>
</div>

