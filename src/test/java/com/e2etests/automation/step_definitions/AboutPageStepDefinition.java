package com.e2etests.automation.step_definitions;


import org.junit.Assert;

import com.e2etests.automation.page_objects.AboutPage;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AboutPageStepDefinition {

	private AboutPage aboutPage;

	public AboutPageStepDefinition() {
		aboutPage = new AboutPage();
	}
	@When("Je clique about")
	public void jeCliqueAbout() {
	   aboutPage.aboutClick();
	   //aboutPage.coockiesClick();
	}
	
	@When("Je survole le menu Products")
	public void jeSurvoleLeMenuProducts() throws InterruptedException {
	  aboutPage.productClick();
	}

	@When("Je clique sur Sauce Mobile")
	public void jeCliqueSurSauceMobile() throws InterruptedException {
		Thread.sleep(2000);
	   aboutPage.sauceClick();
	}
	@Then("Je me redirige vers la page  Sauce Mobile {string}")
	public void jeMeRedirigeVersLaPageSauceMobile(String x) throws InterruptedException {
		Thread.sleep(2000);
		String title_page = AboutPage.title_p.getText();
		Assert.assertEquals(title_page, x);
		//System.out.println(title_page);
	    
	}



}
