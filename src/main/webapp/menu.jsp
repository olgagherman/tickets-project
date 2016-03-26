<ul>
  <li><a class="active"  href="board">Board</a></li>
  <li><a href="listTicketsAction">Tickets</a></li>
  <li><a href="listUsersAction">Users</a></li>
    <li><a href="listProjectsAction">Projects</a></li>
   
  <s:if test="%{#session.logged == false}">
					<li style="float:right"><a href="login">Login</a></li>
				</s:if>
				<s:else>
					<li style="float:right"><a href="logout">Logout</a></li>
				</s:else>
 
</ul>