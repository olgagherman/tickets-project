<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<h2>Create Project</h2>
	<s:form>
		<s:textfield name="name" label="Name" value="%{name}" />
		<s:textarea label="Description" name="description" cols="30" rows="8" />
		<s:if test="%{id==null}">
			<s:submit value="Create" action="createProjectAction" />
		</s:if>
		<s:else>
			<s:submit value="Update" action="updateProjectAction" />
		</s:else>
	</s:form>
</div>
<s:include value="../footer.jsp" />