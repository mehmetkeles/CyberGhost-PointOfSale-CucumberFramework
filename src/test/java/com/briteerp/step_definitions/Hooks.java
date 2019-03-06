package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks extends UiCommon{

    @Before(order = 2)
    public void setUp() {
        System.out.println("I am setting up the test from the Hooks class!!!");
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("I am reporting the results");
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

        System.out.println("Closing driver");
        Driver.closeDriver();
    }

    @Before(value = "@db")
    public void setUpDbConnection() {
        DatabaseUtility.createConnection(ConfigurationReader.getProperty("db.url"),
                                         ConfigurationReader.getProperty("db.username"),
                                         ConfigurationReader.getProperty("db.password") );

        System.out.println("Database connection was set up");
    }

    @After(value = "@db")
    public void closeDbConnection(){
        DatabaseUtility.closeConnection();
        System.out.println("Database Connection closed");

    }

}



