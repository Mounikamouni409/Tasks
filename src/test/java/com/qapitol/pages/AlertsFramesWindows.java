package com.qapitol.pages;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qapitol.utilities.Utilities;

public class AlertsFramesWindows extends Utilities {
	
	WebDriver driver;
	
	public AlertsFramesWindows(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By alerts = By.xpath("//h5[text()='Alerts, Frame & Windows']");
	By browserWin = By.xpath("//span[normalize-space()='Browser Windows']");
	By newTab = By.id("tabButton");
	By newTabMesg = By.id("sampleHeading");
	
	By newwin = By.id("windowButton");
	By newWinMesg = By.id("sampleHeading");
	
	By winmesg = By.id("messageWindowButton");
	By mesg = By.xpath("//body [contains(text(),'Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.')]");
	
	By alerts_click = By.xpath("//span[normalize-space()='Alerts']");
	By seeAlert = By.id("alertButton");
	By confirmation = By.id("confirmButton");
	By prompt = By.id("promtButton");
	
	By frames = By.xpath("//span[normalize-space()='Frames']");
	By heading_1 = By.id("sampleHeading");
	By frame_2 = By.id("frame2");
	By heading_2 = By.id("sampleHeading");
	
	
	By nestedFrame = By.xpath("//span[normalize-space()='Nested Frames']");
	By parentFrame = By.tagName("body");
	By childFrame = By.tagName("iframe");
	By childFrameText = By.tagName("p");
	
	By modalDialogs = By.xpath("//span[normalize-space()='Modal Dialogs']");
	By smallModal = By.id("showSmallModal");
	By modalHeader = By.className("modal-header");
	By modalBody = By.className("modal-body");
	By closeSmallModalbutton = By.id("closeSmallModal");
	By largeModal = By.id("showLargeModal");
	By largeHeader = By.className("modal-header");
	By largeBody = By.className("modal-body");
	By largeModalClose = By.id("closeLargeModal");
	
	
	public  void frames() {
		
		WebElement window = driver.findElement(alerts);
		javascriptExecutor(driver, window);
		
		WebElement browwin = driver.findElement(browserWin);
		javascriptExecutor(driver, browwin);
	}
	
	public void newTabButton() {
		WebElement tab = driver.findElement(newTab);
		//clickMethod(tab);
		javascriptExecutor(driver, tab);
		
		
		
		String parentwindow = driver.getWindowHandle(); 
		Set<String> w = driver.getWindowHandles();    
		for(String win:w){        
			if(!win.equals(parentwindow)){            
				driver.switchTo().window(win);            
				System.out.println(driver.getCurrentUrl());        
				}    
			}    
		
		WebElement text = driver.findElement(newTabMesg);
		getText(text);
		
		driver.close();
		driver.switchTo().window(parentwindow);  
		
	}
	
	public void newWindowButton() {
		WebElement winbut = driver.findElement(newwin);
		javascriptExecutor(driver, winbut);
		//clickMethod(); 
		String parentwindows = driver.getWindowHandle();    
		Set<String> newWindow = driver.getWindowHandles();    
		for(String win:newWindow){        
			if(!win.equals(parentwindows)){            
				driver.switchTo().window(win);            
				//System.out.println(text.getText());        
				}    
			
			
			}
		WebElement mesg = driver.findElement(newWinMesg);
		getText(mesg);
		
		driver.close();
		driver.switchTo().window(parentwindows); 
		
	}
	
	public void newWindowMessage() {
		WebElement newwin = driver.findElement(winmesg);
		javascriptExecutor(driver, newwin);
		
		String parentwindows = driver.getWindowHandle();    
		Set<String> newWindow = driver.getWindowHandles();    
		for(String win:newWindow){        
			if(!win.equals(parentwindows)){            
				driver.switchTo().window(win);            
				//System.out.println(text.getText());        
				}    
			
			
			}
	//	WebElement win_mesg = driver.findElement(mesg);
		//getText(win_mesg);
		
		
		driver.close();
		driver.switchTo().window(parentwindows); 
	}
	
	
	public void alertsHandling() {
		
		WebElement alertButton = driver.findElement(alerts_click);
		javascriptExecutor(driver, alertButton);
		
		 WebElement simpleAlertButton = driver.findElement(seeAlert);
		 javascriptExecutor(driver, simpleAlertButton);
         
		 Alert simpleAlert = driver.switchTo().alert();
         System.out.println("Simple Alert Text: " + simpleAlert.getText());
         simpleAlert.accept();

         // Handle Confirmation Alert
         WebElement confirmAlertButton = driver.findElement(confirmation);
         javascriptExecutor(driver, confirmAlertButton);
        
         Alert confirmAlert = driver.switchTo().alert();
         System.out.println("Confirmation Alert Text: " + confirmAlert.getText());
         confirmAlert.dismiss(); 

         // Handle Prompt Alert
         WebElement promptAlertButton = driver.findElement(prompt);
         javascriptExecutor(driver, promptAlertButton);
        
         Alert promptAlert = driver.switchTo().alert();
         System.out.println("Prompt Alert Text: " + promptAlert.getText());
         promptAlert.sendKeys("Test Input");
         promptAlert.accept();
	}
	
	public void framesHandling() {
		
		WebElement frameClick = driver.findElement(frames);
		javascriptExecutor(driver, frameClick);
		
		
		driver.switchTo().frame("frame1");
        WebElement heading1 = driver.findElement(heading_1);
        System.out.println("Text in Frame 1: " + heading1.getText());
        
     // Switch back to the main content
        driver.switchTo().defaultContent();
        
        WebElement frame2 = driver.findElement(frame_2);
        driver.switchTo().frame(frame2);
        WebElement heading2 = driver.findElement(heading_2);
        System.out.println("Text in Frame 2: " + heading2.getText());
        
        driver.switchTo().defaultContent();
		
	}
	
	public void nestedFrames() {
		
		WebElement nested = driver.findElement(nestedFrame);
		javascriptExecutor(driver, nested);
		
		
		driver.switchTo().frame("frame1");

        // Find and print text from the parent frame
        WebElement parentText = driver.findElement(parentFrame);
        System.out.println("Text in Parent Frame: " + parentText.getText());

        // Switch to the child frame inside the parent frame
        driver.switchTo().frame(driver.findElement(childFrame));

        // Find and print text from the child frame
        WebElement childText = driver.findElement(childFrameText);
        System.out.println("Text in Child Frame: " + childText.getText());

        // Switch back to the main content
        driver.switchTo().defaultContent();
	}
	
	public void modalDialogs() {
		
		WebElement modal_click = driver.findElement(modalDialogs);
		javascriptExecutor(driver, modal_click);
		
		// Open the small modal dialog
        WebElement smallModalButton = driver.findElement(smallModal);
        javascriptExecutor(driver, smallModalButton);

        // Handle the small modal dialog
        WebElement smallModalHeader = driver.findElement(modalHeader);
        System.out.println("Small Modal Header: " + smallModalHeader.getText());

        WebElement smallModalBody = driver.findElement(modalBody);
        System.out.println("Small Modal Body: " + smallModalBody.getText());

        // Close the small modal dialog
        WebElement closeSmallModalButton = driver.findElement(closeSmallModalbutton);
        javascriptExecutor(driver, closeSmallModalButton);
        //closeSmallModalButton.click();

        // Open the large modal dialog
        WebElement largeModalButton = driver.findElement(largeModal);
        javascriptExecutor(driver, largeModalButton);
        //largeModalButton.click();

        // Handle the large modal dialog
        WebElement largeModalHeader = driver.findElement(largeHeader);
        System.out.println("Large Modal Header: " + largeModalHeader.getText());

        WebElement largeModalBody = driver.findElement(largeBody);
        System.out.println("Large Modal Body: " + largeModalBody.getText());

        // Close the large modal dialog
        WebElement closeLargeModalButton = driver.findElement(largeModalClose);
        javascriptExecutor(driver, closeLargeModalButton);
        //closeLargeModalButton.click();
	}
	
	
}
