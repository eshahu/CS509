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
	        
	        getServletContext().getRequestDispatcher("/ReportReview.jsp").forward(request, response);
   
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		this.doGet(request, response);
	}
}