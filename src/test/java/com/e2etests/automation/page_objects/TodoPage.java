package com.e2etests.automation.page_objects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;
import org.openqa.selenium.support.FindAll;

import org.openqa.selenium.support.FindBys;

public class TodoPage implements IToDo {

	public ConfigFileReader configFileReader;

	public TodoPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader = new ConfigFileReader();
		

	}
	

	 

	    private static final By byTodoEdit = By.cssSelector("input.edit");
	    private static final By byTodoRemove = By.cssSelector("button.destroy");
	    private static final By byTodoComplete = By.cssSelector("input.toggle");

	    @FindBy(className = "new-todo")
	    private WebElement newTodoInput;

	    @FindBy(css = ".todo-count > strong")
	    private WebElement todoCount;

	    @FindBy(css = ".todo-list li")
	    private List<WebElement> todos;

	    @FindBy(className = "toggle-all")
	    private WebElement toggleAll;

	    @FindBy(css = "a[href='#/active']")
	    private WebElement showActive;

	    @FindBy(css = "a[href='#/completed']")
	    private WebElement showCompleted;

	    @FindBy(className = "clear-completed")
	    private WebElement clearCompleted;

	    @FindBys({
	            @FindBy(id = "menu"),
	            @FindBy(className = "button")
	    })
	    private WebElement element;

	    @FindAll({
	            @FindBy(id = "menu"),
	            @FindBy(className = "button")
	    })
	    private List<WebElement> webElements;

	   

	    @Override
	    public void navigateTo() {
	    	Setup.getDriver().get(configFileReader.getProperties("home.todo"));
	    }

	    public void createTodo(String todoName) {
	    	
	    	newTodoInput.clear();
	        newTodoInput.sendKeys(todoName);
	        newTodoInput.sendKeys(Keys.ENTER);
	    }

	    public void createTodos(String... todoNames) {
	        for (String todoName : todoNames) {
	            createTodo(todoName);
	        }
	    }

	    public int getTodosLeft() {
	        return Integer.parseInt(todoCount.getText());
	    }

	    public boolean todoExists(String todoName) {
	        return getTodos().stream().anyMatch(todoName::equals);
	    }

	    public int getTodoCount() {
	        return todos.size();
	    }

	    public List<String> getTodos() {
	        return todos
	                .stream()
	                .map(WebElement::getText)
	                .collect(Collectors.toList());
	    }

	    public void renameTodo(String todoName, String newTodoName) {
	        WebElement todoToEdit = getTodoElementByName(todoName);
	        doubleClick(todoToEdit);

	        WebElement todoEditInput = find(byTodoEdit, todoToEdit);
	        executeScript("arguments[0].value = ''", todoEditInput);

	        todoEditInput.sendKeys(newTodoName + Keys.ENTER);
	    }

	    public void removeTodo(String todoName) {
	        WebElement todoToRemove = getTodoElementByName(todoName);
	        moveToElement(todoToRemove);
	        todoToRemove.click();
	        //click(byTodoRemove, todoToRemove);
	    }

	    public void completeTodo(String todoName) {
	        WebElement todoToComplete = getTodoElementByName(todoName);
	        click(byTodoComplete, todoToComplete);
	    }

	    public void completeAllTodos() {
	        toggleAll.click();
	    }

	    public void showActive() {
	        showActive.click();
	    }

	    public void showCompleted() {
	        showCompleted.click();
	    }

	    public void clearCompleted() {
	        clearCompleted.click();
	    }

	    private WebElement getTodoElementByName(String todoName) {
	        return todos
	                .stream()
	                .filter(el -> todoName.equals(el.getText()))
	                .findFirst()
	                .orElseThrow(() -> new RuntimeException("Todo with name " + todoName + " not found!"));
	    }

	    private WebElement find(By by, SearchContext searchContext) {
	        return searchContext.findElement(by);
	    }

	    private void click(By by, SearchContext searchContext) {
	        WebElement element = searchContext.findElement(by);
	        element.click();
	    }

	    private void moveToElement(WebElement element) {
	        new Actions(Setup.getDriver()).moveToElement(element).perform();
	    }

	    private void doubleClick(WebElement element) {
	        new Actions(Setup.getDriver()).doubleClick(element).perform();
	    }

	    private void executeScript(String script, Object... arguments) {
	        ((JavascriptExecutor) Setup.getDriver()).executeScript(script, arguments);
	    }

	

}
