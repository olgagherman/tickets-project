<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<link rel="stylesheet" type="text/css" href="css/project.css">
	<br>
	<div id="bodyObject">
		<div id="imag">
			<a
				href=<s:url action="getBodyUser">
	<s:param name="userId" value="%{user.id}" />
	</s:url>>
				<img width=150px height=150px
				src=<s:url value="/images/user.png"/>>
			</a>
		</div>
		<div id="description">
			<font size="5" color="orange">Name : <s:property value="user.name" /></font>
			<br>
			<font size="5" color="orange">Surname : <s:property value="user.surname" /></font>
			<br>
<font size="5" color="orange">Email : <s:property value="user.email" /></font>

			<br> <font size="4" color="orange"> Created Date :<s:date
					name="user.createdDate" format="dd/MM/yyyy" /></font> <br>
			<font size="5" color="orange">Is Administrator : <s:property value="user.admin" /></font>
			<br>
		</div>
		<ul id="bodyProj">
			<li><a class="btn" href=<s:url action="#"> 									</s:url>>
					Tickets</a></li>
			<li><a class="btn" href=<s:url action="#"> 									</s:url>>
					## </a></li>
			<li><a class="btn"
				href=<s:url action="editUser"> <s:param name="userId" value="%{user.id}" /></s:url>>
					Edit </a></li>
			<li><a class="btn"
				href=<s:url action="removeUser"> <s:param name="userId" value="%{user.id}" /></s:url>>
					Remove </a></li>
		</ul>
	</div>
	<br>
	
</div>

	<font size="5" color="orange">User Projects</font>
	<s:if test="projects.size() > 0">
		<table class="zui-table zui-table-zebra zui-table-horizontal">
			<thead>
				<tr>
					<th>Name</th>
					<th>Description</th>
					<th>Created Date</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="projects" status="projectsStatus">
					<tr>
						<td>
							<s:url action="getUresProjectTickets" var="viewUserProjectTicketUrl">
									<s:param name="projectId" value="%{id}" />
									<s:param name="userId" value="%{id}" />
							</s:url>
							<s:a href="%{viewUserProjectTicketUrl}"> ${name} </s:a> 
						</td>
						<td><s:property value="description" /></td>
						<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>

<s:include value="../footer.jsp" />