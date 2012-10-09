/**
 * @author Mykhailo Poliarush
 * Test automation of search and play functionality
 */

package com.spotify.automation;

import static org.testng.Assert.assertTrue;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import com.spotify.utils.DataProperties;

public class SearchAndPlayTest extends BaseTestCase {
	
	@Test
	public void searchAndPlayTest() throws FindFailed, InterruptedException {
		LoginScreen login = new LoginScreen();
		MainScreen mainWindow = login
				.enterLoginData(
						DataProperties.get("valid.login"), 
						DataProperties.get("valid.password"))
				.clickLogIn("and wait for vanish");
		mainWindow
			.lookUpForSong(DataProperties.get("search.request"))
			.clickFirstFoundSong();
		Thread.sleep(5000);//this here just to listen to music :) in fact, it should be deleted
		assertTrue(mainWindow.isSongPlaying());
	}	
}
