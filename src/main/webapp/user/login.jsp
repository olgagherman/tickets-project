<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link href='http://fonts.googleapis.com/css?family=Varela+Round'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script
	src="<s:url value="https://code.jquery.com/jquery-1.12.0.min.js" />"></script>
<script
	src="<s:url value="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"/>"></script>
<script src="<s:url value="js/jquery.js" />"></script>

<div class="text-center" style="padding: 100px 0">
	<div class="logo">login</div>
	<!-- Main Form -->
	<div class="login-form-1">
		<s:form id="login-form" class="text-left" action="loginauth"
			theme="simple" method="post">
			<div class="login-form-main-message">
				<s:if test="hasActionErrors()">
					<div class="errors">
						<s:actionerror />
					</div>
				</s:if>
				<s:property value="exception" />
			</div>
			<div class="main-login-form">
				<div class="login-group text-left">
					<div class="form-group">
						<label for="lg_username" class="sr-only"></label>
						<s:textfield type="text" class="form-control" id="lg_username"
							name="email" placeholder="username" />
					</div>
					<div class="form-group">
						<label for="lg_password" class="sr-only"></label>
						<s:password type="password" class="form-control" id="lg_password"
							name="password" placeholder="password" />
					</div>
					<div class="form-group login-group-checkbox">
						<input type="checkbox" id="lg_remember" name="lg_remember">
						<label for="lg_remember">remember</label>
					</div>
				</div>
				<button type="submit" class="login-button" name="login">
					<i class="fa fa-chevron-right"></i>
				</button>
			</div>
			<div class="etc-login-form">
				<p>
					new user? <a href="register">create new account</a>
				</p>
			</div>
		</s:form>
	</div>
	<!-- end:Main Form -->
</div>