<%@ include file="header.jsp"%>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form" role="form">
			<h2 class="form-purpose-heading">User List</h2>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="user" value="user1"> User 1
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="user" value="user2"> User 2
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="user" value="user3"> User 3
			</div>
			<br>
			<button type="button" class="btn btn-lg btn-primary">Delete User</button>
			<button type="button" class="btn btn-lg btn-primary">Reset Password</button>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form" role="form">
			<h2 class="form-purpose-heading">Add New User</h2>
			<h5>First Name:</h5>
			<input class="form-control" type="text" name="first">
			<h5>Last Name:</h5>
			<input class="form-control" type="text" name="last">
			<h5>Email Address:</h5>
			<input class="form-control" type="email" name="email">
			<br>
			<button type="button" class="btn btn-lg btn-primary">Add User</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>