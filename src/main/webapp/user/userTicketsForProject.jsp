<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="form" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<link rel="stylesheet" type="text/css" href="css/project.css">
<div class="container-fluid margin-top-menu">
	<br>
	<div id="bodyObject">
		<div id="imag">
			<a
				href=<s:url action="getBodyProject">
					<s:param name="projectId" value="projectId" />
				</s:url>>
				<img width=150px height=150px
				src=<s:url value="/images/Project-word.jpg"/>>
			</a>
		</div>
		<div id="description">
			<font size="5" color="orange">Name : <s:property
					value="project.name" /></font> <br> <font size="4" color="orange">
				Created Date : <s:date name="project.createdDate"
					format="dd/MM/yyyy" />
			</font> <br> <font size="4" color="orange"> Description : <s:property
					value="project.description" />
			</font> <br>
		</div>
		<div class="bodyProject">
			<ul id="bodyProj">
				<li><a class="btn"
					href=<s:url action="viewProjectsUsers"> 
							<s:param name="projectId" value="projectId" />	
					</s:url>>
						View Users </a></li>
				<li><a class="btn"
					href=<s:url action="viewUsersWithoutThisProject" > 
						<s:param name="projectId" value="projectId" />	
					</s:url>>
						+ Add User </a></li>
				<li><a class="btn"
					href=<s:url action="editProject"> 
						<s:param name="projectId" value="projectId" />
					</s:url>>
						Edit </a></li>
				<li><a class="btn"
					href=<s:url action="removeProject"> 
						<s:param name="projectId" value="projectId" />
					</s:url>>
						Remove </a></li>
			</ul>
		</div>
	</div>
	<br>
</div>
<font size="5" color="orange">User Project Tickets</font>
<s:if test="userProjectTickets.size() > 0">
	<table class="zui-table zui-table-zebra zui-table-horizontal">
		<thead>
			<tr>
				<th>Name</th>
				<th>subject</th>
				<th>complexity</th>
				<th>Created Date</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="userProjectTickets"
				status="userProjectTicketsStatus">
				<tr>
					<td><a
						href=<s:url action="getBodyTicket">
						<s:param name="ticketId" value="%{id}" /></s:url>>
							<s:property value="name" />
					</a></td>
					<td><s:property value="subject" /></td>
					<td><s:property value="complexity" /></td>
					<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>

					<td><a
						href=<s:url action="editTicket">
						<s:param name="ticketId" value="%{id}" />
					</s:url>>
							<img alt="Edit" src=<s:url value="/images/edit-icon.png"/>>
					</a> <a
						href=<s:url action="removeTicket">
						<s:param name="ticketId" value="%{id}" />
					</s:url>>
							<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
					</a></td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>

<s:include value="../footer.jsp" />