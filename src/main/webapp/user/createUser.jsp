<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<h2>Register user</h2>
	<s:form>
	<s:hidden name="id" value="%{id}" />
		<s:textfield name="name" label="Name" value="%{name}" />
		<s:textfield name="surname" label="Surname" value="%{surname}" />
			<s:textfield name="phoneNumber" label="Phone " value="%{phoneNumber}" />
		<s:if test="%{#session.admin ==true}">
   <s:checkbox label="Is Admin" name="is_admin" value="is_admin" fieldValue="true"/>
   </s:if>
		
		<s:textfield name="email" label="Email" value="%{email}" />
		<s:password name="password" label="Password" value="" />
		<s:if test="%{id==null}">
			<s:submit value="Create" action="createUserAction" />
		</s:if>
		<s:else>
			<s:submit value="Update" action="updateUserAction" />
		</s:else>
	</s:form>
</div>
<s:include value="../footer.jsp" />