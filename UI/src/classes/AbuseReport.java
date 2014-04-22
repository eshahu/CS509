package classes;

import java.util.LinkedList;
import java.util.List;

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
	

	public AbuseReport (String logID, String abuseName, User user, boolean isSubmitted){
		this.logID = logID;
		this.abuseName = abuseName;
		this.user = user;
		this.isSubmitted = isSubmitted;
		this.filenames = new LinkedList<File>();
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
	 * 
	 */
	//TODO
	public void viewAsPDF(){
		
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
		this.filenames.add(new File("temp"));
		this.filenames.add(new File("temp2"));
		this.filenames.add(new File("temp3"));
	}

	
	public List<File> getFilenames() {
		return filenames;
	}

	public void setFilenames(List<File> filenames) {
		this.filenames = filenames;
	}
	
}