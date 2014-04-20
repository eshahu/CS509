<%@ include file="header.jsp"%>

<div class="jumbotron">
	<form class="form-create" role="form">
		<h2>Corrective Actions Review and Creation</h2>
		<h4>Header:</h4>
		<textarea class="form-control" rows="3" name="header"></textarea>
		<h4>Description:</h4>
		<textarea class="form-control" rows="5" name="body"></textarea>
		<h4>Footer:</h4>
		<textarea class="form-control" rows="3" name="footer"></textarea>
		<br>
		<button class="btn btn-lg btn-primary" type="submit">Review
			As PDF</button>
		<button class="btn btn-lg btn-primary" type="submit">Save
			Changes</button>
	</form>
</div>

<%@ include file="footer.jsp"%>