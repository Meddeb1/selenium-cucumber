package com.e2etests.automation.page_objects;

import java.util.List;

public interface IToDo {
	
	void navigateTo();

    void createTodo(String todoName);

    void createTodos(String... todoNames);

    int getTodosLeft();

    boolean todoExists(String todoName);

    int getTodoCount();

    List<String> getTodos();

    void renameTodo(String todoName, String newTodoName);

    void removeTodo(String todoName);

    void completeTodo(String todoName);

    void completeAllTodos();

    void showActive();

    void showCompleted();

    void clearCompleted();

}
