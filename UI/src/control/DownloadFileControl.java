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

import com.itextpdf.text.DocumentException;

import model.DBUtil;
import classes.AbuseReport;
import classes.AuditTrail;
import classes.Supervisor;

@WebServlet("/DownloadFileControl")
public class DownloadFileControl extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AuditTrail at = new AuditTrail();
    	System.out.println("download file control");
		String logID = request.getParameter("logID").trim(); 
		
		String dirname = "", fileName = "";
		
		for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
		    String name = entry.getKey();
		    if (name.contains("Letter_")) {
		    	dirname = DBUtil.FILESERVER_DIR + "\\" + logID + "\\";
		    	fileName = name.replace("Letter_","");
		    }
		    else if (name.contains("abuse_report")) {
		    	dirname = DBUtil.FILESERVER_DIR + "\\" ;
		    	AbuseReport report = new AbuseReport(logID);
		    	try {
					fileName = report.generatePdf();
				} catch (DocumentException e) {
					System.out.println("Failed to generate PDF!");
					e.printStackTrace();
				}
		    }
		    else if (name.contains("corr_actions")) {
		    	dirname = DBUtil.FILESERVER_DIR + "\\" ;
		    	AbuseReport report = new AbuseReport(logID);
		    	try {
					fileName = report.generateCorrActionsPdf();
				} catch (DocumentException e) {
					System.out.println("Failed to generate PDF!");
					e.printStackTrace();
				}
		    }
		}
		
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
        while((read = fis.read(bufferData))!= -1) {
            os.write(bufferData, 0, read);
        }
        
        os.flush();
        os.close();
        fis.close();
	}

}
