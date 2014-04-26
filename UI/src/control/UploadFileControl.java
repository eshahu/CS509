package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import classes.AbuseReport;
import classes.Supervisor;

@MultipartConfig
@WebServlet("/UploadFileControl")
public class UploadFileControl extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String logID = request.getParameter("logID").trim(); 
		String username = request.getParameter("username");
	    
	    Supervisor supervisor = new Supervisor(username);
	    supervisor.uploadFile(logID, request.getPart("file"));
	    
	    System.out.println("change 2");
		
		RequestDispatcher disp;
		disp = getServletContext().getRequestDispatcher("/ReportDetails.jsp");
		request.setAttribute("logID", logID);
		request.setAttribute("username", username);
		
		AbuseReport report = new AbuseReport(logID);
		request.setAttribute("name", report.getAbuseName());
		request.setAttribute("files", report.getFilenames());
		
		disp.forward(request, response);
	}
}
