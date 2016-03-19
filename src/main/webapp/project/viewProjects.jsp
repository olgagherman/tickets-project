
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:include value="../header.jsp" />
<s:if test="projectList.size() > 0">
	<table border="1px" cellpadding="8px">
		<tr>
	
			<th>Name</th>
		  <th>Created Date</th>
			<th>Edit</th>
		</tr>
		<s:iterator value="projectList" status="projectStatus">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
				
				<td><a
					href=<s:url action="editProject">
						<s:param name="projectId" value="%{id}" />
					</s:url>>
						<img alt="Edit" src=<s:url value="/images/edit-icon.png"/>>
				</a>
				<a
					href=<s:url action="removeProject">
						<s:param name="projectId" value="%{id}" />
					</s:url>>
						<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
				</a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<br/>
<a href="registerProject">ADD new Project</a>
<s:include value="footer.jsp"/>