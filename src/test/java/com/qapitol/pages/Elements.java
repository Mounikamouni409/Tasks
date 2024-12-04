package com.qapitol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qapitol.utilities.Utilities;

public class Elements extends Utilities {

	WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}

	By elements = By.xpath("//div[@class='avatar mx-auto white']");
	By text = By.id("item-0");
	By fullname = By.xpath("//input[@class=' mr-sm-2 form-control']");
	By email = By.id("userEmail");
	By current = By.id("currentAddress");
	By permanent = By.id("permanentAddress");
	By submit = By.id("submit");
	By output = By.id("output");

	// Checkbox

	By checkbox = By.id("item-1");
	By toggle = By.xpath("//button[@class='rct-collapse rct-collapse-btn']");
	By check = By.cssSelector(".rct-checkbox");
	By result = By.id("result");

	// Radio button

	By radio_button = By.id("item-2");
	// By selectRadio =
	// By.cssSelector(".custom-control.custom-radio.custom-control-inline");

	By click_yes = By.xpath("//label[@for='yesRadio']");

	// WebTables

	By webTables = By.xpath("//span[text()='Web Tables']");
	By add = By.id("addNewRecordButton");
	By firstname = By.id("firstName");
	By lastname = By.id("lastName");
	By userEmail = By.id("userEmail");
	By age = By.id("age");
	By salary = By.id("salary");
	By depart = By.id("department");
	By submit_web = By.id("submit");

	By user = By.className("rt-tbody");

	// Buttons

	By click_button = By.xpath("//span[text()='Buttons']");
	By click_double = By.id("doubleClickBtn");
	By double_message = By.id("doubleClickMessage");
	By right_click = By.id("rightClickBtn");
	By single_click = By.id("rightClickBtn");
	By dynamic_click = By.id("dynamicClickMessage");
	
	
	//links 
	
	By click_links = By.id("item-5");
	//By 

	public void elements() {

		javascriptByScroll(0, 200);

		WebElement element = driver.findElement(elements);
		WaitForElementToBeVisible(driver, 5, element);
		clickMethod(element);

	}

	public void textBox() {

		WebElement textBox = driver.findElement(text);
		clickMethod(textBox);

	}

	public void fullName() {
		WebElement name = driver.findElement(fullname);
		sendkeysMethod(name, "Mounika");
	}

	public void enterEmail() {
		WebElement enter_mail = driver.findElement(email);
		sendkeysMethod(enter_mail, "abc@gmail.com");
	}

	public void current_Address() {
		WebElement address = driver.findElement(current);
		sendkeysMethod(address, "Bangalore, Karnataka");
	}

	public void permanent_Address() {
		WebElement address = driver.findElement(permanent);
		sendkeysMethod(address, "Thatiparti,Nellore, Andhrapradesh");
	}

	public void submit_Data() {

		WebElement button = driver.findElement(submit);
		javascriptByScroll(0, 300);
		clickMethod(button);

	}

	public void getOutput() {
		WebElement out = driver.findElement(output);
		getText(out);
	}

	// Checkbox
	public void clickCheckbox() {

		WebElement check = driver.findElement(checkbox);
		clickMethod(check);

	}

	public void clickToggle() {
		WebElement togg = driver.findElement(toggle);
		clickMethod(togg);

	}

	public void selectCheckbox() {

		WebElement selectElement = driver.findElement(check);
		javascriptExecutor(driver, selectElement);

		WebElement resultCheckBox = driver.findElement(result);
		getText(resultCheckBox);
	}

	// Radio Button

	public void radioButton() {
		WebElement clickradio = driver.findElement(radio_button);
		javascriptExecutor(driver, clickradio);

		WebElement yes = driver.findElement(click_yes);
		javascriptExecutor(driver, yes);

	}

	// WebTables

	public void webtables() {

		WebElement table = driver.findElement(webTables);
		clickMethod(table);

		WebElement click_add = driver.findElement(add);
		javascriptExecutor(driver, click_add);
		

		WebElement firstName = driver.findElement(firstname);
		sendkeysMethod(firstName, "Mounika");

		WebElement lastName = driver.findElement(lastname);
		sendkeysMethod(lastName, "Patnam");

		WebElement emailElement = driver.findElement(userEmail);
		sendkeysMethod(emailElement, "mounika@gmail.com");

		WebElement enter_age = driver.findElement(age);
		sendkeysMethod(enter_age, "25");

		WebElement enter_salary = driver.findElement(salary);
		sendkeysMethod(enter_salary, "387828");

		WebElement department = driver.findElement(depart);
		sendkeysMethod(department, "Engineering");

		WebElement submit = driver.findElement(submit_web);
		javascriptExecutor(driver, submit);
		

		//WebElement added_user = driver.findElement(user);
		//Assert.assertTrue(added_user.getText().contains("Mounika"), "New record not found in web tables");

	}

	public void buttonsTab() {

		WebElement buttons = driver.findElement(click_button);
		javascriptExecutor(driver, buttons);

		WebElement doubleClickBtn = driver.findElement(click_double);

		Actions actions = new Actions(driver);
		actions.doubleClick(doubleClickBtn).build().perform();

		/*WebElement doubleClickMessage = driver.findElement(double_message);
		Assert.assertEquals(doubleClickMessage.getText(), "You have done a double click", "Double click action failed");*/
		
		WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightClickBtn).perform();

		
		/*WebElement rightClickMessage = driver.findElement(By.id("rightClickMessage"));
		Assert.assertEquals(rightClickMessage.getText(), "You have done a right click", "Right click action failed");*/

		WebElement clickBtn = driver.findElement(single_click);
		javascriptExecutor(driver, clickBtn);
		
		//WebElement clickMessage = driver.findElement(dynamic_click);
		
		//Assert.assertEquals(clickMessage.getText(), "You have done a dynamic click", "Single click action failed");

	}
	
	
}
