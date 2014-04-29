/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.AuditTrail;

/**
 * @author shahe
 *
 */
public class TestAuditTrail {

	@Test
	public void testTrackLogin() {
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackLogIn("myuser", "2012-12-28",true));
	}
	
	@Test
	public void testTrackEditAbuseReport(){
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackEditAbuseReport("myuser", "1", "2014-04-27"));
	}	
	
	@Test
	public void trackViewAbuseReport(){
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackViewAbuseReport("myuser", "1", "2014-04-27"));
	}
	
	@Test
	public void trackDownloadAbuseReport(){
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackDownloadAbuseReport("myuser", "1", "2014-04-27"));
	}
	
	@Test	
	public void trackUploadAbuseReport(){
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackFileUploaded("myuser", "1", "abusereport", "2014-04-27"));
	}
	
	@Test
	public void trackFileUploadedAbuseReport(){
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackFileUploaded("myuser", "1", "abusereport", "2014-04-27"));
	}
	
	@Test
	public void trackFileDownloadedAbuseReport(){
		AuditTrail at = new AuditTrail();
		assertTrue(at.trackFileDownloaded("myuser", "1", "abusereport", "2014-04-27"));
	}

}
