package edu.wpi.cs509.classes;


/**
 * @author shahe
 *
 */
public abstract class User{
	
	protected String userName;
	protected String password;
	protected String email;
	
	public void logIn(){
		
	}
	
	
	public void logOut(){
		
	}
	
	/**
	 * @param pw
	 */
	public void changePassword(String pw){
		
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
	 * @param pw
	 */
	protected void setpassword(String pw){
		password = pw;
	}
}