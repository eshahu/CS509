<%@ include file="header.jsp"%>

<div class="jumbotron">
	<form class="form-create" action="ReportCreation" role="form" method="post">
		<h2>File Abuse Report</h2>
		<h4>Reporter Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>name:</h5>
			<input type="text" class="form-control" placeholder="ReporterFirst" name="reporterFirst">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="ReporterLast" name="reporterLast">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="ReporterPhone" name="reporterPhone">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="ReporterAddr" name="reporterAddr">
		</div>

		<h4>Victim Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>name:</h5>
			<input type="text" class="form-control" placeholder="VictimFirst" name="victimFirst">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="VictimLast" name="victimLast" >
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="VictimAddr" name="victimAddr" >
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="VictimPhone" name="victimPhone" >
		</div>
		<h4>Abuse Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>name:</h5>
			<input type="text" class="form-control" placeholder="Reportername">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="Reporter">
		</div>
		<h4>Description:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>name:</h5>
			<input type="text" class="form-control" placeholder="Reportername">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="Reporter">
		</div>
		<br>
		<button class="btn btn-lg btn-primary" type="submit"
			style="width: 25%;">Submit</button>
	</form>
</div>

<%@ include file="footer.jsp"%>