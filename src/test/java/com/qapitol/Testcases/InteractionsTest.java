package com.qapitol.Testcases;

import org.testng.annotations.Test;

import com.qapitol.pages.Interactions;
import com.qaptiol.base.Baseclass;

public class InteractionsTest extends Baseclass{
	
	@Test
	public void interaction() {
		Interactions i = new Interactions(driver);
		i.click_Interaction();
		i.sortable();
	}

}
