<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
			<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
				<link rel="stylesheet" type="text/css" href="css/style.css">
					<link rel="stylesheet" type="text/css" href="css/header.css">
						<link rel="stylesheet" type="text/css" href="css/styleTable.css">
							<link rel="stylesheet" type="text/css" href="css/css.css">
								<link rel="stylesheet" type="text/css" href="css/css-common.css">
									<link rel="stylesheet" type="text/css" href="css/project.css">
										<script src="js/jquery.min.3.js" type="text/javascript"></script>
										<script src="js/jquery.js" type="text/javascript"></script>
										<title>Ticket</title>
</head>
<div id="header" class="navbar navbar-fixed-top">
	<div class="top">
		<div class="wFix">
			<h3>Ticket System</h3>
			<ul>
				<li><s:if test="%{#session.logged == null}">
						<a class="btn" href="login" title="Login">Login</a>
					</s:if> <s:if test="%{#session.logged == true}">
						<a class="btn" href="logout" title="Logout">Logout
							${sessionScope.userName}</a>
					</s:if></li>
			</ul>
		</div>
	</div>
	<div class="menu">
		<div class="wFix">
			<ul>
				<li><a class="btn activeH" href="welcomeBoard" title="Boards">Boards</a></li>
				<li><a class="btn" href="listTicketsAction" title="Tickets">Tickets</a></li>
				<li><a class="btn" href="listUsersAction" title="Users">Users</a></li>
				<li><a class="btn" href="listProjectsAction" title="Projects">Projects</a></li>

			</ul>
		</div>
	</div>
</div>