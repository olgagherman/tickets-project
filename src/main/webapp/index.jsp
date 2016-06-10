<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<s:include value="header.jsp" />
<!-- <meta http-equiv="refresh" content="0; URL="./" /> -->
<div id="board-items" class="container-fluid margin-top-menu">
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a class="board-item">
				Remained tickets
				<span>
				 <s:property value="userTickets" />
				</span>
			</a>
		</div>
		<div class="col-md-2">
			<a class="board-item">
				In pending
				<span>0</span>
			</a>
		</div>
		<div class="col-md-2">
			<a class="board-item">
				Closed in 30d
				<span>1</span>
			</a>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-2">
			<a class="board-item">
				Today tickets
				<span>0</span>
			</a>
		</div>
		<div class="col-md-2">
			<a class="board-item">
				Total tickets in 1w
				<span>5</span>
			</a>
		</div>
		<div class="col-md-2">
			<a class="board-item">
				Total tickets in 30d
				<span>6</span>
			</a>
		</div>
		<div class="col-md-3"></div>
	</div>
</div>
<s:include value="footer.jsp" />