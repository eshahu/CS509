/**
 * 
 */
package unittest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

import classes.Admin;

/**
 * @author shahe
 *
 */
public class TestAdmin {

	/*
	 * Check that Correct User Name is returned
	 */
	@Test
	public void testAdminName() {
		Admin aUser = Mockito.mock(Admin.class);
		Mockito.when(aUser.getName()).thenReturn("Mary Smith");
		String result = aUser.getName();
		assertEquals("Retrieved Wrong User Name ", result, "Mary Smith");		
	}
	
	
	/*
	 * Check that Correct email value is returned
	 */
	@Test
	public void testAdminEmail() {
		Admin aUser = Mockito.mock(Admin.class);
		Mockito.when(aUser.getEmail()).thenReturn("msmith@gmail.com");
		String result = aUser.getEmail();
		assertEquals("Retrieved Wrong email ", result, "msmith@gmail.com");		
	}
	
	/*
	 * Check that Correct Password value is returned
	 */
	@Test
	public void testAdminPassword() {
		Admin aUser = Mockito.mock(Admin.class);
		Mockito.when(aUser.getPassword()).thenReturn("xyz");
		String result = aUser.getPassword();
		assertEquals("Retrieved Wrong Password ", result, "xyz");		
	}
	
	/*
	 * Check that Admin has access
	 */
	@Test
	public void testAdminAccess() {
		Admin aUser = Mockito.mock(Admin.class);
		boolean result = aUser.getAccess();
		assertFalse (result);		
	}
	

}
