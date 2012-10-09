package com.spotify.automation;

import com.spotify.utils.DataProperties;
import com.spotify.utils.Driver;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class AbstractScreen {
	protected final static double WIN_TIMEOUT = Double.parseDouble(DataProperties.get("window.timeout"));
	protected final static double CTL_TIMEOUT = Double.parseDouble(DataProperties.get("control.timeout"));
	
	protected Screen getDriver() {
		return Driver.getInstance();
	}
}
