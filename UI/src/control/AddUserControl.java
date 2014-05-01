package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Admin;
import model.UserBeanOperations;

@WebServlet("/AddUserControl")
public class AddUserControl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			String first = request.getParameter("first");
			String last = request.getParameter("last");
			String email = request.getParameter("email");

			Admin admin = new Admin("Admin@admin.com", "password");
			admin.addUser(first, last, email);
			System.out.println("adding new user");
			request.getRequestDispatcher("AminstrativeControlControl")
			.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
