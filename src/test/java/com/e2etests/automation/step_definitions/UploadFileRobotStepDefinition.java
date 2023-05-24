package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.UploadFileRobotPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class UploadFileRobotStepDefinition {
	
	private UploadFileRobotPage uploadFileRobotPage;
	
	public UploadFileRobotStepDefinition() {
		uploadFileRobotPage = new UploadFileRobotPage();
	}
	

	@Given("Je me connecte aa l application")
	public void jeMeConnecteAaLApplication() throws InterruptedException {
		uploadFileRobotPage.seConnecter();
	   
	}
	@Given("Je teste la fonctionnalite de charger un fichier")
	public void jeTesteLaFonctionnaliteDeChargerUnFichier() throws InterruptedException {
		uploadFileRobotPage.uploadFile();
	}
	@Then("je verifie si le fichier est charge {string}")
	public void jeVerifieSiLeFichierEstCharge(String string) {
		String text_msg = UploadFileRobotPage.upName.getText();
		Assert.assertEquals(text_msg, string);
	    
	}




}
