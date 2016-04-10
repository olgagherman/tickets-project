<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="css/css-bootstrap/bootstrap.min.css">
			<link rel="stylesheet" type="text/css" href="css/style.css">
				<link rel="stylesheet" type="text/css" href="css/login.css">
					<link rel="stylesheet" type="text/css" href="css/header.css">
						<link rel="stylesheet" type="text/css" href="css/styleTable.css">
							
							<title>Ticket</title>
</head>
<div id="header" class="navbar navbar-fixed-top">
	<div class="row" style="font-size: 17px; color: blue;">
		<div id="ticket-system" class="col-md-10">Ticket System</div>
		<div class="col-md-2 text-center">
			<s:if test="%{#session.logged == null}">
				<a href="login">Login</a>
			</s:if>
			<s:if test="%{#session.logged == true}">
				<a href="logout">Logout <i>${sessionScope.userName}</i></a>
			</s:if>
		</div>
	</div>
	<div class="row">
		<div class="container-fluid">
			<ul>
				<li><a class="activeH" href="board">Board</a></li>
				<li><a href="listTicketsAction">Tickets</a></li>
				<li><a href="listUsersAction">Users</a></li>
				<li><a href="listProjectsAction">Projects</a></li>
			</ul>
		</div>
	</div>
</div>