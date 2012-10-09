package com.spotify.utils;

import org.sikuli.script.Screen;

public class Driver {
	private static Screen driver;
	
	public synchronized static Screen getInstance() {
		if (driver == null){
			driver = new Screen();
		}
		return driver;
	}
}
