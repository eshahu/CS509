<%@ include file="header.jsp"%>

<div class="row">
	<div class="jumbotron col-md-12">
		<form class="form-signin" role="form">
			<h2 class="form-purpose-heading">Site Purpose:</h2>
			<p style="text-indent: 50px;">This site provides services as the
				Department of Developmental Services (DDS) Agency Reporting and
				Management System. The DDS is a state government agency dedicated to
				helping citizens with developmental disabilities by providing
				residential and employment opportunities. The persons that the DDS
				are tasked to help have an IQ of 71 or less and a long-term chronic
				condition such as blindness, deafness, or autism. Since the clients
				are under the care and oversight of the staff members in residential
				units there can be situations where abuse of clients can occur.</p>
			<br>
			<p>
				For more information about the DDS visit the <a
					href="
				http://www.mass.gov/eohhs/gov/departments/dds/">Massachuesetts
					DSS site </a>
			</p>
		</form>
	</div>
</div>

<div class="row">
	<div class="jumbotron col-md-6">
		<h2>File Abuse Report Anonymously</h2>
		<a class="btn btn-lg btn-primary btn-block" href="ReportCreation.jsp">Continue</a>
	</div>
	<div class="col-md-1"></div>
	<div class="jumbotron col-md-5">
		<form class="form-signin" role="form" action="LoginControl" method="POST">
			<h2 class="form-signin-heading">Sign In</h2>
			<%
				String loginfailed = (String) session.getAttribute("loginfailed");
				if (loginfailed != null && loginfailed == "true") {
					out.println("<h5><font color=\"red\">Login information invalid...</font></h3>");
				}
			%>
			<input type="email" class="form-control" placeholder="Email address"
				required="" autofocus="" name=username> 
			<input type="password" class="form-control" placeholder="Password" 
				required="" name="password"> <br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>