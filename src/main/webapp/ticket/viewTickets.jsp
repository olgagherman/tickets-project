
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:include value="../header.jsp" />
<s:if test="ticketList.size() > 0">
	<table border="1px" cellpadding="8px">
		<tr>
	
			<th>Name</th>
			<th>subject</th>
			<th>complexity</th>
			<th>Created Date</th>
			
		</tr>
		<s:iterator value="ticketList" status="ticketStatus">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="subject" /></td>
				<td><s:property value="complexity" /></td>
				<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>
				
				<td><a
					href=<s:url action="editTicket">
						<s:param name="ticketId" value="%{id}" />
					</s:url>>
						<img alt="Edit" src=<s:url value="/images/edit-icon.png"/>>
				</a>
				<a
					href=<s:url action="removeTicket">
						<s:param name="ticketId" value="%{id}" />
					</s:url>>
						<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
				</a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
<br/>
<a href="register">Register new user</a>
<s:include value="footer.jsp"/>