package com.qapitol.Testcases;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.qapitol.pages.Forms;
import com.qaptiol.base.Baseclass;

public class FormsTest extends Baseclass{
	
	@Test(priority= 2)
	public void formTest() throws AWTException {
		
		Forms f = new Forms(driver);
		f.formsPractice();
		f.firstname();
		f.lastname();
		f.email();
		f.gender();
		f.mobile();
		f.dateOfBirth();
		f.enter_subject();
		f.hobbies();
		f.pictureUpload();
		f.submit();
		
	}
	
	

}
