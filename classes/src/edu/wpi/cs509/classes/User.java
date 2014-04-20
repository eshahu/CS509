package edu.wpi.cs509.classes;


/**
 * @author shahe
 *
 */
public abstract class User{
	
	 protected String userName;
	 protected String password;
	 protected String email;
	 protected boolean isAdmin;
	 protected boolean isSupervisor;
	 protected boolean hasAccess;
	 
	public User(String userName, String password, String email){
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.hasAccess = false;
	} 
	
	public User(String userName, String email){
		this.userName = userName;
		this.email = email;
		this.hasAccess = false;
	} 
	
	public User(String userName){
		this.userName = userName;
		this.hasAccess = false;
	}
	
	public void logIn(){
		
	}
	
	
	public void logOut(){
		
	}
	
	/**
	 * @param pw
	 */
	public void changePassword(String pw){
		this.password = pw;
	}
	
	
	/**
	 * @return
	 */
	protected String getName(){
		return userName;
	}
	
	
	
	/**
	 * @param aName
	 */
	protected void setName(String aName){
		userName = aName;
	}
	
	
	/**
	 * @return
	 */
	protected String getPassword(){
		return password;
	}
	
	/**
	 * @return
	 */
	protected String getEmail(){
		return email;
	}
	
	/**
	 * @param pw
	 */
	protected void setpassword(String pw){
		password = pw;
	}
	
	
	protected void setAccess(boolean hasAccess){
		this.hasAccess = hasAccess;
	}
	
	protected boolean getAccess(){
		return hasAccess;
	}
	
	
}