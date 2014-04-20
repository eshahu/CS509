


/**
 * @author shahe
 *
 */
public class Supervisor extends User{

	
	public Supervisor(String userName, String password, String email) {
		super(userName, password, email);
		setAccess(true);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param ar
	 */
	public void viewReport(AbuseReport ar){
		
	}
	
	/**
	 * @param logID
	 */
	public void searchByLogID(String logID){
		
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
	
	/**
	 * @param ar
	 */
	public void printReport(AbuseReport ar){
		
	}
	
	/**
	 * @param fileType
	 */
	public void uploadFile(String fileType){
		
	}
	
	/**
	 * @param fileType
	 */
	public void downloadFile(String fileType){
		
	}
}