<%@ include file="header.jsp"%>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form-signin" role="form">
			<h2 class="form-purpose-heading">Search by Public Log Number</h2>
			<input type="text" class="form-control" placeholder="Public Log Number"
				required="" autofocus=""> <br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-12">
		<h2 class="form-purpose-heading">Recent Abuse Reports</h2>
		<div class="jumbotron jumptron-inner" style="padding: 10px;">
			Abuse Report # {public_log_number}
			<div style="float: right;">
				<a href="ReportDetailsControl?logID=temp&username=temp2"><b>More Info</b></a>
			</div>
		</div>
		<div class="jumbotron jumptron-inner" style="padding: 10px;">
			Abuse Report # {public_log_number}
			<div style="float: right;">
				<a href="ReportDetailsControl?logId=temp2&username=temp2"><b>More Info</b></a>
			</div>
		</div>
		<div class="jumbotron jumptron-inner" style="padding: 10px;">
			Abuse Report # {public_log_number}
			<div style="float: right;">
				<a href="ReportDetailsControl?logId=temp3&username=temp2"><b>More Info</b></a>
			</div>
		</div>
	</div>
</div>

<%@ include file="footer.jsp"%>