package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import model.DBUtil;



/**
 * @author shahe
 *
 */
public class AuditTrail{

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private boolean track(String values) {
		boolean b=false;
		try {
			conn = DBUtil.getConnection();
			Calendar cal = Calendar.getInstance(); 
			String sql = String.format("insert into audittrail value(%s,'%s')", values,
					new java.sql.Timestamp(cal.getTimeInMillis()));
			pstmt = conn.prepareStatement(sql);
			int num = pstmt.executeUpdate();
			if(num==1) {
				b=true;
			}	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			this.close();
		}
		return b;
	}	

	public boolean trackLogIn(String username, String time, Boolean successful) {
		String message = "User login failed!";
		if (successful) {
			message = "User login successful!";
		}
		String values = String.format("NULL,'%s', NULL,'%s'",
				username, message);
		return track(values);
	}	

	public boolean trackEditAbuseReport(String username, String reportID, String time){
		String values = String.format("NULL,'%s', '%s','Abuse report edited!'",
				username, reportID);
		return track(values);
	}	

	public boolean trackViewAbuseReport(String username, String reportID, String time){
		String values = String.format("NULL,'%s', '%s','Abuse report viewed!'",
				username, reportID);
		return track(values);
	}	

	public boolean trackDownloadAbuseReport(String username, String reportID, String time){
		String values = String.format("NULL,'%s', '%s','Abuse report downloaded!'",
				username, reportID);
		return track(values);
	}

	public boolean trackFileUploaded(String username, String reportID, String fileName, String time){
		String values = String.format("NULL,'%s', '%s','File %s uploaded!'",
				username, reportID, fileName);
		return track(values);
	}

	public boolean trackFileDownloaded(String username, String reportID, String fileName, String time){
		String values = String.format("NULL,'%s', '%s','File %s downloaded!'",
				username, reportID, fileName);
		return track(values);
	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}