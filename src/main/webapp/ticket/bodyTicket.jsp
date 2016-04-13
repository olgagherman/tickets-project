<%@ taglib prefix="s" uri="/struts-tags"%>
<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">
	<link rel="stylesheet" type="text/css" href="css/project.css">
	<br>
	<div id="bodyObject">
		<div id="imag">
			<a
				href=<s:url action="getBodyTicket">
	<s:param name="ticketId" value="%{id}" />
	</s:url>>
				<img width=150px height=150px
				src=<s:url value="/images/Project-word.jpg"/>>
			</a>
		</div>
		<div id="description">
			<font size="5" color="orange">Name : <s:property value="name" /></font>
			<br>
			<font size="5" color="orange">Complexity : <s:property value="complexity" /></font>
			<br>
<font size="5" color="orange">Subject : <s:property value="subject" /></font>

			<br> <font size="4" color="orange"> Created Date :<s:date
					name="createdDate" format="dd/MM/yyyy" /></font> <br> <font size="4"
				color="orange"> Description : <s:property value="description" /></font>
			<br>
		</div>
		<ul id="bodyProj">
			<li><a class="btn" href=<s:url action="#"> 									</s:url>>
					View Users </a></li>
			<li><a class="btn" href=<s:url action="#"> 									</s:url>>
					+ Add User </a></li>
			<li><a class="btn"
				href=<s:url action="editProject"> <s:param name="projectId" value="%{id}" /></s:url>>
					Edit </a></li>
			<li><a class="btn"
				href=<s:url action="removeProject"> <s:param name="projectId" value="%{id}" /></s:url>>
					Remove </a></li>
		</ul>
	</div>
	<br>
	
</div>
<s:include value="../footer.jsp" />