package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginPageStepDefinitions {


    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        System.out.println("user enters username and password");
        Pages.login().login(username, password);
    }

    @When("user logs in as user")
    public void user_logs_in_as_user() {
        System.out.println("User logs in as user");
        String username = ConfigurationReader.getProperty("user-username");
        String password = ConfigurationReader.getProperty("user-password");
        Pages.login().login(username, password);
    }

    @When("user logs in as manager")
    public void user_logs_in_as_manager() {
        Pages.login().login(ConfigurationReader.getProperty("manager-username"),
                            ConfigurationReader.getProperty("manager-password"));
    }


    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {
        System.out.println("homepage is displayed");
        BrowserUtils.waitUntilTextToBePresentInElement(Pages.main().tabTitle, "#Inbox", 30);
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(ApplicationConstants.MAINPAGE_TITLE, title);
    }


}
