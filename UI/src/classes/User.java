package classes;



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
		this.hasAccess = true;
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
	
	public Boolean logIn(){
		return true;
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
	public String getName(){
		return userName;
	}
	
	
	
	/**
	 * @param aName
	 */
	public void setName(String aName){
		userName = aName;
	}
	
	
	/**
	 * @return
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * @return
	 */
	public String getEmail(){
		return email;
	}
	
	/**
	 * @param pw
	 */
	public void setpassword(String pw){
		password = pw;
	}
	
	
	public void setAccess(boolean hasAccess){
		this.hasAccess = hasAccess;
	}
	
	public boolean getAccess(){
		return hasAccess;
	}
	
	
}