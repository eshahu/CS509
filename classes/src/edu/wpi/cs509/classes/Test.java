package edu.wpi.cs509.classes;

/**
 * @author shahe
 *
 */
public class Test{
	
	private String logID;
	private String abuseName;
	private User user;
	private boolean isSubmitted;
	private boolean hasAccess; 
	
	
	public String getLogID(){
		return logID;		
	}
	
	/**
	 * @param user
	 * @return
	 */
	public boolean hasAccess(User aUser){
		if (aUser instanceof Supervisor)
			hasAccess = true;
		else hasAccess = false;
		return hasAccess;
	}
	
	/**
	 * 
	 */
	public void viewAsPDF(){
		
	}
	
	public String getAbuseName(){
		return abuseName;
	}
	
	public boolean isSubmitted(){
		return isSubmitted;
	}
	
	public User getUser(){
		return user;
	}
	
	public void setUser(User aUser){
		user = aUser;
	}
	
}