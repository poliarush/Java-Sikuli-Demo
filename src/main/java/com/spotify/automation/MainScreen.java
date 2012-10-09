package com.spotify.automation;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;

import com.spotify.utils.DataProperties;

public class MainScreen extends AbstractScreen {
	private Pattern search;
	private Pattern showAllResults;
	private Pattern songButtons;
	private Pattern firstSong;
	private Pattern mainWindow;
	
	private Region window;
	
	public MainScreen() throws FindFailed {
		search = new Pattern(DataProperties.path("mainSearch.png"));
		showAllResults = new Pattern(DataProperties.path("mainShowAllResults.png"));
		songButtons = new Pattern(DataProperties.path("mainSongButtons.png"));
		mainWindow = new Pattern(DataProperties.path("mainWindow.png"));
		firstSong = new Pattern(DataProperties.path("mainFoundRecord.png"));
		
		window = getDriver().wait(mainWindow.similar((float)0.30));		
	}
	
	public MainScreen lookUpForSong(String text) throws FindFailed {
		window.type(search, text);
		waitAndClick(showAllResults);
		return this;
	}
	
	public MainScreen clickFirstFoundSong() throws FindFailed {
		//here can be more complex logic how to identify first records
		//however, i will do just click for for simplification
		waitAndDoubleClick(firstSong);
		return this;
	}

	public boolean isSongPlaying(){
		try {
			window.find(songButtons.similar((float) 1.00));
			return true;
		} catch (FindFailed e) {
			return false;
		}	
	}

	private void waitAndClick(Pattern pattern) throws FindFailed {
		window.wait(pattern);
		window.click(pattern);
	}	
	
	private void waitAndDoubleClick(Pattern pattern) throws FindFailed {
		window.wait(pattern);
		window.doubleClick(pattern);
	}		
}
