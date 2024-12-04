package com.qapitol.Testcases;

import org.testng.annotations.Test;

import com.qapitol.pages.AlertsFramesWindows;
import com.qaptiol.base.Baseclass;

public class AlertsTest extends Baseclass{
	
	@Test
	public void frames() {
		AlertsFramesWindows a = new AlertsFramesWindows(driver);
		a.frames();
		a.newTabButton();
		a.newWindowButton();
		a.newWindowMessage();
		a.alertsHandling();
		a.framesHandling();
		a.nestedFrames();
		a.modalDialogs();
		
	}

}
