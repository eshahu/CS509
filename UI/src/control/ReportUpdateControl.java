package control;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReportBeanOperations;
import classes.AbuseReport;
import classes.AnonymousUser;

@WebServlet("/ReportUpdateControl")
public class ReportUpdateControl extends HttpServlet {

	private static AtomicInteger idCounter = new AtomicInteger();

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			String reporterFirst = request.getParameter("reporterFirst");
			String reporterLast = request.getParameter("reporterLast");
			String reporterPhone = request.getParameter("reporterPhone");
			String reporterAddr = request.getParameter("reporterAddr");

			String victimFirst = request.getParameter("victimFirst");
			String victimLast = request.getParameter("victimLast");
			String victimPhone = request.getParameter("victimPhone");
			String victimAddr = request.getParameter("victimAddr");

			String abuserFirst = request.getParameter("abuserFirst");
			String abuserLast = request.getParameter("abuserLast");
			String abuserPhone = request.getParameter("abuserPhone");
			String abuserAddr = request.getParameter("abuserAddr");

			ReportBeanOperations rbo = new ReportBeanOperations();
			rbo.addReport(reporterFirst, reporterLast, reporterPhone,
					reporterAddr, victimFirst, victimLast, victimPhone,
					victimAddr, abuserFirst, abuserPhone, abuserPhone,
					abuserAddr);

			AnonymousUser aUser = new AnonymousUser(
					reporterFirst.concat(reporterLast));

			String logID = String.valueOf(idCounter.getAndIncrement());
			AbuseReport aReport = new AbuseReport(logID,
					abuserFirst.concat(abuserLast), aUser, false);
			String userName = reporterFirst.concat(reporterLast);

			request.setAttribute("logID", logID);
			request.setAttribute("userName", userName);
			getServletContext().getRequestDispatcher(
					"/ReportDetailsControl?logID=" + logID + "&username="
							+ userName).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}
