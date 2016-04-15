<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="form" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<s:include value="../header.jsp" />
<div class="container-fluid margin-top-menu">

<s:if test="userList.size() > 0">
		<table class="zui-table zui-table-zebra zui-table-horizontal">
			<thead>
				<tr>
					<th>Name</th>
					<th>Surname</th>
					<th>Email</th>
				    <th>Chose</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="userList" status="userStatus">
					  <tr>
					 	<td><s:property value="name" /></td>
						<td><s:property value="surname" /></td>
						<td><s:property value="email" /></td>
						<td>
							<input type="checkbox"  checked="checked" id="<s:property value="id"/>"/>
							<label for="<s:property value="id"/>">choose</label></td>
                      </tr>
				</s:iterator>
			</tbody>
		</table>
	</s:if>
</div>


<s:include value="../footer.jsp"/>


