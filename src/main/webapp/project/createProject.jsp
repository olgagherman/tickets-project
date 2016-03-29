<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />

<h2>Create Project</h2>
<s:form>
	<s:textfield name="name" label="Name" value="%{name}" />
	<s:textfield name="createdDate" label="Created Date" value="%{createdDate}" />
	<s:textarea label="Description" name="description" cols="30" rows="8"  />
	<s:if test="%{id==null}">
		<s:submit value="Create" action="createProjectAction" />
	</s:if>
	<s:else>
		<s:submit value="Update" action="updateProjectAction"/>
	</s:else>
</s:form>

<s:include value="../footer.jsp" />