
<%@ taglib prefix="s" uri="/struts-tags"%>




<s:include value="../header.jsp" />

<link rel="stylesheet" type="text/css" href="css/stylesTree.css">
<a  href="listTicketsAction">
<!-- <div>
<font size="5" color="blue" style="float:left">View all tickets</font>
</div> -->
</a>
<br>
<div id="treeMenu">
<ol class="tree">
	
		<li>
			<label for="folder2">Folder 2</label> <input type="checkbox" id="folder2" /> 
			<ol>
			<s:iterator value="projectList" status="projectStatus">
				<li class="file"><a href=""><s:property value="name" /></a></li>
				</s:iterator>
				
			</ol>
		</li>
		<li>
			<label for="folder3">Folder 3</label> <input type="checkbox" id="folder3" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder3">Subfolder 1</label> <input type="checkbox" id="subfolder3" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
		<li>
			<label for="folder4">Folder 4</label> <input type="checkbox" id="folder4" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder4">Subfolder 1</label> <input type="checkbox" id="subfolder4" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
		<li>
			<label for="folder5">Folder 5</label> <input type="checkbox" id="folder5" /> 
			<ol>
				<li class="file"><a href="">File 1</a></li>
				<li>
					<label for="subfolder5">Subfolder 1</label> <input type="checkbox" id="subfolder5" /> 
					<ol>
						<li class="file"><a href="">Subfile 1</a></li>
						<li class="file"><a href="">Subfile 2</a></li>
						<li class="file"><a href="">Subfile 3</a></li>
						<li class="file"><a href="">Subfile 4</a></li>
						<li class="file"><a href="">Subfile 5</a></li>
						<li class="file"><a href="">Subfile 6</a></li>
					</ol>
				</li>
			</ol>
		</li>
	</ol>
	</div>
<s:include value="footer.jsp"/>