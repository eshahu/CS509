package control;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReportBeanOperations;
import model.UserBeanOperations;
import classes.AbuseReport;
import classes.AnonymousUser;

@WebServlet("/ReportCreationControl")
public class ReportCreationControl extends HttpServlet {

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

			boolean errors = false;
			Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
			if(!pattern.matcher(reporterPhone).matches()) {
				errors = true;
				request.setAttribute("reporterPhoneMessage", "Please enter a phone number in the xxx-xxx-xxxx format");
			}
			if(!pattern.matcher(victimPhone).matches()) {
				errors = true;
				request.setAttribute("victimPhoneMessage", "Please enter a phone number in the xxx-xxx-xxxx format");
			}
			if(!pattern.matcher(abuserPhone).matches()) {
				errors = true;
				request.setAttribute("abuserPhoneMessage", "Please enter a phone number in the xxx-xxx-xxxx format");
			}
			
			if (errors) {
				request.setAttribute("reporterFirst", reporterFirst);
				request.setAttribute("reporterLast", reporterLast);
				request.setAttribute("reporterPhone", reporterPhone);
				request.setAttribute("reporterAddr", reporterAddr);

				request.setAttribute("victimFirst", victimFirst);
				request.setAttribute("victimLast", victimLast);
				request.setAttribute("victimPhone", victimPhone);
				request.setAttribute("victimAddr", victimAddr);

				request.setAttribute("abuserFirst", abuserFirst);
				request.setAttribute("abuserLast", abuserLast);
				request.setAttribute("abuserPhone", abuserPhone);
				request.setAttribute("abuserAddr", abuserAddr);
				
				getServletContext().getRequestDispatcher("/ReportDetails.jsp").forward(request, response);
			}
			else {
				ReportBeanOperations rbo = new ReportBeanOperations();
				rbo.addReport(reporterFirst, reporterLast, reporterPhone,
						reporterAddr, victimFirst, victimLast, victimPhone,
						victimAddr, abuserFirst, abuserPhone, abuserPhone,
						abuserAddr);

				getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}