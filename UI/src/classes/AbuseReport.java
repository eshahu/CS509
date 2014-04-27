package classes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;

import model.DBUtil;

/**
 * @author shahe
 *
 */
public class AbuseReport{
	
	private String logID;
	private String abuseName;
	private User user;
	private boolean isSubmitted;
	private List<File> filenames;
	
	public AbuseReport (String logID, String abuseName, User user, boolean isSubmitted, List<File> filenames){
		this.logID = logID;
		this.abuseName = abuseName;
		this.user = user;
		this.isSubmitted = isSubmitted;
		this.filenames = filenames;
	}

	public AbuseReport (String logID, String abuseName, User user, boolean isSubmitted){
		this.logID = logID;
		this.abuseName = abuseName;
		this.user = user;
		this.isSubmitted = isSubmitted;
		retrieveFilenames();
	}
	
	public AbuseReport(String logID){
		this.logID = logID;
		/* retrieve abuse report information from database... */
		this.abuseName = "temp";
		this.isSubmitted = true;
		retrieveFilenames();
	}

	/**
	 * @return
	 */
	public String getLogID(){
		return logID;		
	}
	
	/**
	 * @return
	 */
	public String getAbuseName(){
		return abuseName;
	}
	
	/**
	 * @return
	 */
	public boolean isSubmitted(){
		return isSubmitted;
	}
	
	/**
	 * @return
	 */
	public User getUser(){
		return user;
	}
	
	public void setUser (User user){
		this.user = user;
	}
	
	private void retrieveFilenames() {
		/* Retrieve list of files associated with this abuse report from database */
		this.filenames = new LinkedList<File>();
    	String dirname = DBUtil.FILESERVER_DIR + "\\" + logID + "\\";
    	java.io.File file = new java.io.File(dirname);
		String[] paths;
		try {      
			paths = file.list();
			for(String path:paths)
			{
				this.filenames.add(new File(path));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<File> getFilenames() {
		return filenames;
	}

	public void setFilenames(List<File> filenames) {
		this.filenames = filenames;
	}
	
	public String generatePdf() throws FileNotFoundException, DocumentException {
		String dirname = DBUtil.FILESERVER_DIR + "\\";
		String filename = "abuseReport_" + this.logID + ".pdf";
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document, 
				new FileOutputStream(dirname + filename));
		document.open();
		
		Anchor anchorTarget = new Anchor("Abuse report - Public Log Number " + this.logID);
		anchorTarget.setName("BackToTop");

		Paragraph paragraph1 = new Paragraph();
		paragraph1.setSpacingBefore(50);
		paragraph1.add(anchorTarget);
		document.add(paragraph1);
		document.add(new Paragraph("LALALALALA", 
				FontFactory.getFont(FontFactory.TIMES, 12)));
		
		/* TODO - write data to pdf here */
		
		document.close();
		return filename;
	}
	
	public String generateCorrActionsPdf() throws FileNotFoundException, DocumentException {
		String dirname = DBUtil.FILESERVER_DIR + "\\";
		String filename = "corrActions_" + this.logID + ".pdf";
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		PdfWriter writer = PdfWriter.getInstance(document, 
				new FileOutputStream(dirname + filename));
		document.open();
		
		Anchor anchorTarget = new Anchor("Corrective Actions - Public Log Number " + this.logID);
		anchorTarget.setName("BackToTop");

		Paragraph paragraph1 = new Paragraph();
		paragraph1.setSpacingBefore(50);
		paragraph1.add(anchorTarget);
		document.add(paragraph1);
		document.add(new Paragraph("LALALALALA", 
				FontFactory.getFont(FontFactory.TIMES, 12)));

		/* TODO - write data to pdf here */
		
		document.close();
		return filename;
	}
	
}