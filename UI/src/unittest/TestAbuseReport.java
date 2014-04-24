package unittest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import classes.AbuseReport;


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

}
