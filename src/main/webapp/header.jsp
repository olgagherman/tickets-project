<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/login.css">
			<link rel="stylesheet" type="text/css" href="css/header.css">
				<title>Ticket</title>
</head>

<header>
<p>
	<font size="5" color="blue">Ticket System</font> <font size="4"
		color="green" style="float: right"> <s:if
			test="%{#session.logged ==true}">
				Welcome <i>${sessionScope.userName}</i>
		</s:if>
	</font>
</p>
</header>