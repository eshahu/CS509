package classes;

import model.UserBeanOperations;


/**
 * @author shahe
 *
 */
public class Admin extends User{
	
	
	public Admin(String email, String password) {
		super(email, password);
		this.hasAccess = true;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param userName
	 */
	public void addUser(String firstName, String lastName, String email){
		UserBeanOperations ubo = new UserBeanOperations();
		System.out.println("loading database");
		ubo.addUser(firstName, lastName, email);
	}
	
	/**
	 * @param email
	 */
	public void removeUser(String email){
		UserBeanOperations ubo = new UserBeanOperations();
		System.out.println("loading database");
		ubo.removeUser(email);
	}
	
	/**
	 * 
	 */
	public void reviewAuditTrailReport(){
		
	}

	public void resetPassword(String email) {
		UserBeanOperations ubo = new UserBeanOperations();
		System.out.println("loading database");
		ubo.resetPassword(email);
		
	}
	
}