package classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.Part;

import model.DBUtil;



/**
 * @author shahe
 *
 */
public class Supervisor extends User{

	
	public Supervisor(String userName, String password, String email) {
		super(userName, password, email);
		setAccess(true);
		// TODO Auto-generated constructor stub
	}

	public Supervisor(String userName) {
		super(userName);
		setAccess(true);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ar
	 */
	public void viewReport(AbuseReport ar){
		
	}
	
	/**
	 * @param logID
	 */
	public void searchByLogID(String logID){
		
	}
	
	/**
	 * @param ar
	 * @param an
	 */
	public void editAbuseReportName(AbuseReport ar, String an){
		
	}
	
	/**
	 * @param ar
	 * @param ad
	 */
	public void editAbuseReportDescription(AbuseReport ar, String ad){
		
	}
	
	/**
	 * @param ar
	 */
	public void submitReport(AbuseReport ar){
		
	}
	
	/**
	 * @param ar
	 */
	public void printReport(AbuseReport ar){
		
	}
	
	/**
	 * @param fileType
	 * @throws IOException 
	 */
	public void uploadFile(String logID, Part filePart) throws IOException{
	    String filename = getFilename(filePart);
	    InputStream filecontent = filePart.getInputStream();
	    byte[] buffer = new byte[8 * 1024];
	    try {
	    	System.out.println("changed");
	    	String dirname = DBUtil.FILESERVER_DIR + "\\" + logID + "\\";
	    	java.io.File d = new java.io.File(dirname);
	    	d.mkdirs();
	    	OutputStream output = new FileOutputStream(dirname + filename);
	    	try {
	    		int bytesRead;
	    		while ((bytesRead = filecontent.read(buffer)) != -1) {
	    			output.write(buffer, 0, bytesRead);
	    		}
	    	} finally {
	    		output.close();
	    	}
	    } finally {
	    	filecontent.close();
	    }
	}

	private static String getFilename(Part part) {
	    for (String cd : part.getHeader("content-disposition").split(";")) {
	        if (cd.trim().startsWith("filename")) {
	            String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	            return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	        }
	    }
	    return null;
	}
	
	/**
	 * @param fileType
	 */
	public void downloadFile(String fileType){
		
	}

	public void deleteFile(String logID, String filename) {
		// TODO Auto-generated method stub
		
	}
}