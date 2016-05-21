<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<link rel="stylesheet" type="text/css" href="css/project.css">
<div class="container-fluid margin-top-menu">
	
	


<s:if test="usersList.size() > 0">
		<s:form action="addUserToTheTicket">
		<table class="zui-table zui-table-zebra zui-table-horizontal">
			<tr>
			<th>Select</th>
				<th>Name</th>
				<th>Surname</th>
				<th>Email</th>
				<th>Created Date</th>
				<th>Is Administrator</th>
				
			</tr>
			<s:iterator value="usersList" status="userStatus">
				<td>
				<a class="btn" href=
					<s:url action="addUserToTheTicket" > 
							 <s:param name="userId" value="%{id}" />
							 <s:param name="ticketId" value="%{ticket.id}" />
					</s:url>
				>
					Select  
				</a>
				</td>
				<tr>
					<td>	
								<s:property value="name" />
						
						</td>
					<td><s:property value="surname" /></td>
					<td><s:property value="email" /></td>
					<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
					<td><s:property value="admin" /></td>
									</tr>
			</s:iterator>
		</table>
		
			<s:submit value="Add users to the Ticket"/>
		</s:form>
	</s:if> 


</div>

<s:include value="../footer.jsp" />