<%@ include file="header.jsp"%>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form" role="form">
			<h2 class="form-purpose-heading">Abuse Report Details</h2>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="abusereport"> Abuse
				Report
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="apeals"> Appeals.pdf
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="decision">
				DecisionReport.pdf
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="corrective">
				CorrectiveActions.txt
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="file" value="diposition">
				DipositionLetter.pdf
			</div>
			<br>
			<button type="button" class="btn btn-lg btn-primary">Review As PDF</button>
			<button type="button" class="btn btn-lg btn-primary">Edit</button>
			<button type="button" class="btn btn-lg btn-primary">Delete</button>
			<button type="button" class="btn btn-lg btn-primary">Download</button>
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