package com.qapitol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qapitol.utilities.Utilities;

public class Interactions extends Utilities{
	
	WebDriver driver;

	public Interactions(WebDriver driver) {
		this.driver = driver;
	}
	
	By clickInteraction = By.xpath("//h5[text()='Interactions']");
	By clickSortable = By.xpath("//span[text()='Sortable']");
	By listItems = By.cssSelector(".vertical-list-container.mt-4");
	
	
	public void click_Interaction() {
		WebElement interaction = driver.findElement(clickInteraction);
		javascriptExecutor(driver, interaction);
	}
	
	public void sortable() {
		WebElement sort = driver.findElement(clickSortable);
		javascriptExecutor(driver, sort);
		
		 List<WebElement> items = driver.findElements(listItems);

         // Print the initial order of items
         System.out.println("Initial order of items:");
         for (WebElement item : items) {
             System.out.println(item.getText());
         }

         // Drag and drop to reorder
         Actions actions = new Actions(driver);

         // Move the first item to the position of the last item
         WebElement source = items.get(0); // First item
         WebElement target = items.get(items.size() - 1); // Last item
         actions.clickAndHold(source).moveToElement(target).release().perform();

         // Print the order of items after reordering
         items = driver.findElements(By.cssSelector(".vertical-list-container.mt-4"));
         System.out.println("Order of items after reordering:");
         for (WebElement item : items) {
             System.out.println(item.getText());
         }
	}

}
