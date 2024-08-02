package org.runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.report.JVMReport;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\Feature\\LoginPage.feature", glue="org.Step", 
monochrome=true, dryRun=false,
plugin= {"html:target\\htmlReport", 
		"junit:target\\xmlReport.xml",
		"json:target\\jsonReport.json"})

public class TestRunner {
	@AfterClass
	public static void report() {
		JVMReport.generateReport("json:target\\\\jsonReport.json");

	}

}
