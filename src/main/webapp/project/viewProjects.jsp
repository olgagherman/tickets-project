
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:include value="../header.jsp" />
<link rel="stylesheet" type="text/css" href="css/project.css">
<s:if test="projectList.size() > 0">


	<s:iterator value="projectList" status="projectStatus">
		<br>
		<div id="rcorners5">
			<div id="imag">
				<a
					href=<s:url action="getBodyProject">
<s:param name="projectId" value="%{id}" />
</s:url>>
					<img width=150px height=150px
					src=<s:url value="/images/Project-word.jpg"/>>
				</a>
			</div>
			<div id="#description">
				<font size="5" color="orange">Name : <s:property value="name" /></font>

<br>
				<font size="4" color="orange">	Created Date :<s:date name="createdDate" format="dd/MM/yyyy" /></font>
			<br>
			
			<font size="4" color="orange">	Description :	<s:property value="description" /></font>
			<br>
				<div id="editProj">
				<a
					href=<s:url action="editProject">
						<s:param name="projectId" value="%{id}" />
					</s:url>>
					<img alt="Edit" src=<s:url value="/images/edit-icon.png"/>>
				</a> <a
					href=<s:url action="removeProject">
						<s:param name="projectId" value="%{id}" />
					</s:url>>
					<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
				</a>
				</div>
			</div>
		</div>
	</s:iterator>

</s:if>



	<a href="registerProject">ADD new Project</a>
	<s:include value="../footer.jsp" />