package edu.wpi.cs509.classes;

/**
 * @author shahe
 *
 */
/**
 * @author shahe
 *
 */
public class AbuseReport{
	
	private String logID;
	private String abuseName;
	private User user;
	private boolean isSubmitted;
	

	public AbuseReport (String logID, String abuseName, User user, boolean isSubmitted){
		this.logID = logID;
		this.abuseName = abuseName;
		this.user = user;
		this.isSubmitted = isSubmitted;
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
	
}