package com.spotify.automation;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.io.IOException;

import org.sikuli.script.FindFailed;
import org.sikuli.script.SikuliScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.spotify.utils.DataProperties;

public class BaseTestCase {
	/**
	 * This will hold general methods 
	 * to use across all test cases
	 * 
	 * In fact everything should work thru openSpotify and closeSpotify
	 * but I catch bug on Sikuli, so did workaround with Process class
	 */
	private SikuliScript script;
	private Process app;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, FindFailed {
//		openSpotify();
		app = run();
	}
	
	@AfterMethod
	public void tearDown() {
//		closeSpotify();
		stop();
	}

	private Process run() {
		try {
			return Runtime.getRuntime().exec(DataProperties.get("spotify.path"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	private void stop() {
		app.destroy();
	}	
	
	private void openSpotify() throws InterruptedException, FindFailed {
		try {
			script = new SikuliScript();
			script.openApp(DataProperties.get("spotify.path"));
		} catch (AWTException e) {
			fail("Can't opeen Spotify by path "+DataProperties.get("spotify.path"));
		}
	}
	
	private void closeSpotify() {
		//it should work like this but Sikuli crashed. don't 
		script.closeApp("Spotify"); 
	}	
}
