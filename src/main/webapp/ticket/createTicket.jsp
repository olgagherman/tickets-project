<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />

<h2>Register user</h2>
<s:form>
	<s:textfield name="name" label="Name" value="%{name}" />
	<s:textfield name="subject" label="Subject" value="%{subject}" />
	<s:textfield name="createdDate" label="Created Date" value="%{createdDate}" />
	<s:password name="complexity" label="Complexity" value="%{complexity}" />
	<s:if test="%{id==null}">
		<s:submit value="Create" action="createTicketAction" />
	</s:if>
	<s:else>
		<s:submit value="Update" action="updateTicketAction"/>
	</s:else>
</s:form>

<s:include value="../footer.jsp" />