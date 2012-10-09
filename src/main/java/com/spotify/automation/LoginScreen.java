package com.spotify.automation;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;

import com.spotify.utils.DataProperties;

public class LoginScreen extends AbstractScreen {
	private Pattern username;
	private Pattern password;
	private Pattern loginButton;
	private Pattern errorMessage;
	private Pattern loginWindow;
	private Region window;
	
	public LoginScreen() throws FindFailed {
		username = new Pattern(DataProperties.path("loginUsername.png"));
		password = new Pattern(DataProperties.path("loginPassword.png"));
		loginButton = new Pattern(DataProperties.path("loginSubmiButton.png"));
		loginWindow = new Pattern(DataProperties.path("loginWindow.png"));
		errorMessage = new Pattern(DataProperties.path("loginFailedLoginMessage.png"));
		
		window = getDriver().wait(loginWindow);
	}

	public LoginScreen enterLoginData(String user, String pass) throws FindFailed {
		window.type(password, pass);
		window.type(username, user);
		return this;
	}
	
	public LoginScreen clickLogIn() throws FindFailed {
		window.click(loginButton);
		return this;
	}
	
	public MainScreen clickLogIn(String vanish) throws FindFailed {
		window.click(loginButton);
		getDriver().waitVanish(loginWindow);
		return new MainScreen();
	}	
	
	public boolean isLoginWindowExist() {
		try {
			getDriver().find(loginWindow);
			return true;
		} catch (FindFailed e) {
			return false;
		}
	}
	
	public boolean isErrorExist() {
		try {
			window.find(errorMessage);
			return true;
		} catch (FindFailed e) {
			return false;
		}
	}
	
}
