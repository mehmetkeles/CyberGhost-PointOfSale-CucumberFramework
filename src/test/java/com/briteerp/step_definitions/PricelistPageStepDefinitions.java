package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PricelistPageStepDefinitions {
    Pages pages = new Pages();
    protected final int timeOutInSec = Integer.parseInt(ConfigurationReader.getProperty("timeOutInSec"));


    public void getMeToPointOfSalesAs(String accessLevel) {
        pages.home().open();

        pages.home().briteErpDemoLink.click();

        if (accessLevel.equals("user"))
            pages.login().login(ConfigurationReader.getProperty("user-username"),
                    ConfigurationReader.getProperty("user-password"));
        else if (accessLevel.equals("manager"))
            pages.login().login(ConfigurationReader.getProperty("manager-username"),
                    ConfigurationReader.getProperty("manager-password"));
        else {
            System.out.println("Invalid credentials: Please enter either 'user' or 'manager' ");
        }

        BrowserUtils.waitForClickablility(pages.main().pointOfSaleLink, timeOutInSec);
        pages.main().pointOfSaleLink.click();

    }

    @Given("user is on the Point of Sale page")
    public void user_is_on_the_Point_of_Sale_page() {
        getMeToPointOfSalesAs(ConfigurationReader.getProperty("accessLevel"));
    }

    @When("user clicks on the Pricelist link")
    public void user_clicks_on_the_Pricelist_link() {
        pages.pointOfSale().priceListLink.click();
    }

    @Then("user should see the header is displaying Pricelists")
    public void user_should_see_the_header_is_displaying_Pricelists() {
        BrowserUtils.wait(5);
        Assert.assertEquals(pages.pricelist().tabTitle.getText(), ApplicationConstants.PRICELISTS_PAGE_HEADER);
    }

    @Then("user should see the title contains Pricelists")
    public void user_should_see_the_title_contains_Pricelists() {
        BrowserUtils.wait(5);
        String message = Driver.getDriver().getTitle();
        Assert.assertTrue(message.contains(ApplicationConstants.PRICELISTS_PAGE_TITLE));
    }
}
