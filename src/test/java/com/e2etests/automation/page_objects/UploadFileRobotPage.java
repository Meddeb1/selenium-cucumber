package com.e2etests.automation.page_objects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.UploadFileWithRobot;

public class UploadFileRobotPage {

	private UploadFileWithRobot upRobot;
	public WebDriverWait wait;
	private ConfigFileReader configReader;
	public UploadFileRobotPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		upRobot = new UploadFileWithRobot();
		configReader = new ConfigFileReader();
		wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		
	}

	@FindBy(how = How.CSS, using = ".btn.btn-success.fileinput-button")
	public static WebElement uploadFile;
	
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'chapitre 1 par donia abdelkarim.pptx')]")
	public static WebElement upName;

	public void seConnecter() {

		Setup.getDriver().get(configReader.getProperties("home.uploadrobot"));
		wait = new WebDriverWait(Setup.getDriver(), Duration.ofSeconds(20));
		
	}
	
	public void uploadFile() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(uploadFile));
		Setup.getDriver().get(configReader.getProperties("home.filePath"));
		//uploadFile.click();
		upRobot.uploadFileWithRobot(configReader.getProperties("home.filePath"));
		Thread.sleep(3000);
	}
	

}
