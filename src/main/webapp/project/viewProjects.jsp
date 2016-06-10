<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<link rel="stylesheet" type="text/css" href="css/project.css">
<div class="container-fluid margin-top-menu">
	
	<div style="float: left; width: 100%; margin: 10px 50px;">
		<s:if test="%{#session.admin ==true}">
		<a class="btn" style="float: left;"
			href=<s:url action="registerProject">	
		</s:url>> + Add Project
		</a>
		</s:if>
			<s:if test="%{#session.logged ==true}">
			<a class="btn" style="float: left;"
			href=<s:url action="userProjects">
					</s:url>> My Projects
		</a>
		</s:if>
	</div>
	<s:if test="projectList.size() > 0">
		<table class="zui-table zui-table-zebra zui-table-horizontal">
			<thead>
				<tr>
				<th>View</th>
					<th>Name</th>
					<th>Description</th>
					<th>Created Date</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="projectList" status="projectStatus">
					<tr>
						<td>
								
						<a
							href=<s:url action="getBodyProject">
						<s:param name="projectId" value="%{id}" /></s:url>>
						<img alt="Edit" src=<s:url value="/images/viewBody.png"/>>
						</a>
						
						<td>
								<s:property value="name" />
						</td>
						
						<td><s:property value="description" /></td>
						<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
	
</div>
<s:include value="../footer.jsp" />