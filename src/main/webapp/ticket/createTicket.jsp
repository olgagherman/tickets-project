<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<h2>Create Ticket</h2>
	<s:form>
	<s:hidden name="id" value="%{id}" />
		<s:textfield name="name" label="Name" value="%{name}" />
		<s:textfield name="subject" label="Subject" value="%{subject}" />
		
        <s:select style="width:173px;height:30px;"
			label="Select coplexity" headerKey="-1" list="listComplexity"
			name="ticketComplexity" />
			
		<s:select style="width:173px;height:30px;"
			label="Select name of Project" headerKey="-1" list="nameProjects"
			name="nameProject" />
	
		<s:if test="%{id==null}">
			<s:submit value="Create" action="createTicketAction" />
		</s:if>
		<s:else>

			<s:submit value="Update" action="updateTicketAction" />
		</s:else>
	</s:form>
</div>
<s:include value="../footer.jsp" />