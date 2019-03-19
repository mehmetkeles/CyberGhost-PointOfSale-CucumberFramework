package com.briteerp.step_definitions;

import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.DatabaseUtility;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DB_PricelistPageStepDefinitions extends UiCommon {

    @Then("manager clicks on the create button")
    public void manager_clicks_on_the_create_button() {
        pages.pricelist().createButton.click();
        BrowserUtils.wait(5);
    }

    @When("manager enters a {string} and clicks on save button")
    public void manager_enters_a_and_clicks_on_save_button(String pricelistName) {
        pages.pricelist().pricelistNameInput.sendKeys(pricelistName);
        pages.pricelist().saveButton.click();
        BrowserUtils.wait(5);
    }

    @Then("manager verifies that new {string} is in database")
    public void manager_verifies_that_new_is_in_database(String pricelistName) {
        String query = "SELECT * FROM product_pricelist;";
        List<Object> pricelistNames = DatabaseUtility.getColumnData(query, "name");
        System.out.println(pricelistNames);

        Assert.assertTrue(pages.pricelist().checkPricelistname(pricelistNames, pricelistName));

    }

    @Then("manager deletes that new {string} on pricelist page")
    public void manager_deletes_that_new_on_pricelist_page(String pricelistName) {
        pages.pricelist().managerActionButton.click();
        pages.pricelist().deleteButton.click();
        pages.pricelist().okButton.click();
        BrowserUtils.wait(5);

    }

    @Then("manager verifies that new {string} is not in database")
    public void manager_verifies_that_new_is_not_in_database(String pricelistName) {
        String query = "SELECT * FROM product_pricelist;";
        List<Object> pricelistNames = DatabaseUtility.getColumnData(query, "name");
        System.out.println(pricelistNames);

        Assert.assertFalse(pages.pricelist().checkPricelistname(pricelistNames, pricelistName));
    }
}
