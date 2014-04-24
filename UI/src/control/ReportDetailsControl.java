package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBeanOperations;
import classes.AbuseReport;

@WebServlet("/ReportDetailsControl")
public class ReportDetailsControl extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String logID = request.getParameter("logID");
			String username = request.getParameter("username");
			AbuseReport report = new AbuseReport(logID);
			
			RequestDispatcher disp;
			disp = getServletContext().getRequestDispatcher("/ReportDetails.jsp");
			request.setAttribute("logID", logID);
			request.setAttribute("name", report.getAbuseName());
			request.setAttribute("files", report.getFilenames());
			request.setAttribute("username", username);
			disp.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}
