<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<link rel="stylesheet" type="text/css" href="css/project.css">
<div class="container-fluid margin-top-menu">
	
	<br>
	<div id="bodyObject">
		<div id="imag">
			<a
				href=<s:url action="getBodyTicket">
	<s:param name="ticketId" value="%{id}" />
	</s:url>>
				<img width=150px height=150px
				src=<s:url value="/images/tickets.jpg"/>>
			</a>
		</div>
		<div id="description">
			<font size="5" color="orange">Name : <s:property value="ticket.name" /></font>
			<br>
			<font size="5" color="orange">Complexity : <s:property value="ticket.complexity" /></font>
			<br>
            <font size="5" color="orange">Subject : <s:property value="ticket.subject" /></font>

			<br> <font size="4" color="orange"> Created Date :<s:date
					name="ticket.createdDate" format="dd/MM/yyyy" /></font> <br> <font size="4"
				color="orange"> Description : <s:property value="ticket.description" /></font>
			<br>
					<font size="5" color="orange">Proj name : <s:property value="nameProject" /></font>
			<br>
		</div>
		
	</div>
	<br>
	
</div>
<s:include value="../footer.jsp" />