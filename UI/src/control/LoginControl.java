package control;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBeanOperations;

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			String name = request.getParameter("username");
			String password = request.getParameter("password");

			// call UserBeanControl, create an instance
			UserBeanOperations ubo = new UserBeanOperations();
			// call the method of UserBeanControl
			System.out.println(name);

			// navigate to admin page
			if (name.equals("admin@admin.com") && password.equals("password")) {
				request.getRequestDispatcher("AminstrativeControlControl")
						.forward(request, response);
			}
			if (ubo.checkUser(name, password)) {

				System.out
						.println("login controller to jump to UserAccount.jsp");

				// it's like sendRedirect, but more efficient
				// and keep the content in the request
				request.getRequestDispatcher("ReportControl").forward(request,
						response);

			} else {
				// indicate user is not existing
				request.getRequestDispatcher("home.jsp").forward(request,
						response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}
