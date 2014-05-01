package control;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.Admin;

@WebServlet("/RemoveUserControl")
public class RemoveUserControl extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			for (Entry<String, String[]> entry : request.getParameterMap()
					.entrySet()) {
				String email = entry.getKey();
				Admin admin = new Admin("Admin@admin.com", "password");
				admin.removeUser(email);
			}
			request.getRequestDispatcher("AminstrativeControlControl")
			.forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
