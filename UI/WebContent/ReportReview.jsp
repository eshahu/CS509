<%
	String reporterFirst = (String) request.getAttribute("reporterFirst");
	String reporterLast = (String)  request.getAttribute("reporterLast");
	String reporterPhone = (String) request.getAttribute("reporterPhone");
	String reporterAddr = (String)  request.getAttribute("reporterAddr");
	
	String abuserFirst = (String)  request.getAttribute("abuserFirst");
	String abuserLast = (String) request.getAttribute("abuserFirst");
	String abuserPhone = (String) request.getAttribute("abuserPhone");
	String abuserAddr = (String)  request.getAttribute("abuserAddr");
	
	String victimFirst = (String)  request.getAttribute("victimFirst");
	String victimLast = (String) request.getAttribute("victimFirst");
	String victimPhone = (String) request.getAttribute("victimPhone");
	String victimAddr = (String)  request.getAttribute("victimAddr");
	
	String reporterPhoneMessage = (String) request.getAttribute("reporterPhoneMessage");
	String abuserPhoneMessage = (String) request.getAttribute("abuserPhoneMessage");
	String victimPhoneMessage = (String) request.getAttribute("victimPhoneMessage");
	String logID = (String) request.getAttribute("logID");
	String username = (String) request.getAttribute("userName");		
%>
<%@ include file="header.jsp"%>
<script>
function navigateBtn(btn) {
		var form = btn.parentNode;
		form.target = "";
		form.action = 'DownloadFileControl';
		form.submit();
	}
</script>

<div class="jumbotron">
	<form class="form-create" action="ReportReviewControl" role="form" method="POST">
		<h2>Abuse Report Review</h2>
		<h4>Reporter Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>firstname:</h5>
			<input type="text" class="form-control" name="reporterFirst" value="${reporterFirst}">
			<h5>lastname:</h5>
			<input type="text" class="form-control" name="reporterLast" value="${reporterLast}">
			<h5>phone:</h5>
			<div style="color:red">${reporterPhoneMessage}</div>			
			<input type="text" class="form-control" name="reporterPhone" value="${reporterPhone}">
			<h5>address:</h5>
			<input type="text" class="form-control" name="reporterAddress" value="${reporterAddr}">
		</div>			
		<h4>Victim Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>firstname:</h5>
			<input type="text" class="form-control" name="victimFirst" value="${victimFirst}">
			<h5>lastname:</h5>
			<input type="text" class="form-control" name="victimLast" value="${victimLast}">
			<h5>phone:</h5>
			<div style="color:red">${victimPhoneMessage}</div>			
			<input type="text" class="form-control" name="victimPhone" value="${victimPhone}">
			<h5>address:</h5>
			<input type="text" class="form-control" name="victimAddr" value="${victimAddr}">
		</div>
		<h4>Abuser Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>firstname:</h5>
			<input type="text" class="form-control" name="abuserFirst" value="${abuserFirst}">
			<h5>lastname:</h5>
			<input type="text" class="form-control" name="abuserLast" value="${abuserLast}">
			<h5>phone:</h5>
			<div style="color:red">${abuserPhoneMessage}</div>			
			<input type="text" class="form-control" name="abuserPhone" value="${abuserPhone}">
			<h5>address:</h5>
			<input type="text" class="form-control" name="abuserAddr" value="${abuserAddr}">
		</div>
		<br>
			<input type="hidden" name="logID" value="${logID}">
			<input type="hidden" name="username" value="<% out.println(username); %>">
			<input type="hidden" name="abuse_report" value="ReportReview.jsp">
		
		<button class="btn btn-lg btn-primary" onclick="navigateBtn(this);" type="submit">Review As PDF</button>
		<button class="btn btn-lg btn-primary" type="submit">Save Changes</button>
	</form>
</div>
<%@ include file="header.jsp"%>