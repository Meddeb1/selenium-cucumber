package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.IToDo;
import com.e2etests.automation.page_objects.TodoPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;
import static org.junit.jupiter.api.Assertions.assertAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoStepDefinition {
	
	 private IToDo todoMvc;

	    private final String buyTheMilk = "Buy the milk";
	    private final String cleanupTheRoom = "Clean up the room";
	    private final String readTheBook = "Read the book";

	private TodoPage todoPage;
	private ConfigFileReader config;
	

	public TodoStepDefinition() {
		todoPage = new TodoPage();
		config = new ConfigFileReader();
		
	}

	@Given("Je me connecte a l application")
	public void jeMeConnecteALApplication() {
		todoPage.navigateTo();
	}

	@When("Je souhaite ajouter un todo")
	public void jeSouhaiteAjouterUnTodo() {
		todoPage.createTodo(config.getProperties("home.todos"));
		  assertAll(
	                () -> assertEquals(1, todoMvc.getTodosLeft()),
	                () -> assertTrue(todoMvc.todoExists(buyTheMilk))
	        );
	}



	@Then("Je supprime le todo")
	public void jeSupprimeLeTodo() {
		todoPage.removeTodo(config.getProperties("home.todos"));
		Setup.getDriver().navigate().refresh();
	    
	}
	


	@Then("Je check")
	public Boolean jeCheck() {
		Setup.getDriver().navigate().refresh();
		return todoPage.todoExists(config.getProperties("home.todos"));
	
		
	}




}
