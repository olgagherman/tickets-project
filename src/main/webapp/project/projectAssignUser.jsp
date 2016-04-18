<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="form" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">

	<s:if test="userList.size() > 0">
		<s:form action="addUserToTheProject">
			<s:hidden value="%{projectId}" name="projectId" />
			<s:checkboxlist list="userList" listKey="id" listValue="name"
				name="selectedUsers"/>
			<s:submit value="Add users to the project"/>
		</s:form>
	</s:if>
</div>


<s:include value="../footer.jsp" />


