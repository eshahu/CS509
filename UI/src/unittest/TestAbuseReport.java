package unittest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import classes.AbuseReport;
import classes.File;
import classes.User;


/**
 * @author shahe
 *
 */
public class TestAbuseReport {

	/**
	 * Chec the  Abuse Name retrieved is the correct one
	 *
	 */
	@Test
	public void testGetAbuseName() {
		AbuseReport aReport = Mockito.mock(AbuseReport.class);
		Mockito.when(aReport.getAbuseName()).thenReturn("Mary Smith");
		String result = aReport.getAbuseName();
		assertEquals("Retrieved Wrong Abuser Name ", result, "Mary Smith");		
	}
	
	/**
	 * Check the logId retrieved is the correct one
	 *
	 */
	@Test
	public void testGetLogID() {
		AbuseReport aReport = Mockito.mock(AbuseReport.class);
		Mockito.when(aReport.getLogID()).thenReturn("123");
		String result = aReport.getLogID();
		assertEquals("Retrieved Wrong LogID ", result, "123");		
	}

	/**
	 * Check that submission status is updated correctly
	 *
	 */
	@Test
	public void testIsSubmitted() {
		AbuseReport aReport = Mockito.mock(AbuseReport.class);
		Mockito.when(aReport.isSubmitted()).thenReturn(true);
		boolean firstresult = aReport.isSubmitted();
		assertTrue(firstresult);	
		
		Mockito.when(aReport.isSubmitted()).thenReturn(false);
		boolean secresult = aReport.isSubmitted();
		assertFalse(secresult);	
	}
	
	/**
	 * Check the FileNames retrieved are the correct one
	 *
	 */
	@Test
	public void testGetFileNames() {
		List<File> files = new ArrayList<File>();
		File file1 = new File ("TestFileName1");
		File file2 = new File ("TestFileName2");
		files.add(file1);
		files.add(file2);
		User aUser = Mockito.mock(User.class);
		AbuseReport aReport = new AbuseReport("1111111", "test", aUser, true, files);
		assertEquals("Retrieved Wrong Number of Files ", aReport.getFilenames(), files);
		assertEquals("Retrieved Wrong FileName ", aReport.getFilenames().get(0).getFileName(), "TestFileName1");
		assertEquals("Retrieved Wrong FileName ", aReport.getFilenames().get(1).getFileName(), "TestFileName2");
	}

}
