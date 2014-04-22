<%@ include file="header.jsp"%>

<div class="jumbotron">
	<form class="form-create" role="form">
		<h2>Abuse Report Review</h2>
		<h4>Reporter Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>firstname:</h5>
			<input type="text" class="form-control" placeholder="ReporterFirstName">
			<h5>lastname:</h5>
			<input type="text" class="form-control" placeholder="ReporterLastName">			
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="ReporterAddress">
		</div>
		<h4>Victim Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>firstname:</h5>
			<input type="text" class="form-control" placeholder="VictimFirstName">
			<h5>lastname:</h5>
			<input type="text" class="form-control" placeholder="VictimLastName">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="VictimAddres">
		</div>
		<h4>Abuser Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>firstname:</h5>
			<input type="text" class="form-control" placeholder="AbuserFirstName">
			<h5>lastname:</h5>
			<input type="text" class="form-control" placeholder="AbuserLastName">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="AbuserAddress">
		</div>
		<br>
		<button class="btn btn-lg btn-primary" type="submit">Review As PDF</button>
		<button class="btn btn-lg btn-primary" type="submit">Save Changes</button>
	</form>
</div>

<%@ include file="footer.jsp"%>