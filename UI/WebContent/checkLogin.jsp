<%
	String username = request.getParameter("username");
	String password = request.getParameter("password");
	out.println("Checking login<br>");
	if (username == null || password == null) {

		out.print("Invalid paramters ");
	}

	// Here you put the check on the username and password
	if (username.toLowerCase().trim().equals("admin@gmail.com")
			&& password.toLowerCase().trim().equals("admin")) {
		response.sendRedirect("UserAccount.jsp"); 
		session.setAttribute("username", username);
		session.setAttribute("loggedin", "true");
		session.setAttribute("loginfailed", "false");
	} else {
		out.println("Invalid username and password");
		response.sendRedirect("home.jsp");
		session.setAttribute("loggedin", "false");
		session.setAttribute("loginfailed", "true");
	}
%>