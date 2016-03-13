<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />

<s:if test="userList.size() > 0">
	<table border="1px" cellpadding="8px">
		<tr>
			<th>Name</th>
			<th>Surname</th>
			<th>Email</th>
			<th>Created Date</th>
			<th>Is Administrator</th>
			<th>Edit</th>
		</tr>
		<s:iterator value="userList" status="userStatus">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="surname" /></td>
				<td><s:property value="email" /></td>
				<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
				<td><s:property value="admin" /></td>
				<td><a
					href=<s:url action="editUser">
						<s:param name="userId" value="%{id}" />
					</s:url>>
						<img alt="Edit" src=<s:url value="/images/edit-icon.png"/>>
				</a>
				<a
					href=<s:url action="removeUser">
						<s:param name="userId" value="%{id}" />
					</s:url>>
						<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
				</a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<br/>
<a href="register">Register new user</a>

<s:include value="../footer.jsp" />
