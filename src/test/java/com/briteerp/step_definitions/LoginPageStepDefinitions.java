package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginPageStepDefinitions extends UiCommon{

    @Given("user is already on the login page")
    public void user_is_already_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
//        pages.home().briteErpDemoLink.click();
        pages.home().signInBtn.click();
        System.out.println("User is on the login page");
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        pages.login().login(username, password);
        System.out.println("User enters the " + username + " and "+ password);
    }

    @When("user logs in as user")
    public void user_logs_in_as_user() {
        String username = ConfigurationReader.getProperty("user-username");
        String password = ConfigurationReader.getProperty("user-password");
        pages.login().login(username, password);
        System.out.println("User logs in as user");
    }

    @When("user logs in as manager")
    public void user_logs_in_as_manager() {
        pages.login().login(ConfigurationReader.getProperty("manager-username"),
                            ConfigurationReader.getProperty("manager-password"));
        System.out.println("User logs in as manager");
    }


    @Then("homepage should be displayed")
    public void homepage_should_be_displayed() {
        BrowserUtils.waitUntilTextToBePresentInElement(pages.main().tabTitle, "#Inbox", 30);
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(ApplicationConstants.MAINPAGE_TITLE, title);
        System.out.println("Homepage is displayed");
    }

    @When("user clicks on PointofSale link")
    public void user_clicks_on_PointofSale_link() {
        BrowserUtils.waitForClickablility(pages.main().pointOfSaleLink, timeOutInSec);
        pages.main().pointOfSaleLink.click();
        System.out.println("User clicks on 'Point Of Sale' link");
    }

    @Then("PointOfSale page should be displayed")
    public void pointofsale_page_should_be_displayed() {
        BrowserUtils.waitUntilTextToBePresentInElement(pages.pointOfSale().tabTitle,
                                                       ApplicationConstants.POINTOFSALE_PAGE_HEADER, timeOutInSec);
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals(title, ApplicationConstants.POINTOFSALE_PAGE_TITLE);
        System.out.println("PointOfSale is displayed");

    }

    @Given("user is on the Point of Sale page")
    public void user_is_on_the_Point_of_Sale_page() {
        getMeToPointOfSalesAs("user");
        System.out.println("user is on the Point of Sale page");
    }

    @Given("manager is on the Point of Sale page")
    public void manager_is_on_the_Point_of_Sale_page() {
        getMeToPointOfSalesAs("manager");
        System.out.println("manager is on the Point of Sale page");
    }


    private void getMeToPointOfSalesAs(String accessLevel) {

        user_is_already_on_the_login_page();

        if (accessLevel.equals("user"))
            user_logs_in_as_user();
        else if (accessLevel.equals("manager"))
            user_logs_in_as_manager();
        else {
            System.out.println("Invalid credentials: Please enter either 'user' or 'manager' ");
        }

        user_clicks_on_PointofSale_link();

        pointofsale_page_should_be_displayed();
    }


}
