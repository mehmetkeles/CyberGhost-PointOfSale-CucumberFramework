package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class PricelistPageStepDefinitions extends UiCommon{

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
