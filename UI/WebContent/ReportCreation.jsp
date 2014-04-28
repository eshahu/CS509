<%@ include file="header.jsp"%>

<div class="jumbotron">
	<form class="form-create" action = "ReportCreationControl" role="form" method="post">
		<h2>File Abuse Report</h2>
		<h4>Reporter Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>FirstName:</h5>
			<input type="text" class="form-control" placeholder="ReporterFirst" name="reporterFirst">
			<h5>LastName:</h5>
			<input type="text" class="form-control" placeholder="ReporterLast" name="reporterLast">
			<h5>Phone:</h5>
			<input type="text" class="form-control" placeholder="ReporterPhone" name="reporterPhone">
			<h5>Address:</h5>
			<input type="text" class="form-control" placeholder="ReporterAddr" name="reporterAddr" >
		</div>
		<h4>Victim Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>FirstName:</h5>
			<input type="text" class="form-control" placeholder="VictimFirst" name="victimFirst">
			<h5>LastName:</h5>
			<input type="text" class="form-control" placeholder="VictimLast" name="victimLast" >
			<h5>Phone:</h5>
			<input type="text" class="form-control" placeholder="VictimPhone" name="victimPhone" >
			<h5>Address:</h5>
			<input type="text" class="form-control" placeholder="VictimAddr" name="victimAddr" >
		</div>
		<h4>Abuser Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>FirstName:</h5>
			<input type="text" class="form-control" placeholder="AbuserFirst" name="abuserFirst">
			<h5>LastName:</h5>
			<input type="text" class="form-control" placeholder="AbuserLast" name="abuserLast" >
			<h5>Phone:</h5>
			<input type="text" class="form-control" placeholder="AbuserPhone" name="abuserPhone" >
			<h5>Address:</h5>
			<input type="text" class="form-control" placeholder="AbuserAddr" name="abuserAddr" >
		</div>
		<br>
		<button class="btn btn-lg btn-primary" href="home.jsp" type="submit"
			style="width: 25%;">Submit</button>
	</form>
</div>

<%@ include file="footer.jsp"%>