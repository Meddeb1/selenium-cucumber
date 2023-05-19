package com.e2etests.automation.step_definitions;

import org.junit.Assert;
import com.e2etests.automation.page_objects.LogoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogoutStepDefinition {
	
	private LogoutPage logoutPage;

	public LogoutStepDefinition() {
		logoutPage = new LogoutPage();
		
	}
	
	@When("Je clique sur le burguer menu button")
	public void jeCliqueSurLeBurguerMenuButton() {
		logoutPage.clickOnMenu();
		
	}

	@When("Je clique sur le bouton Logout")
	public void jeCliqueSurLeBoutonLogout() {
		logoutPage.clickOnLogout();
	}

	@Then("Je me redirige vers la page login {string}")
	public void jeMeRedirigeVersLaPageLogin(String titleLogo) {
		String title_page = LogoutPage.titlePage.getText();
		Assert.assertEquals(title_page, titleLogo);
		System.out.println("hello !!" +title_page);
	}

		
	   
}
