package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class PricelistPageStepDefinitions extends UiCommon{

    private String pricelistName="";

    @When("user clicks on the Pricelist link")
    public void user_clicks_on_the_Pricelist_link() {
        pages.pointOfSale().priceListLink.click();
        BrowserUtils.wait(5);
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

    @When("user types the name of the pricelist into the search box and hits ENTER")
    public void user_types_the_name_of_the_pricelist_into_the_search_box_and_hits_ENTER() {
        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        pricelistName = pricelistNameElement.getText();
        pages.pricelist().searchInput.sendKeys(pricelistName + Keys.ENTER);
    }

    @Then("user should be able to see the pricelist name on the page")
    public void user_should_be_able_to_see_the_pricelist_name_on_the_page() {
        BrowserUtils.wait(5);
        String availablePricelist = pages.pricelist().pricelistsNames.get(0).getText();
        System.out.println("available Pricelist = " + availablePricelist);
        Assert.assertEquals( pricelistName, availablePricelist);
    }

    @When("user clicks on any pricelist name")
    public void user_clicks_on_any_pricelist_name() {
        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        pricelistName = pricelistNameElement.getText();

        BrowserUtils.waitForClickablility(pricelistNameElement, timeOutInSec);
        pricelistNameElement.click();
    }

    @Then("user should be able to see selectable menu is disabled for any pricelist name")
    public void user_should_be_able_to_see_selectable_menu_is_disabled_for_any_pricelist_name() {
        BrowserUtils.waitForVisibility(pages.pricelist().selectableMenu, timeOutInSec);
        boolean isEnabled = pages.pricelist().selectableMenu.isEnabled();

        Assert.assertFalse(isEnabled);
    }

    @Then("user should be able to see name of the pricelist at the header")
    public void user_should_be_able_to_see_name_of_the_pricelist_at_the_header() {
        String pricelistNameOnHeader = pages.pricelist().pricelistNameHeader.getText();
        Assert.assertEquals(pricelistNameOnHeader, pricelistName);
    }

    @When("user clicks on Website localhost link")
    public void user_clicks_on_Website_localhost_link() {
        WebElement pricelistNameElement = pages.pricelist().selectAPricelistName();
        String pricelistName = pricelistNameElement.getText();
        System.out.println(pricelistName);

        pricelistNameElement.click();

        BrowserUtils.waitForVisibility(pages.pricelist().localhostLink, timeOutInSec);
        pages.pricelist().localhostLink.click();
    }

    @Then("user should be able to see that Language is English")
    public void user_should_be_able_to_see_that_Language_is_English() {
        BrowserUtils.waitForVisibility(pages.localhost().language, timeOutInSec);
        String message = pages.localhost().language.getText();
        System.out.println(message);
        Assert.assertEquals(message, (ApplicationConstants.LOCALHOST_PAGE_LANGUAGE));
    }

    @Then("user should be able to see that title of the pricelist name contains pricelist name")
    public void user_should_be_able_to_see_that_title_of_the_pricelist_name_contains_pricelist_name() {
        BrowserUtils.wait(5);
        String message = Driver.getDriver().getTitle();
        System.out.println(message);
        Assert.assertTrue(message.contains(pricelistName));
    }

    @Given("user clicks on check box of the one of the price name")
    public void user_clicks_on_check_box_of_the_one_of_the_price_name() {
        pages.pricelist().selectAPricelistNameCheckBox().click();
    }

    @When("user click on action drop down menu button")
    public void user_click_on_action_drop_down_menu_button() {
        pages.pricelist().actionButton.click();
    }

    @When("user selects archive")
    public void user_selects_archive() {
        // Write code here that turns the phrase above into concrete actions
        pages.pricelist().archiveButton.click();
    }

    @Then("user should be able to see that header of the page contains {string}")
    public void user_should_be_able_to_see_that_header_of_the_page_contains(String string) {
        String errorPageHeader = pages.pricelist().accessError.getText();
        System.out.println(errorPageHeader);
        Assert.assertTrue(errorPageHeader.contains(ApplicationConstants.ERROR_SUBPAGE_HEADER));
    }

    @Then("user should be able to see that Website localhost page is displayed")
    public void user_should_be_able_to_see_that_Website_localhost_page_is_displayed() {
        BrowserUtils.wait(10);
        String message = Driver.getDriver().getTitle();
        System.out.println(message);
        Assert.assertTrue(message.contains(ApplicationConstants.LOCALHOST_PAGE_TITLE));
    }

    @Then("user should be able to see that Twitter Account is correct.")
    public void user_should_be_able_to_see_that_Twitter_Account_is_correct() {
        BrowserUtils.waitForVisibility(pages.localhost().twitter, timeOutInSec);
        String message = pages.localhost().twitter.getText();
        System.out.println(message);
        Assert.assertEquals(message, (ApplicationConstants.LOCALHOST_PAGE_TWITTER));
    }

    @When("user types {string} into search box and hits ENTER")
    public void user_types_into_search_box_and_hits_ENTER(String pricelist_name) {
        pages.pricelist().searchInput.sendKeys(pricelist_name + Keys.ENTER);
        System.out.println(pricelist_name);
    }

    @Then("user should not be able to see the name of the product on the page")
    public void user_should_not_be_able_to_see_the_name_of_the_product_on_the_page() {
        BrowserUtils.wait(5);
        String paragraph=pages.pricelist().text.getText();
        String actualParagraph="A price list contains rules to be evaluated in order to " +
                "compute the sale price of the products.";
        System.out.println(paragraph);
        Assert.assertEquals(actualParagraph,paragraph);
    }

}
