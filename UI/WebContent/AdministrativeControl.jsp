<%@ include file="header.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="classes.File"%>

<%
	List<String> emailList = (List<String>) request.getAttribute("email");
%>
<script>
	function resetBtn(btn) {
		var form = btn.parentNode;
		form.target = "";
		form.action = 'ResetPasswordControl';
		form.submit();
	}
	
	function removeBtn(btn) {
		var form = btn.parentNode;
		form.target = "";
		form.action = 'RemoveUserControl';
		form.submit();
	}
</script>
<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form" role="form" action="" method="POST">
			<h2 class="form-purpose-heading">User List</h2>
			<%
				Iterator<String> iterator = emailList.iterator();
				while (iterator.hasNext()) {
					String email = iterator.next();
					out.println("<div class=\"jumbotron jumptron-inner\""
							+ "style=\"padding: 10px; margin-bottom: 5px;\">"
							+ "<input type=\"radio\" name=\"" + email
							+ "\" value=\"" + email + "\">" + email + "</div>");
				}
			%>
			<!-- 
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="email" value="user1"> User 1
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="email" value="user2"> User 2
			</div>
			<div class="jumbotron jumptron-inner"
				style="padding: 10px; margin-bottom: 5px;">
				<input type="radio" name="email" value="user3"> User 3
			</div>
 -->

			<br>
			<button type="submit" name="delete" class="btn btn-lg btn-primary"
				onclick="removeBtn(this);">Delete User</button>
			<button type="submit" name="reset" class="btn btn-lg btn-primary"
				onclick="resetBtn(this);">Reset Password</button>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form" role="form" action="AddUserControl" method="POST">
			<h2 class="form-purpose-heading">Add New User</h2>
			<h5>First Name:</h5>
			<input class="form-control" type="text" name="first">
			<h5>Last Name:</h5>
			<input class="form-control" type="text" name="last">
			<h5>Email Address:</h5>
			<input class="form-control" type="email" name="email"> <br>
			<button type="submit" class="btn btn-lg btn-primary">Add
				User</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%><%@ include file="header.jsp"%>


