<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<link rel="stylesheet" type="text/css" href="css/project.css">
	<br>
	<div id="bodyObject">
		<div id="imag">
			<a
				href=<s:url action="getBodyProject">
	<s:param name="projectId" value="%{id}" />
	</s:url>>
				<img width=150px height=150px
				src=<s:url value="/images/Project-word.jpg"/>>
			</a>
		</div>
		<div id="description">
			<font size="5" color="orange">Name : <s:property value="name" /></font>

			<br> <font size="4" color="orange"> Created Date :<s:date
					name="createdDate" format="dd/MM/yyyy" /></font> <br> <font size="4"
				color="orange"> Description : <s:property value="description" /></font>
			<br>
		</div>
		<ul id="bodyProj">
			<li><a class="btn" href=<s:url action="#"> 									</s:url>>
					View Users </a></li>
			<li><a class="btn" href=<s:url action="viewUsers"> 									</s:url>>
					+ Add User </a></li>
			<li><a class="btn"
				href=<s:url action="editProject"> <s:param name="projectId" value="%{id}" /></s:url>>
					Edit </a></li>
			<li><a class="btn"
				href=<s:url action="removeProject"> <s:param name="projectId" value="%{id}" /></s:url>>
					Remove </a></li>
		</ul>
	</div>
	<br>
	<s:if test="userList.size() > 0">
		<table>
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
					</a> <a
						href=<s:url action="removeProjectUser">
							<s:param name="userId" value="%{id}" />
						</s:url>>
							<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
					</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:if>
</div>
<s:include value="../footer.jsp" />