/**
 * @author Mykhailo Poliarush
 * Test automation of login functionality
 */
package com.spotify.automation;


import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import org.testng.annotations.Test;

import com.spotify.utils.DataProperties;


public class LoginTest extends BaseTestCase{
	
	@Test
	public void testInvalidLogin() throws Exception {
		LoginScreen login = new LoginScreen();
		login.enterLoginData(
				DataProperties.get("invalid.login"), 
				DataProperties.get("invalid.password"))
			.clickLogIn();
		assertTrue(login.isErrorExist());
	}

	@Test
	public void testValidLogin() throws Exception {
		LoginScreen login = new LoginScreen();
		MainScreen main = login
				.enterLoginData(
						DataProperties.get("valid.login"), 
						DataProperties.get("valid.password"))
				.clickLogIn("and wait for vanish");
		assertFalse(login.isLoginWindowExist());
	}
}
