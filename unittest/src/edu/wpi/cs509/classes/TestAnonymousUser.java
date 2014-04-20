/**
 * 
 */
package edu.wpi.cs509.classes;

import org.mockito.Mockito;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author shahe
 *
 */
public class TestAnonymousUser {
	
	/*
	 * Check that Correct User Name is returned
	 */
	@Test
	public void testAnonymousUserName() {
		AnonymousUser aUser = Mockito.mock(AnonymousUser.class);
		Mockito.when(aUser.getName()).thenReturn("Mary Smith");
		String result = aUser.getName();
		assertEquals("Retrieved Wrong User Name ", result, "Mary Smith");		
	}
	
	
	/*
	 * Check that Correct email value is returned
	 */
	@Test
	public void testAnonymousUserEmail() {
		AnonymousUser aUser = Mockito.mock(AnonymousUser.class);
		Mockito.when(aUser.getEmail()).thenReturn("msmith@gmail.com");
		String result = aUser.getEmail();
		assertEquals("Retrieved Wrong email ", result, "msmith@gmail.com");		
	}
	
	/*
	 * Check that Correct Password value is returned
	 */
	@Test
	public void testAnonymousUserPassword() {
		AnonymousUser aUser = Mockito.mock(AnonymousUser.class);
		Mockito.when(aUser.getPassword()).thenReturn("xyz");
		String result = aUser.getPassword();
		assertEquals("Retrieved Wrong Password ", result, "xyz");		
	}
	
}
