package com.runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.utils.GenericWrappers;
import com.utils.ServerManager;


public class Hooks extends GenericWrappers {

    /***
     * Embed a screenshot in test report if test is marked as failed
     * @param scenario
     * @throws Exception
     */
    @After
    public void afterClass(Scenario scenario) throws Exception {

//        GenericWrappers genericWrappers = new GenericWrappers();
        if(scenario.isFailed()) {
            System.out.println("Scenario Failed...Taking screenshot....");
//            takeSnap(scenario);
            TakesScreenshot tk= (TakesScreenshot) getDriver();
//            byte[] b1 = tk.getScreenshotAs(OutputType.BYTES);
//            scenario.embed(b1,"Failurescreenshots");
            quitBrowser();
        }
        quitBrowser();
    }

    @Before
    public void before() throws MalformedURLException, InterruptedException{
    	new ServerManager().startServer();
        new GenericWrappers().invokeApp();
//    	new GenericWrappers().openApkFile();
    }
}
