package com.runner;

import io.cucumber.junit.Cucumber; 
 
import io.cucumber.junit.CucumberOptions;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = (true),
		features = {"./src/test/resources"},
		glue = {""},
		tags = {"regresstionTest"},
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json"},
//				plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = false,
		dryRun = false)

//		plugin = {"pretty"
//                , "html:target/cucumber/report.html"
//                , "summary"
//                , "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"}
//        ,features = {"src/test/resources"}
//        ,glue = {"com.HiFlow.steps"}
//        ,snippets = CAMELCASE
//        ,dryRun=false
//        ,monochrome=true
//        ,strict=true
//        ,tags = "@PrivateDriver")


public class RunnerTest {

	//    @AfterClass
	//    public static void setup() {
	//
	////        Reporter.loadXMLConfig(new File("./src/main/resources/extent-config.xml"));
	//        Reporter.setSystemInfo("user", System.getProperty("user.name"));
	//        Reporter.setSystemInfo("os", "Mac");
	//        Reporter.setTestRunnerOutput("Sample test runner output message");
	//    }
	
//	@AfterClass
//	public static void writeExtentReport() {
//		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/src/main/resources/extent-config.xmls"));
//	}
}
