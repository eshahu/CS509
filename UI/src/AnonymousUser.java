

/**
 * @author shahe
 *
 */
public class AnonymousUser extends User{
	
	public AnonymousUser(String userName, String password, String email) {
		super(userName, password, email);
		// TODO Auto-generated constructor stub
	}

	public AnonymousUser(String userName, String password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}

	public AnonymousUser(String userName) {
		super(userName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ar
	 * @param an
	 */
	public void editAbuseReportName(AbuseReport ar, String an){
		
	}
	
	/**
	 * @param ar
	 * @param ad
	 */
	public void editAbuseReportDescription(AbuseReport ar, String ad){
		
	}
	
	/**
	 * @param ar
	 */
	public void submitReport(AbuseReport ar){
		
	}
	
}