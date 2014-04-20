<%@ include file="header.jsp"%>

<div class="jumbotron">
	<form class="form-create" role="form">
		<h2>Abuse Report Review</h2>
		<h4>Reporter Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>name:</h5>
			<input type="text" class="form-control" placeholder="Reportername">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="Reporter">
		</div>

		<h4>Victim Information:</h4>
		<div class="jumbotron" style="background-color:white;padding:10px">
			<h5>name:</h5>
			<input type="text" class="form-control" placeholder="Reportername">
			<h5>address:</h5>
			<input type="text" class="form-control" placeholder="Reporter">
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
		<button class="btn btn-lg btn-primary" type="submit">Review As PDF</button>
		<button class="btn btn-lg btn-primary" type="submit">Save Changes</button>
	</form>
</div>

<%@ include file="footer.jsp"%>