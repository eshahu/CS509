package control;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Admin;

@WebServlet("/ResetPasswordControl")
public class ResetPasswordControl extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			for (Entry<String, String[]> entry : request.getParameterMap()
					.entrySet()) {
				String email = entry.getKey();
				Admin admin = new Admin("Admin@admin.com", "password");
				admin.resetPassword(email);
				System.out.println("reset password");
				request.getRequestDispatcher("AminstrativeControlControl")
						.forward(request, response);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
