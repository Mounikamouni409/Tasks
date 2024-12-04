package com.qapitol.Testcases;

import org.testng.annotations.Test;

import com.qapitol.pages.Elements;
import com.qaptiol.base.Baseclass;

public class ElementsTest extends Baseclass {
	
	@Test(priority=1)
	public void elementActions(){
		
		Elements e = new Elements(driver);
		e.elements();
		e.textBox();
		e.fullName();
		e.enterEmail();
		e.current_Address();
		e.permanent_Address();
		e.submit_Data();
		e.getOutput();
		
		
		e.clickCheckbox();
		e.clickToggle();
		e.selectCheckbox();
		
		e.radioButton();
		
		e.webtables();
		
		e.buttonsTab();
		
	}
	
	

}
