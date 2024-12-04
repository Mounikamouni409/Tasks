package com.qapitol.Testcases;

import org.testng.annotations.Test;

import com.qapitol.pages.Widgets;
import com.qaptiol.base.Baseclass;

public class WidgetsTest extends Baseclass {
	
	@Test
	public void widgetsActions() {
		Widgets w = new Widgets(driver);
		w.clickWidgets();
		w.accordian();
		w.autoComplete();
		w.datePicker();
		w.slider();
		w.progressBar();
		w.tabs();
		w.toolTip();
		
	}
	
	
	

}
