package control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.AuditTrail;
import model.UserBeanOperations;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			AuditTrail at = new AuditTrail();
			if (name.equals("admin@admin.com") && password.equals("password")) {
				request.getRequestDispatcher("AminstrativeControlControl")
						.forward(request, response);
			} else {
				UserBeanOperations ubo = new UserBeanOperations();
				if (ubo.checkUser(name, password)) {

					System.out
							.println("login controller to jump to UserAccount.jsp");

					// it's like sendRedirect, but more efficient
					// and keep the content in the request
					request.setAttribute("username", name);
					
					at.trackLogIn(name,
							String.valueOf(System.currentTimeMillis()), true);
					request.getRequestDispatcher("ReportControl").forward(
							request, response);

				} else {
					// indicate user is not existing
					at.trackLogIn(name,
							String.valueOf(System.currentTimeMillis()), false);
					request.getRequestDispatcher("home.jsp").forward(request,
							response);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
