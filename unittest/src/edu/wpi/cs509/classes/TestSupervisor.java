
package edu.wpi.cs509.classes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * @author shahe
 *
 */
public class TestSupervisor {

	/*
	 * Check that Correct User Name is returned
	 */
	@Test
	public void testSupervisorName() {
		Supervisor aUser = Mockito.mock(Supervisor.class);
		Mockito.when(aUser.getName()).thenReturn("Mary Smith");
		String result = aUser.getName();
		assertEquals("Retrieved Wrong User Name ", result, "Mary Smith");		
	}
	
	
	/*
	 * Check that Correct email value is returned
	 */
	@Test
	public void testSupervisorEmail() {
		Supervisor aUser = Mockito.mock(Supervisor.class);
		Mockito.when(aUser.getEmail()).thenReturn("msmith@gmail.com");
		String result = aUser.getEmail();
		assertEquals("Retrieved Wrong email ", result, "msmith@gmail.com");		
	}
	
	/*
	 * Check that Correct Password value is returned
	 */
	@Test
	public void testSupervisorPassword() {
		Supervisor aUser = Mockito.mock(Supervisor.class);
		Mockito.when(aUser.getPassword()).thenReturn("xyz");
		String result = aUser.getPassword();
		assertEquals("Retrieved Wrong Password ", result, "xyz");		
	}
	
	/*
	 * Check that Supervisor has access
	 */
	@Test
	public void testSupervisorAccess() {
		Supervisor aUser = Mockito.mock(Supervisor.class);
		boolean result = aUser.getAccess();
		assertTrue (result);		
	}
}
