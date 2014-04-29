/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import classes.File;

/**
 * @author shahe
 *
 */
public class TestFile {

	@Test
	public void testGetFilName() {
		File aFile = Mockito.mock(File.class);
		Mockito.when(aFile.getFileName()).thenReturn("AFILE");
		String result = aFile.getFileName();
		assertEquals(result, "AFILE");	
		
	}
	
	@Test
	public void testSetFileName(){
		File aFile = new File("AFILE");
		assertEquals(aFile.getFileName(), "AFILE");	
	}	
	
}
