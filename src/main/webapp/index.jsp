<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="%{#session.logged ==false}">

<jsp:forward page = "login.jsp" />

	</s:if>
	

<s:include value="header.jsp"/>

<s:include value="footer.jsp"/>

