package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.LoginPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {

	public LoginPage loginPage;
	public ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;

	public LoginStepDefinition() {
		loginPage = new LoginPage();
		configFileReader = new ConfigFileReader();
		seleniumUtils = new SeleniumUtils();

	}

	@Given("Je me connecte a l application Swag Labs")
	public void jeMeConnecteALApplicationSwagLabs() {
		loginPage.login();
	}

	@Then("Je me redirige vers la page home {string}")
	public void jeMeRedirigeVersLaPageHomeProducts(String title) {
		String title_page = LoginPage.titlePage.getText();
		Assert.assertEquals(title_page, title);
	}
	
	/* Login Outline */
	@Given("Je me connecte sur l application")
	public void jeMeConnecteSurLApplication() {
		loginPage.connectToApp();
	}

	@When("Je saisi le username {string}")
	public void jeSaisiLeUsername(String username) {
		loginPage.fillUsername(username);
	}

	@When("Je saisi le password {string}")
	public void jeSaisiLePassword(String password) {
		//loginPage.fillPassword(password);
		seleniumUtils.writeText(LoginPage.password, password);
	}

	@When("Je clique sur le bouton login")
	public void jeCliqueSurLeBoutonLogin() throws InterruptedException {
		loginPage.clickOnLogin();
	}

	@Then("Le message d erreur s affiche {string}")
	public void leMessageDErreurSAffiche(String msg) {
		String text_msg = LoginPage.errorMsg.getText();
		Assert.assertEquals(text_msg, msg);
	}

}
