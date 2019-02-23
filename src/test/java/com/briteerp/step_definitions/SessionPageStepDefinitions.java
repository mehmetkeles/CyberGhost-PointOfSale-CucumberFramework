package com.briteerp.step_definitions;

import com.briteerp.pages.*;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SessionPageStepDefinitions {

    @Given("manager on the login page")
    public void manager_on_the_login_page() {
        System.out.println("Opening the login page as a manager");
        Driver.getDriver().get(ConfigurationReader.getProperty("urlDemo"));


    }

    @When("manager selects demo")
    public void manager_selects_demo() {
        System.out.println("getting to the demo page");

        HomePage homePage = new HomePage();
        homePage.briteErpDemoLink.click();


    }


    @When("use valid credentials")
    public void use_valid_credentials() {

        LoginPage loginpage = new LoginPage();
        loginpage.email.sendKeys(ConfigurationReader.getProperty("manager-username"));
        loginpage.password.sendKeys(ConfigurationReader.getProperty("manager-password"));
        loginpage.loginBtn.click();

    }

    @Then("click on Point of Sale module on the top")
    public void click_on_Point_of_Sale_module_on_the_top() {
        SessionsPage sessionsPage = new SessionsPage();
        sessionsPage.pointOfSalelnk.click();

    }

    @Then("manager user name should be displayed on the top right")
    public void manager_user_name_should_be_displayed_on_the_top_right() {

        PointOfSalePage pointOfSalePage = new PointOfSalePage();


        String actualUserName = pointOfSalePage.topUsername.getText().trim();
        String expectedUserName = "POSManager9";

        Assert.assertEquals(actualUserName, expectedUserName);


    }

    @Then("Verify that Point of Sale page has a header as Point of Sale on the top left")
    public void verify_that_Point_of_Sale_page_has_a_header_as_Point_of_Sale_on_the_top_left() {

        PointOfSalePage pointOfSalePage = new PointOfSalePage();

        BrowserUtils.waitForVisibility(pointOfSalePage.tabTitle, 5);
        String headerActual = pointOfSalePage.tabTitle.getText().trim();
        String headerExpected = "Point of Sale";

        Assert.assertEquals(headerActual, headerExpected);


    }






}
