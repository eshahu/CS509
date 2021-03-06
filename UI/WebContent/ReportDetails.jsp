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
	function editNavigateBtn(btn) {
		var form = btn.parentNode;
		form.target = "";
		var inputs = form.getElementsByTagName('input')
		for (each in inputs) {
			if (inputs[each].checked == true) {
				form.action=inputs[each].value;
				form.submit();
				break;
			}
		}
	}
	function deleteNavigateBtn(btn) {
		var form = btn.parentNode;
		form.target = "";
		form.action = 'DeleteFileControl';
		form.submit();
	}
	function setRadioBtnState(btn) {
		var form = btn.parentNode.parentNode;
		form.target="";
		var inputs = form.getElementsByTagName('input');
		for (each in inputs) {
			inputs[each].checked = false;
		}
		btn.checked = true;
	}
	function reviewNavigateBtn(btn) {
		var form = btn.parentNode;
		form.target = "_blank";
		form.action = "DownloadFileControl";
		form.submit();
		
	}
</script>
<div class="row">
	<div class="jumbotron col-md-12">
		<a href="ReportControl?username=<%=username%>&pageNow=1"><h2><-- Back</h2></a>
	</div>

	<div class="jumbotron col-md-12">
		<form class="form" role="form" method="post" action="">
			<h2 class="form-purpose-heading">
				Abuse Report Details -
				<%=logID%>
			</h2>
			<input type="hidden" name="logID" value="<%=logID%>">
			<input type="hidden" name="username"
				value="<%=username%>">
			<div class="jumbotron jumptron-inner"
				onclick="disableBtn('deleteBtn');enableBtn('editBtn');"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="abuse_report" value="ReportReviewControl"
					onchange="setRadioBtnState(this)";> Abuse
				Report
			</div>
			<%
				Iterator<File> iterator = files.iterator();
									while (iterator.hasNext()) {
						File file = iterator.next();
						out.println("<div class=\"jumbotron jumptron-inner\" "
								+ "onclick=\"enableBtn('deleteBtn');disableBtn('editBtn');\""
								+ "style=\"padding: 10px; margin-bottom: 5px;\">"
								+ "<input type=\"radio\" name=\"Letter_"
								+ file.getFileName() + "\" onchange=\"setRadioBtnState(this)\";>  " + file.getFileName()
								+ "</div>");
					}
			%>
			<br>
			<button type="button" class="btn btn-lg btn-primary"
				name="pdfReviewBtn" onclick="reviewNavigateBtn(this);">Download</button>
			<button type="button" class="btn btn-lg btn-primary" name="editBtn"
				onclick="editNavigateBtn(this);">Edit</button>
			<button type="submit" class="btn btn-lg btn-primary"
				onclick="deleteNavigateBtn(this);" name="deleteBtn">Delete</button>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form-signin" role="form" action="UploadFileControl"
			method="post" enctype="multipart/form-data">
			<h2 class="form-purpose-heading">Upload New File</h2>
			<input type="hidden" name="logID" value="<%=logID%>">
			<input type="hidden" name="username" value="<%=username%>">
			<input type="file" class="form-control" name="file"
				placeholder="Select file" required="" autofocus=""> <br>
			<button class="btn btn-lg btn-primary" type="submit">Upload</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>