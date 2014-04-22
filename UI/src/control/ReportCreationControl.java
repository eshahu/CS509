package control;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBeanOperations;
import classes.AbuseReport;
import classes.AnonymousUser;

@WebServlet("/ReportCreationControl")
public class ReportCreationControl extends HttpServlet {

	private static AtomicInteger idCounter = new AtomicInteger();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			String reporterFirst = request.getParameter("reporterFirst");
			String reporterLast = request.getParameter("reporterLast");
			
			String victimFirst = request.getParameter("victimFirst");
			String victimLast = request.getParameter("victimLast");
			
			String abuserFirst = request.getParameter("abuserFirst");
			String abuserLast = request.getParameter("abuserLast");
			
			AnonymousUser aUser = new AnonymousUser(reporterFirst.concat(reporterLast));
			
			String logID = String.valueOf(idCounter.getAndIncrement());
			
			AbuseReport aReport = new AbuseReport(logID, abuserFirst.concat(abuserLast), aUser, false);
			
			RequestDispatcher disp;
			disp = getServletContext().getRequestDispatcher("/ReportCreation.jsp");
		    disp.forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}