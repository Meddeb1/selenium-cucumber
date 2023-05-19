package com.e2etests.automation.page_objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class LoginPage {
	
	public ConfigFileReader configFileReader;

	/* Retrieve Element */
	@FindBy(how = How.ID, using = "user-name")
	public static WebElement username;

	@FindBy(how = How.ID, using = "password")
	public static WebElement password;

	@FindBy(how = How.ID, using = "login-button")
	public static WebElement btnLogin;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_button_container\"]/div/form/div[3]")
	public static WebElement errorMsg;

	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	public static WebElement titlePage;

	public LoginPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader = new ConfigFileReader();
	}

	/* Methods */
	public void login() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
		username.clear();
		username.sendKeys(configFileReader.getProperties("home.login"));
		password.clear();
		password.sendKeys(configFileReader.getProperties("home.password"));
		btnLogin.click();
	}
	
	public void connectToApp() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}
	
	public void fillUsername(String usr) {
		username.clear();
		username.sendKeys(usr);
	}
	
	public void fillPassword(String pswd) {
		password.clear();
		password.sendKeys(pswd);
	}
	
	public void clickOnLogin() throws InterruptedException {
		btnLogin.click();
		
	}
    
    

}
