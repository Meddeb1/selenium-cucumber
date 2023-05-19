package com.e2etests.automation;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


/**

* The Test Runner File uses the @RunWith() Annotation from JUnit for executing tests.

*/
@RunWith(Cucumber.class)



/**

* The @CucumberOptions Annotation is used to define the location of feature files, step definitions, reporting

* integration.

*/
@CucumberOptions(
		
		//configuration 
		features ={"srs/spec/features"},   //features
		plugin ={"pretty","html:target/cucumber-report.html"},    //rapport
		tags= ("@about"),  //tags a tester
		//glue = {"src/test/java/com/e2etests/automation/step_definitions"}, // on l utilise quand le runweb n est aps dans un package : meme niveau
		monochrome = true,
		snippets = CAMELCASE
	
		)



/**
* This class is used to run the test, which is a JUnit Test Runner Class containing the Step Definition location and
* the other primary metadata required to run the test.
*/
public class RunWebSuiteTest {

}
 
 