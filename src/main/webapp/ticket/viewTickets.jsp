
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<div style="float: left; width: 100%; margin: 10px 50px;">
		<a class="btn" style="float: left;"
			href=<s:url action="registerTicket"> 		
			</s:url>> + Add Ticket </a>
	</div>
	<br>
	<s:if test="ticketList.size() > 0">
		<table class="zui-table zui-table-zebra zui-table-horizontal">
			<thead>
				<tr>
				<th>View</th>
					<th>Name</th>
					<th>subject</th>
					<th>complexity</th>
					<th>Created Date</th>
					<th>State</th>
					
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="ticketList" status="ticketStatus">
					<tr>
						<td>
						
						<a
							href=<s:url action="getBodyTicket">
						<s:param name="ticketId" value="%{id}" /></s:url>>
						<img alt="Edit" src=<s:url value="/images/viewBody.png"/>>
						</a>
						<td>
								<s:property value="name" />
						</td>
						<td><s:property value="subject" /></td>
						<td><s:property value="complexity" /></td>
						<td><s:date name="createdDate" format="dd/MM/yyyy" /></td>

						<td><a
							href=<s:url action="editTicket">
						<s:param name="ticketId" value="%{id}" />
					</s:url>>
								<img alt="Edit" src=<s:url value="/images/edit-icon.png"/>>
						</a> <a
							href=<s:url action="removeTicket">
						<s:param name="ticketId" value="%{id}" />
					</s:url>>
								<img alt="Remove" src=<s:url value="/images/delete-icon.png"/>>
						</a></td>
						<td><s:property value="state" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
	<br />
</div>
<s:include value="../footer.jsp" />