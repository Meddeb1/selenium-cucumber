package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.AlertDemoPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AlertDemoStepDefinition {
	private AlertDemoPage alertDemoPage;

	public AlertDemoStepDefinition() {
		alertDemoPage = new AlertDemoPage();
	}

	@Given("Je me connecte et je teste le buton alert demo")
	public void jeMeConnecteEtJeTesteLeButonAlertDemo() {
		alertDemoPage.ouvrerApp();
		alertDemoPage.verifierClick();
	}

	@Then("Je confirme l'alert")
	public void jeConfirmeLAlert() {

	}

	@Given("Je me connecte et je teste le double click")
	public void jeMeConnecteEtJeTesteLeDoubleClick() {
		alertDemoPage.dblClick();
	}

}