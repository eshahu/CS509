package edu.wpi.cs509.classes;

/**
 * @author shahe
 *
 */
public class Admin extends User{
	
	
	public Admin(String userName, String password, String email) {
		super(userName, password, email);
		this.hasAccess = true;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 */
	public void addUser(String userName){
		
	}
	
	/**
	 * @param userName
	 */
	public void removeUser(String userName){
		
	}
	
	/**
	 * 
	 */
	public void reviewAuditTrailReport(){
		
	}
	
}