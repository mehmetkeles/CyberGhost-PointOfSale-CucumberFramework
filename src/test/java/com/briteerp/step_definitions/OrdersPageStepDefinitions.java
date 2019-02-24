package com.briteerp.step_definitions;

import com.briteerp.utilities.ApplicationConstants;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class OrdersPageStepDefinitions extends UiCommon {

    private String orderName = null;
    @When("user clicks on orders link")
    public void user_clicks_on_Products_link() {

        WebElement element = pages.orders().ordersLink;
        BrowserUtils.waitForClickablility(element, timeOutInSec);
        element.click();
        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle, ApplicationConstants.ORDERLISTS_PAGE_HEADER, timeOutInSec);
        System.out.println("User clicks on the Orders link");
    }
    @Then("Orders page should be displayed")
    public void orders_page_should_be_displayed() {
        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle,
                ApplicationConstants.ORDERLISTS_PAGE_HEADER,timeOutInSec);
        Assert.assertEquals(pages.products().tabTitle.getText().trim(),
                ApplicationConstants.ORDERLISTS_PAGE_HEADER);
        System.out.println("Orders page is displayed");
    }



    @Then("user should see the title contains Orderlists")
    public void user_should_see_the_title_contains_Orderlists() {
        BrowserUtils.wait(5);
        String message = Driver.getDriver().getTitle();
        Assert.assertTrue(message.contains(ApplicationConstants.ORDERLISTS_PAGE_TITLE));
    }

    @When("user selects a product")
    public void user_selects_a_product() {
        orderName = pages.products().selectAnyOrder();
        System.out.println("User selects " + orderName);
    }

}






