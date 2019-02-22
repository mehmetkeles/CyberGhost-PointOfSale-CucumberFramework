package com.briteerp.step_definitions;

import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;
import com.briteerp.utilities.Pages;
import cucumber.api.java.en.Given;

public class HomePageStepDefinitions {

    @Given("user is already on the login page")
    public void user_is_already_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

//        HomePage homePage = new HomePage();
//        homePage.briteErpDemoLink.click();
        Pages.home().briteErpDemoLink.click();
    }

}
