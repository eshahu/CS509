package testPackage;


import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import classes.AnonymousUser;


/** Simple servlet for testing. Generates HTML instead of plain
 *  text as with the HelloWorld servlet.
 */

@WebServlet("/ReportCreation")
public class ReportCreation extends HttpServlet {
	
	String reporterFirst; 
	String reporterLast;
	String reporterPhone;
	String reporterAddr;
	
	
  @Override
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
	  
	  String reporterFirst = request.getParameter("reporterFirst"); 
	  String reporterLast = request.getParameter("reporterLast");
	  String reporterPhone = request.getParameter("reporterPhone");
	  String reporterAddr = request.getParameter("reporterAddr");

	  AnonymousUser user = new AnonymousUser(reporterFirst.concat(reporterLast));
	
	
	  response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	  out.println
	  ("<!DOCTYPE html>\n" +
		       "<html>\n" +
		       "<head><title>A Test Servlet</title></head>\n" +
		       "<body bgcolor=\"#fdf5e6\">\n" +
		       "<h1>Test</h1>\n" +
		       "<p>Simple servlet for testing.</p>\n" +
		       "</body></html>");
  }
}
