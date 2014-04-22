<%@ include file="header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="classes.File"%>
<%
	String logID = (String) request.getAttribute("logID");
	String name = (String) request.getAttribute("name");
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
		<form class="form" role="form">
			<h2 class="form-purpose-heading">
				Abuse Report Details -
				<%
				out.println(logID);
			%>
			</h2>
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
							+ "<input type=\"radio\" name=\"file\">  "
							+ file.getFileName() + "</div>");
				}
			%>
			<br>
			<button type="button" class="btn btn-lg btn-primary"
				name="pdfReviewBtn">Review As PDF</button>
			<button type="button" class="btn btn-lg btn-primary" name="editBtn">Edit</button>
			<button type="button" class="btn btn-lg btn-primary" name="deleteBtn">Delete</button>
			<button type="button" class="btn btn-lg btn-primary"
				name="downloadBtn">Download</button>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form-signin" role="form">
			<h2 class="form-purpose-heading">Upload New File</h2>
			<input type="file" class="form-control" placeholder="Select file"
				required="" autofocus=""> <br>
			<button class="btn btn-lg btn-primary" type="submit">Upload</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>