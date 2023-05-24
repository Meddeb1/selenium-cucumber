package com.e2etests.automation.page_objects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class AlertDemoPage {
	
	private ConfigFileReader configFileReader;
	private WebDriver driver = Setup.getDriver();
	
	@FindBy(how = How.ID, using = "alertButton")
	public static WebElement boutonAlert;

	@FindBy(how = How.ID, using = "doubleClickBtn")
	public static WebElement dblClickBtn;

	@FindBy(how = How.ID, using = "doubleClickMessage")
	public static WebElement message;

	public AlertDemoPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader = new ConfigFileReader();
	}

	public void ouvrerApp() {
		driver.get(configFileReader.getProperties("demo.url"));
	}

	public void verifierClick() {

		boutonAlert.click();
		driver.switchTo().alert().accept();
		String title = driver.getTitle();
		System.out.println("title of the page is : " + title);
	}

	public void dblClick() {
		driver.get(configFileReader.getProperties("demodblclick.url"));
		Actions actions = new Actions(driver);
		actions.doubleClick(dblClickBtn).perform();
		System.out.println("button is double clicked");
		String msg = message.getText();
		Assert.assertEquals("You have done a double click", msg);

	}

}
