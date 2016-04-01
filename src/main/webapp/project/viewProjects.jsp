
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:include value="../header.jsp" />
<link rel="stylesheet" type="text/css" href="css/project.css">

<div style="float: left; width: 100%; margin: 10px 50px;">
	<a class="btn" style="float: left;"
		href=<s:url action="registerProject"> 									</s:url>> + Add
		Project </a>
</div>

<s:if test="projectList.size() > 0">

	<table class="zui-table zui-table-zebra zui-table-horizontal">
		<thead>
			<tr>

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
			<s:property value="name" />
			</a>
			</td>
				<td><s:property value="description" /></td>
				<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
				
										
			</tr>
				



			</s:iterator>
		</tbody>
	</table>

</s:if>



<a href="registerProject">ADD new Project</a>
<s:include value="../footer.jsp" />