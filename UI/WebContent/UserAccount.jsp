<%@ include file="header.jsp"%>

<%
	String username = (String) request.getAttribute("username");
	//MVC V does not need to call model
	//get data from request
	ArrayList<ReportBean> al = (ArrayList) request
			.getAttribute("result");

	Iterator<ReportBean> iterator = al.iterator();
	//show records
%>

<div class="row">
	<div class="jumbotron col-md-12">
		<h2 class="form-purpose-heading">Recent Abuse Reports</h2>
		<%
			while (iterator.hasNext()) {
				int logNumber = iterator.next().getLogNumber(); 
		%>
		<div class="jumbotron jumptron-inner" style="padding: 10px;">
			Abuse Report #
			<%=logNumber%>
			<div style="float: right;">
				<a href="ReportDetailsControl?logID=<%=logNumber%>&username=<%=username%>"><b>More
						Info</b></a>
			</div>
		</div>
		<%
			}
			//get pageNow and pageCount from request
			int pageNow = Integer.parseInt((String) request
					.getAttribute("pageNow"));
			String s_pageCount = (String) request.getAttribute("pageCount");
			int pageCount = Integer.parseInt(s_pageCount);

			//Previous page
			if (pageNow != 1) {
				out.println("<a href=ReportControl?username=" + username  + "&pageNow=" + (pageNow - 1)
						+ ">PREV</a>");
			}
			//show URL
			for (int i = pageNow; i <= pageNow + 4 && i <= pageCount; i++) {
				out.println("<a href=ReportControl?username=" + username  + "&pageNow=" + i + ">[" + i
						+ "]</a>");
			}
			//Next page
			if (pageNow != pageCount) {
				out.println("<a href=ReportControl?username=" + username  + "&pageNow=" + (pageNow + 1)
						+ ">NEXT</a>");
			}
		%>
		<br>
		<!-- jump to one specific page -->
		<form class="form-signin" role="form" action="ReportControl">
			jump to page:
			<input type="text" class="form-control" name="pageNow">
			<input type="hidden" class="form-control" name="username" value=<%=username%>> <br>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
		</form>
	</div>
</div>

<%@ include file="footer.jsp"%>