package control;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ReportBean;
import model.ReportBeanOperations;
import classes.AuditTrail;

@WebServlet("/ReportReviewControl")
public class ReportReviewControl extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		AuditTrail at = new AuditTrail();
		try {
			String logID = request.getParameter("logID");
			String userName = request.getParameter("username");
			
			ReportBeanOperations rbo = new ReportBeanOperations();
			ReportBean rb = rbo.getReport(logID);

			request.setAttribute("logID", logID);
			request.setAttribute("userName", userName);
			
			request.setAttribute("reporterFirst", rb.getReporterFirst());
			request.setAttribute("reporterLast", rb.getReporterLast());
			request.setAttribute("reporterPhone", rb.getReportPhone());
			request.setAttribute("reporterAddr", rb.getReportAddr());

			request.setAttribute("victimFirst", rb.getVictimFirst());
			request.setAttribute("victimLast", rb.getVictimLast());
			request.setAttribute("victimPhone", rb.getVictimPhone());
			request.setAttribute("victimAddr", rb.getVictimAddr());

			request.setAttribute("abuserFirst", rb.getAbuserFirst());
			request.setAttribute("abuserLast", rb.getAbuserLast());
			request.setAttribute("abuserPhone", rb.getAbuserPhone());
			request.setAttribute("abuserAddr", rb.getAbuserAddr());
			
			at.trackViewAbuseReport(userName,logID,String.valueOf(System.currentTimeMillis()));
			getServletContext().getRequestDispatcher(
					"/ReportReview.jsp").forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}
