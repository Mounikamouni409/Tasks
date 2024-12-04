package com.qapitol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qapitol.utilities.Utilities;

public class Widgets extends Utilities {
	WebDriver driver;

	public Widgets(WebDriver driver) {
		this.driver = driver;
	}

	By click_widgets = By.xpath("//h5[text()='Widgets']");
	By click_accordian = By.xpath("//span[text()='Accordian']");
	By section1_heading = By.id("section1Heading");
	By section1_content = By.id("section1Content");
	By section2_heading = By.id("section2Heading");
	By section2_content = By.id("section2Content");
	By section3_heading = By.id("section3Heading");
	By section3_content = By.id("section3Content");

	By auto_Complete = By.xpath("//span[text()='Auto Complete']");
	By autoInput = By.id("autoCompleteMultipleInput");
	By suggest = By.cssSelector(".auto-complete__option");
	By displayItem = By.cssSelector(".css-12jo7m5 .auto-complete__multi-value__label");

	By datePick = By.xpath("//span[text()='Date Picker']");
	By inputOfDate = By.id("datePickerMonthYearInput");
	By month = By.className("react-datepicker__month-select");
	By year = By.className("react-datepicker__year-select");
	By enterDay = By.xpath("//div[text()='25']");

	By slide = By.xpath("//span[text()='Slider']");

	By progressbar = By.xpath("//span[text()='Progress Bar']");
	By start = By.id("startStopButton");
	By bar = By.className("progress-bar");
	By reset = By.id("resetButton");

	By tab = By.xpath("//span[text()='Tabs']");
	By clickTabs = By.cssSelector(".nav-tabs .nav-item");
	By tabcontent = By.cssSelector(".tab-content .fade.show.active");
	
	By tooltip = By.xpath("//span[text()='Tool Tips']");
	By tooltipButton = By.id("toolTipButton");
	By innerToolTip = By.cssSelector(".tooltip-inner");

	public void clickWidgets() {

		WebElement widget = driver.findElement(click_widgets);
		javascriptExecutor(driver, widget);
	}

	public void accordian() {

		WebElement accordian_click = driver.findElement(click_accordian);
		javascriptExecutor(driver, accordian_click);

		WebElement section1Heading = driver.findElement(section1_heading);
		javascriptExecutor(driver, section1Heading);

		// Retrieve and print the content of the first section
		WebElement section1Content = driver.findElement(section1_content);
		System.out.println("Section 1 Content: " + section1Content.getText());

		// Locate and click the second section heading
		WebElement section2Heading = driver.findElement(section2_heading);
		javascriptExecutor(driver, section2Heading);

		// Retrieve and print the content of the second section
		WebElement section2Content = driver.findElement(section2_content);
		System.out.println("Section 2 Content: " + section2Content.getText());

		// Locate and click the third section heading
		WebElement section3Heading = driver.findElement(section3_heading);
		javascriptExecutor(driver, section3Heading);

		// Retrieve and print the content of the third section
		WebElement section3Content = driver.findElement(section3_content);
		System.out.println("Section 3 Content: " + section3Content.getText());
	}

	public void autoComplete() {

		WebElement click_AutoComplete = driver.findElement(auto_Complete);
		javascriptExecutor(driver, click_AutoComplete);

		// Locate the multiple color input field
		WebElement autoCompleteInput = driver.findElement(autoInput);
		sendkeysMethod(autoCompleteInput, "Re");

		implicitWait(driver, 5);

		// Get the list of suggestions
		List<WebElement> suggestions = driver.findElements(suggest);

		// Print and select a suggestion (e.g., "Red")
		for (WebElement suggestion : suggestions) {
			System.out.println("Suggestion: " + suggestion.getText());
			if (suggestion.getText().equalsIgnoreCase("Red")) {
				javascriptExecutor(driver, suggestion);
				// suggestion.click();
				break;
			}
		}

		// Verify the selected value is displayed
		List<WebElement> selectedItems = driver.findElements(displayItem);
		for (WebElement item : selectedItems) {
			System.out.println("Selected: " + item.getText());
		}

	}

	public void datePicker() {

		WebElement datePicker = driver.findElement(datePick);
		javascriptExecutor(driver, datePicker);

		WebElement dateInput = driver.findElement(inputOfDate);

		// Clear any existing date and input a new date
		dateInput.clear();
		sendkeysMethod(dateInput, "11/25/2024");
		sendkeysMethod(dateInput, "\n");

		// Retrieve and verify the entered date
		String selectedDate = dateInput.getAttribute("value");
		System.out.println("Selected Date: " + selectedDate);

		javascriptExecutor(driver, dateInput);

		WebElement monthDropdown = driver.findElement(month);
		sendkeysMethod(monthDropdown, "November");

		WebElement yearDropdown = driver.findElement(year);
		sendkeysMethod(yearDropdown, "2024");

		WebElement day = driver.findElement(enterDay);
		javascriptExecutor(driver, day);
		// clickMethod(day);

		// Verify the date selected through the calendar UI
		selectedDate = dateInput.getAttribute("value");
		System.out.println("Date Selected from Calendar: " + selectedDate);
	}

	public void slider() {

		WebElement slider = driver.findElement(slide);
		javascriptExecutor(driver, slider);

		WebElement range_slider = driver.findElement(By.className("range-slider"));

		// Locate the slider value field
		WebElement sliderValue = driver.findElement(By.id("sliderValue"));

		// Create an Actions object to perform slider movement
		Actions actions = new Actions(driver);

		// Move the slider to a desired value
		int desiredValue = 50; // Set your desired value here
		int currentValue = Integer.parseInt(sliderValue.getAttribute("value"));
		int offset = (desiredValue - currentValue) * 2; // Scale adjustment for slider steps
		actions.dragAndDropBy(slider, offset, 0).perform();

		// Verify the slider value after moving
		String selectedValue = sliderValue.getAttribute("value");
		System.out.println("Selected Slider Value: " + selectedValue);

	}

	public void progressBar() {

		WebElement clickProgressBar = driver.findElement(progressbar);
		javascriptExecutor(driver, clickProgressBar);

		WebElement startButton = driver.findElement(start);
		javascriptExecutor(driver, startButton);

		// Monitor the progress bar
		WebElement progressBar = driver.findElement(bar);
		String progressValue;

		do {
			// Get the progress percentage
			progressValue = progressBar.getText();
			//System.out.println("Progress: " + progressValue);

			implicitWait(driver, 5);
		} while (!progressValue.equals("100%")); // Wait until progress reaches 100%

		System.out.println("Progress Bar reached 100%");

		// Optionally, click Stop or Reset buttons if needed
		WebElement resetButton = driver.findElement(reset);
		javascriptExecutor(driver, resetButton);

	}

	public void tabs() {
		WebElement clickTab = driver.findElement(tab);
		javascriptExecutor(driver, clickTab);

		List<WebElement> tabs = driver.findElements(clickTabs);

		// Iterate through each tab, click it, and print its content
		for (WebElement tab : tabs) {
			
			javascriptExecutor(driver, tab);
			//tab.click();

			String tabName = tab.getText();

			// Locate the tab content section and get its text
			WebElement tabContent = driver.findElement(tabcontent);
			String content = tabContent.getText();

			// Print the tab name and content
			System.out.println("Tab: " + tabName);
			System.out.println("Content: " + content);
			System.out.println("----------------------");
		}
	}
	
	public void toolTip() {
		
		WebElement tool = driver.findElement(tooltip);
		javascriptExecutor(driver, tool);
		
		
		WebElement toolTipButton = driver.findElement(tooltipButton);

        // Use Actions class to hover over the element
        Actions actions = new Actions(driver);
        actions.moveToElement(toolTipButton).perform();

        // Locate the tooltip element (it appears dynamically)
        WebElement tooltip = driver.findElement(innerToolTip);

        // Print the tooltip text
        String tooltipText = tooltip.getText();
        System.out.println("Tooltip text: " + tooltipText);
	}
}
