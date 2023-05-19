package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

import org.openqa.selenium.By;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Wait;

public class AboutPage {
	
	private SeleniumUtils seleniumUtils;
	private Wait wait ;

	@FindBy(how = How.ID, using = "about_sidebar_link")
	public static WebElement about;
	
	
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/header/div/div/div[1]/div[2]/div/div[1]/div[1]/div[1]/span")
	public static WebElement productsBtn;

	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/header/div/div/div[1]/div[2]/div/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/div[2]/div[2]/a/div/div/span")
	public static WebElement sauceBtn;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div[2]/div/div[2]/div[1]/div/div/div[2]/h2")
	public static WebElement title_p;

	public AboutPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		seleniumUtils = new SeleniumUtils();
		wait = new Wait(Setup.getDriver());

	}

	/* Methods */

	public void aboutClick() {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(about));
		about.click();
	}
	

	public void productClick() throws InterruptedException {
		/*Thread.sleep(2000);
		WebElement n=Setup.getDriver().findElement(productsBtn);
		Actions a = new Actions(Setup.getDriver());
	      a.moveToElement(n).perform();
		//seleniumUtils.clickOnElementUsingActions(productsBtn);*/
		
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(productsBtn));
		productsBtn.click();
		seleniumUtils.mouseHover(productsBtn);
	}

	public void sauceClick() throws InterruptedException {
		Thread.sleep(2000);
		sauceBtn.click();
	}

	

}
