<%@ include file="header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="classes.File"%>
<%
	String logID = (String) request.getAttribute("logID");
	String name = (String) request.getAttribute("name");
	String username = (String) request.getAttribute("username");
	List<File> files = (List<File>) request.getAttribute("files");
%>
<script>
	function disableBtn(btnName) {
		document.getElementsByName(btnName)[0].disabled = true;
	}
	function enableBtn(btnName) {
		document.getElementsByName(btnName)[0].disabled = false;
	}
</script>
<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form" role="form" method="post" action="">
			<h2 class="form-purpose-heading">
				Abuse Report Details -
				<%
				out.println(logID);
			%>
				<%
				out.println(username);
			%>
			</h2>
			<input type="hidden" name="logID" value="<% out.println(logID); %>">
			<input type="hidden" name="username" value="<% out.println(username); %>">
			<div class="jumbotron jumptron-inner"
				onclick="disableBtn('deleteBtn');enableBtn('editBtn');"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="abusereport"> Abuse
				Report
			</div>
			<div class="jumbotron jumptron-inner"
				onclick="disableBtn('deleteBtn');enableBtn('editBtn');"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="corrective">
				CorrectiveActions.txt
			</div>
			<%
				Iterator<File> iterator = files.iterator();
								while (iterator.hasNext()) {
					File file = iterator.next();
					out.println("<div class=\"jumbotron jumptron-inner\" "
							+ "onclick=\"enableBtn('deleteBtn');disableBtn('editBtn');\""
							+ "style=\"padding: 10px; margin-bottom: 5px;\">"
							+ "<input type=\"radio\" name=\"Letter_"
							+ file.getFileName() + "\">  " + file.getFileName()
							+ "</div>");
				}
			%>
			<br>
			<button type="button" class="btn btn-lg btn-primary"
				name="pdfReviewBtn">Review As PDF</button>
			<button type="button" class="btn btn-lg btn-primary" name="editBtn">Edit</button>
			<button type="submit" class="btn btn-lg btn-primary"
				onclick="this.parentNode.action='DeleteFileControl';"
				name="deleteBtn">Delete</button>
			<button type="button" class="btn btn-lg btn-primary"
				name="downloadBtn">Download</button>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form-signin" role="form" action="UploadFileControl"
			method="post" enctype="multipart/form-data">
			<h2 class="form-purpose-heading">Upload New File</h2>
			<input type="hidden" name="logID" value="<% out.println(logID); %>">
			<input type="hidden" name="username" value="<% out.println(username); %>">
			<input type="file" class="form-control" name="file"
				placeholder="Select file" required="" autofocus=""> <br>
			<button class="btn btn-lg btn-primary" type="submit">Upload</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>