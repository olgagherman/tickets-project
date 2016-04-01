<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />

<h2>Create Ticket</h2>
<s:form>
	<s:textfield name="name" label="Name" value="%{name}" />
	<s:textfield name="subject" label="Subject" value="%{subject}" />
	<s:textfield name="createdDate" label="Created Date" value="%{createdDate}" />
	<s:textfield name="complexity" label="Complexity" value="%{complexity}" />
	
 <s:select label="What's your favor search engine" 
	headerKey="-1"
		list="nameProjects" 
		name="nameProject" /> 
	
	
	<s:if test="%{id==null}">
		<s:submit value="Create" action="createTicketAction" />
	</s:if>
	<s:else>
		<s:submit value="Update" action="updateTicketAction"/>
	</s:else>
</s:form>

<s:include value="../footer.jsp" />