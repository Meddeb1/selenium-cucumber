package com.e2etests.automation.page_objects;


import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.e2etests.automation.utils.Setup;


public class LogoutPage {
	
	
	/*retrieve elements*/
	
	@FindBy(how = How.ID, using = "react-burger-menu-btn")
    public static WebElement menu;
		
	@FindBy(how = How.XPATH, using = "//*[@id=\"logout_sidebar_link\"]")
    public static WebElement logoutBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='login_logo']")
    public static WebElement titlePage;
	
	public LogoutPage() {
    	PageFactory.initElements(Setup.getDriver(), this);
    	
    }
	
	/*Methods */
	
	public void clickOnMenu() {
		menu.click();
    }
	
	public void clickOnLogout() {
		WebDriverWait wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
		logoutBtn.click();
		
		
    }

}
