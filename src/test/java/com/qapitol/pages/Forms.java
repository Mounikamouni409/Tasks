package com.qapitol.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.qapitol.utilities.Utilities;

public class Forms extends Utilities {

	WebDriver driver;

	public Forms(WebDriver driver) {

		this.driver = driver;

	}

	// By click_forms = By.xpath("//h5[text()='Forms']");
	By click_forms = By.xpath("//h5[text()='Forms']//ancestor::div[@class='card mt-4 top-card']");
	By practice = By.xpath("//span[text()='Practice Form']");
	By first = By.id("firstName");
	By last = By.id("lastName");
	By userEmail = By.id("userEmail");
	By select_gender = By.xpath("//label[text()='Female']");
	By user_number = By.id("userNumber");
	
	By dateOfBirth = By.id("dateOfBirthInput");
	By selectMonth = By.cssSelector(".react-datepicker__month-select");
	By selectYear = By.cssSelector(".react-datepicker__year-select");
	By select_date = By.xpath(" //div[contains(@class,'react-datepicker__day--004')] ");
	
	By subject = By.id("subjectsInput");
	By hobbiesCheckbox = By.xpath("//label[text()='Sports']"); 
	By uploadPicture = By.id("uploadPicture");
	
	By click_submit = By.id("submit");
	//By submitButton = By.id("submit");
	By confirmationModalTitle = By.className("modal-title");

	
	public void formsPractice() {

		javascriptByScroll(0, 200);
		WebElement forms = driver.findElement(click_forms);
		waitForElementToBeClickable(driver, 10, click_forms);
		// WaitForElementToBeVisible(driver, 5, forms);
		clickMethod(forms);

		WebElement practice_forms = driver.findElement(practice);
		clickMethod(practice_forms);
		
	}
	
	public void firstname() {

		WebElement firstName = driver.findElement(first);
		sendkeysMethod(firstName, "Mounika");
		
	}
	
	public void lastname() {
		

		WebElement lastName = driver.findElement(last);
		sendkeysMethod(lastName, "Patnam");
	}
	
	public void email() {
		

		WebElement email = driver.findElement(userEmail);
		sendkeysMethod(email, "mounika@gmail.com");
		
	}
	public void gender() {

		WebElement gender = driver.findElement(select_gender);
		javascriptByScroll(615, 408);
		clickMethod(gender);
		
	}
	public void mobile() {
		

		WebElement number = driver.findElement(user_number);
		sendkeysMethod(number, "9982288217");
	}
	
	public void dateOfBirth() {
		WebElement dob = driver.findElement(dateOfBirth);
		clickMethod(dob);
		
		Select month = new Select(driver.findElement(selectMonth));
		selectByOptionText(month, "January");
		
		Select year = new Select(driver.findElement(selectYear));
		selectByOptionText(year, "2000");
		
		
		WebElement date = driver.findElement(select_date);
		javascriptExecutor(driver, date);
		//clickMethod(date);
	}
	
	public void enter_subject() {
		WebElement sub = driver.findElement(subject);
		sendkeysMethod(sub, "english");
		sub.sendKeys(Keys.ENTER);
	}
	
	public void hobbies() {
		
		WebElement hobbie = driver.findElement(hobbiesCheckbox);
		javascriptExecutor(driver, hobbie);
		//clickMethod(hobbie);
	}
	
	public void pictureUpload() throws AWTException {
		
		WebElement picture = driver.findElement(uploadPicture);
		javascriptExecutor(driver, picture);
		//clickMethod(picture);
		
		Robot robot = new Robot();
		robot.delay(2000);
		
		// put the path to file in a clipboard
		StringSelection ss = new StringSelection("C:\\Users\\Qapitol QA\\Downloads\\Picture1.jpg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		
		//CTRL+V
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		//enter
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public void submit() {
		WebElement submit = driver.findElement(click_submit);
		//clickMethod(submit);
		javascriptExecutor(driver, submit);

		WebElement confirmation = driver.findElement(By.className("modal-title"));
		Assert.assertEquals(confirmation.getText(), "Thanks for submitting the form", "Form submission failed");

	}

}
