package classes;

/**
 * @author shahe
 * 
 */
public abstract class User {

	protected String firstName;
	protected String lastName;
	protected String password;
	protected String email;
	protected boolean isAdmin;
	protected boolean isSupervisor;
	public boolean hasAccess;

	//  supervisor
	public User(String email, String password) {
		this.email = email;
		this.password = password;

	}
	
	// admin user
	public User(String firstName, String lastName, String password,
			String email, boolean hasAccess) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.hasAccess = hasAccess;
	}
	
	public User(String firstName, String lastName, String password, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.hasAccess = false;
	}
	
	public User(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hasAccess = false;
	}

	// Anoymous user
	public User(String lastName) {
		this.lastName = lastName;
		this.hasAccess = false;
	}


	public Boolean logIn() {
		return true;
	}

	public void logOut() {

	}

	/**
	 * @param pw
	 */
	public void changePassword(String pw) {
		this.password = pw;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param aName
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param pw
	 */
	public void setpassword(String pw) {
		password = pw;
	}

	public void setAccess(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}

	public boolean getAccess() {
		return hasAccess;
	}

}