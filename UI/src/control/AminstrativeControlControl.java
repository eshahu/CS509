package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserBeanOperations;

@WebServlet("/AminstrativeControlControl")
public class AminstrativeControlControl extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher disp;
		disp = getServletContext().getRequestDispatcher(
				"/AdministrativeControl.jsp");

		UserBeanOperations ubo = new UserBeanOperations();
		request.setAttribute("email", ubo.listUser());

		disp.forward(request, response);
	}
}