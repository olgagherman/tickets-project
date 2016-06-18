<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<div style="float: left; width: 100%; margin: 10px 50px;">
		<s:if test="%{#session.admin ==true}">
			<a class="btn" style="float: left;"
				href=<s:url action="register">
			</s:url>> + Add User </a>
		</s:if>

	</div>
	<br>
	<s:if test="userList.size() > 0">
		<table class="zui-table zui-table-zebra zui-table-horizontal">
			<thead>
				<tr>

					<th>View</th>
					<th>Name</th>
					<th>Surname</th>
					<th>Email</th>
					<th>Created Date</th>
					<th>Is Administrator</th>
					<th>Phone Number</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="userList" status="userStatus">
					<tr>
						<td><a
							href=<s:url action="getBodyUser">
						<s:param name="userId" value="%{id}" /></s:url>>
								<img alt="Edit" src=<s:url value="/images/viewBody.png"/>>
						</a></td>
						<td><s:property value="name" /></td>
						<td><s:property value="surname" /></td>
						<td><s:property value="email" /></td>
						<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
						<td><s:property value="admin" /></td>
						<td><s:property value="phoneNumber" /></td>
						<td><s:if test="%{#session.admin ==true}">
								<a
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
								</a>
							</s:if></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
	<br />
</div>
<s:include value="../footer.jsp" />
