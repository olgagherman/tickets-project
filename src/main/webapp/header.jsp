<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
			<title>Library</title>
</head>

<body>

	<div id="container">
		<div id="mainpic">
			<h1>
				University<span class="lighter">Library</span>
			</h1>
			<h2>
				A template by UTM<br />
				<s:if test="%{#session.logged ==true}">
				Welcome <i>${sessionScope.userName}</i>
				</s:if>
			</h2>
		</div>

		<div id="menu">
			<ul>
				<s:if test="%{#session.logged ==false}">
					<li class="menuitem"><a href="login">Login</a></li>
				</s:if>
				<s:else>
					<li class="menuitem"><a href="logout">Logout</a></li>
				</s:else>
				<li class="menuitem"><a href="#">Newest</a></li>
				<li class="menuitem"><a href="#">Most popular</a></li>
				<li class="menuitem"><a href="#">Authors</a></li>
				<s:if test="%{#session.logged ==true}">
					<li class="menuitem"><a href="#">Upload</a></li>
					<li class="menuitem"><a href="#">Download</a></li>
				</s:if>
				<s:if test="%{#session.admin ==true}">
					<li class="menuitem"><a href="listUsersAction">Users</a></li>
				</s:if>
			</ul>
		</div>

		<div id="content">
			<a href="index.jsp">Home</a>