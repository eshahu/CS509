package control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DBUtil;
import classes.AbuseReport;
import classes.Supervisor;

@WebServlet("/DownloadFileControl")
public class DownloadFileControl extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	System.out.println("download file control");
		String logID = request.getParameter("logID").trim(); 
		String username = request.getParameter("username");
		
	    Supervisor supervisor = new Supervisor(username);
		for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
		    String name = entry.getKey();
	    	System.out.println(name);
		    if (name.contains("Letter_")) {
		    	String dirname = DBUtil.FILESERVER_DIR + "\\" + logID + "\\";
		    	String fileName = name.replace("Letter_","");
		    	File file = new File(dirname + fileName);
		        InputStream fis = new FileInputStream(file);
		        ServletContext ctx = getServletContext();
		        String mimeType = ctx.getMimeType(file.getAbsolutePath());
		        response.setContentType(mimeType != null? mimeType:"application/octet-stream");
		        response.setContentLength((int) file.length());
		        response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		         
		        ServletOutputStream os = response.getOutputStream();
		        byte[] bufferData = new byte[1024];
		        int read=0;
		        while((read = fis.read(bufferData))!= -1){
		            os.write(bufferData, 0, read);
		        }
		        
		        os.flush();
		        os.close();
		        fis.close();
		        
		        System.out.println("File downloaded at client successfully");
		    	
		    }
		    else if (name.contains("abuse_report")) {
		    	System.out.println("abuse report");
		    }
		    else if (name.contains("corr_actions")) {
		    	System.out.println("Corr");
		    }
		}
		
		
//		
//		RequestDispatcher disp;
//		disp = getServletContext().getRequestDispatcher("/ReportDetails.jsp");
//		request.setAttribute("logID", logID);
//		request.setAttribute("username", username);
//		
//		AbuseReport report = new AbuseReport(logID);
//		request.setAttribute("name", report.getAbuseName());
//		request.setAttribute("files", report.getFilenames());
//		
//		disp.forward(request, response);
	}

}
