package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProductsPageStepDefinitions extends  UiCommon {


    private String productName = null,
                   salesPrice = null,
                   noteToAdd = null,
                   numberOfProductsForSale = null;



    @When("user clicks on Products link")
    public void user_clicks_on_Products_link() {
        WebElement element = pages.pointOfSale().productsLink;
        BrowserUtils.waitForClickablility(element, timeOutInSec);
        element.click();
        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle,ApplicationConstants.PRODUCTS_PAGE_HEADER, timeOutInSec);
        System.out.println("User clicks on the Products link");
    }

    @Then("Products page should be displayed")
    public void products_page_should_be_displayed() {
        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().tabTitle,
                                                       ApplicationConstants.PRODUCTS_PAGE_HEADER,timeOutInSec);
        Assert.assertEquals(pages.products().tabTitle.getText().trim(),
                            ApplicationConstants.PRODUCTS_PAGE_HEADER);
        System.out.println("Products page is displayed");
    }

    @When("user selects a product")
    public void user_selects_a_product() {
        productName = pages.products().selectAnyProduct();
        System.out.println("User selects " + productName);
    }

    @Then("user should see the name and sales price of the product")
    public void user_should_see_the_name_and_sales_price_of_the_product() {
        salesPrice = pages.products().getPrice(productName);
        Assert.assertFalse(productName.isEmpty() && salesPrice.isEmpty() );
        System.out.println("User checks the name and sales price of " + productName);
    }

    @When("user selects a product with a thumbnail picture")
    public void user_selects_a_product_with_a_thumbnail_picture() {
        boolean hasThumbnailPic = false;
        while (!hasThumbnailPic){
            productName = pages.products().selectAnyProduct();
            hasThumbnailPic = pages.products().hasThumbnailPicture(productName);
        }

        System.out.println("User selects a product with a thumbnail picture: " + productName);
    }



    @Then("user clicks on the product")
    public void user_clicks_on_the_product() {
        pages.products().selectProduct(productName).click();
        System.out.println("User clicks on "+ productName );
    }


    @Then("user should be able to see the picture of the product")
    public void user_should_be_able_to_see_the_picture_of_the_product() {
        BrowserUtils.waitForVisibility(pages.products().detailsMediumImg, timeOutInSec);
        boolean flag = pages.products().detailsMediumImg.isDisplayed();
        Assert.assertTrue(flag);
        System.out.println("User verifies that the product has picture: " + flag);
    }

    @When("user selects a product and remembers its price")
    public void user_selects_a_product_and_remembers_its_price() {
        productName = pages.products().selectAnyProduct();
        salesPrice = pages.products().getPrice(productName);
        System.out.println("User selects a product and its price: " + productName + salesPrice );
    }

    @Then("user click on {string} and remembers its price")
    public void user_click_on_and_remembers_its_price(String productName) {
        this.productName = productName;
        salesPrice = pages.products().getPrice(productName);
        System.out.println("Product and its price: " + productName + salesPrice );
    }


    @Then("user should be able to see the same price")
    public void user_should_be_able_to_see_the_same_price() {
        String price = pages.products().detailsGenInfSalesPrice.getText().trim();
        Assert.assertEquals(price, salesPrice);
        System.out.println("User confirms that product has the same price: " + salesPrice );
    }

    @Then("user types the name of the product into search box and hits ENTER")
    public void user_types_the_name_of_the_product_into_search_box_and_hits_ENTER() {
        pages.products().searchInput.sendKeys(productName+ Keys.ENTER);
        System.out.println("User searched teh product " + productName);
    }

    @Then("user should be able to see the product on the page")
    public void user_should_be_able_to_see_the_product_on_the_page() {
        BrowserUtils.hover(pages.products().selectProduct(productName));
        Assert.assertTrue(pages.products().products.size() > 0);
        System.out.println("User sees the product on the page" );
    }

    @Then("user clicks on Log note link")
    public void user_clicks_on_Log_note_link() {
        BrowserUtils.waitForClickablility(pages.products().detailsLogNoteTab, timeOutInSec);
        pages.products().detailsLogNoteTab.click();
        System.out.println("User clicks on Log note");
    }

    @Then("user writes some notes and clicks on Log button")
    public void user_writes_some_notes_and_clicks_on_Log_button() {
        BrowserUtils.waitForVisibility(pages.products().detailsLogNoteLogBtn, timeOutInSec);
        noteToAdd = "CyberGhost team member updated at " + new Date().toString();
        pages.products().detailsLogNoteMessage.sendKeys(noteToAdd);
        pages.products().detailsLogNoteLogBtn.click();
        System.out.println("User puts the notes: " + noteToAdd);
    }

    @Then("user should be able to see the note on the page")
    public void user_should_be_able_to_see_the_note_on_the_page() {
        BrowserUtils.wait(3);
        String submittedNotes = BrowserUtils.getElementsText(pages.products().detailsSubmittedNoteList).toString();
        Assert.assertTrue(submittedNotes.contains(noteToAdd));
        System.out.println("User checks the " + noteToAdd + " in the " + submittedNotes );
    }

    @Then("user should be able to see that cost is less than sales price")
    public void user_should_be_able_to_see_that_cost_is_less_than_sales_price() {
        String priceStr = pages.products()
                               .detailsGenInfSalesPrice.getText().trim().substring(1)
                               .trim().replace(",", "");
        double price = Double.parseDouble(priceStr);

        String costStr = pages.products()
                              .detailsGenInfCost.getText().trim().substring(1)
                              .trim().replace(",", "");
        double cost = Double.parseDouble(costStr);

        Assert.assertTrue(price > cost);

        System.out.println("User checks the cost of the product is more than sales price");
    }

    @Then("user should be able to see the name of the product on the page")
    public void user_should_be_able_to_see_the_name_of_the_product_on_the_page() {
        BrowserUtils.waitForVisibility(pages.products().detailsGenInfSalesPrice, timeOutInSec);
        String productNameAtTheTop = pages.products().detailsProductNameAtTheTop.getText().trim();
        Assert.assertTrue(productNameAtTheTop.contains(productName));
        System.out.println("User confirms that the product listing has the " + productName);
    }


    @Then("user clicks the edit button")
    public void user_clicks_the_edit_button() {
        pages.products().detailsEditBtn.click();
        System.out.println("User clicks on the product's edit button");
    }

    @Then("user can change the sales price and clicks the save button")
    public void user_can_change_the_sales_price_and_clicks_the_save_button() {
        WebElement element = pages.products().detailsEditSalesPriceInput;

        String priceStr = element.getAttribute("value")
                                 .replace(",", "")
                                 .replace(",", "");

        element.clear();

        double price = Double.parseDouble(priceStr);
        String newPriceStr = "" + (price + 1);

        element.sendKeys(newPriceStr);

        BrowserUtils.waitUntilTextToBePresentInElementValue(element, newPriceStr, timeOutInSec);
        salesPrice = newPriceStr;
        pages.products().detailsSaveBtn.click();

        System.out.println("User changes the sales button and saves it ");
    }

    @Then("user should be able to see the update sales price")
    public void user_should_be_able_to_see_the_update_sales_price() {
        BrowserUtils.waitForVisibility(pages.products().detailsGenInfSalesPrice, timeOutInSec);
        String actualValue = pages.products().detailsGenInfSalesPrice.getText().trim().substring(1).trim();
        Assert.assertEquals(Double.parseDouble(actualValue), Double.parseDouble(salesPrice), 0.001);
        System.out.println("User chekcs the updated sales price");
    }


    @Then("user click on {string}")
    public void user_click_on(String product_name) {
        this.productName = product_name;
        pages.products().selectProduct(productName).click();
        BrowserUtils.waitUntilTextToBePresentInElement(pages.products().detailsProductNameLabel, productName, timeOutInSec);
        System.out.println("User clicks on " + productName );
    }

    @Then("page should display details for the product")
    public void page_should_display_details_for_the_product() {
        String fileName ="./src/test/resources/products.xlsx";
        String sheetName = "details";
        ExcelUtil productData = new ExcelUtil(fileName, sheetName);

        List<Map<String, String>> productMapList = productData.getDataList();


        for (Map<String, String> product : productMapList){
            if ( productName.equalsIgnoreCase( product.get("product_name").trim() ) ){

                String actualSalesPrice = pages.products()
                                               .detailsGenInfSalesPrice.getText()
                                               .trim().substring(1).trim();
                String expectedSalesPrice = product.get("sales_price").trim();
                Assert.assertEquals(Double.parseDouble(expectedSalesPrice), Double.parseDouble(actualSalesPrice), 0.001);


                String actualCost = pages.products()
                                         .detailsGenInfCost.getText()
                                         .trim().substring(1).trim();
                String expectedCost = product.get("cost").trim();
                Assert.assertEquals(Double.parseDouble(expectedCost), Double.parseDouble(actualCost), 0.01);

                String actualProductType = pages.products()
                                                .detailsProductTypeLabel.getText()
                                                .trim().toLowerCase();
                String expectedProductType = product.get("product_type").trim().toLowerCase();
                Assert.assertEquals(expectedProductType, actualProductType);

                return ;
            }

        }

        Assert.fail(productName + " was not found in the test data");
        System.out.println("User checks the  details for the products from the excel file");
    }


    @Then("user should be able to see the following products in the listing:")
    public void user_should_be_able_to_see_the_following_products_in_the_listing(List<String> products) {
        List<String> productsList  = BrowserUtils.getElementsText(pages.products().products);

        for (String each : products){
            if ( ! productsList.toString().contains(each) )
                Assert.fail( each + " is not available in the products");
        }

        System.out.println("User checks the products in the listing");
    }

    @Then("user should see the product information")
    public void user_should_see_the_product_information(Map<String, String> productInfo) {
        String expectedType = productInfo.get("type").toLowerCase();
        String expectedPrice = productInfo.get("price");
        String expectedCost = productInfo.get("cost");

        String actualType = pages.products().detailsProductTypeLabel.getText().toLowerCase();
        String actualPrice = pages.products().detailsGenInfSalesPrice.getText().trim().substring(1).trim();
        String actualCost = pages.products().detailsGenInfCost.getText().trim().substring(1).trim();

        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(Double.parseDouble(expectedPrice), Double.parseDouble(actualPrice), 0.001);
        Assert.assertEquals(Double.parseDouble(expectedCost), Double.parseDouble(actualCost), 0.001);

        System.out.println("User Checks the product info");
    }


    @Then("user verifies the price")
    public void user_verifies_the_price() {
        String query = "SELECT pt.list_price FROM product_template pt " +
                       "JOIN product_price_history pp " +
                       "ON pp.id = pt.id and pt.name='" + productName + "'";

        String expectedSalesPrice = DatabaseUtility.getCellValue(query).toString();
        System.out.println("expectedSalesPrice = " + expectedSalesPrice);

        Assert.assertEquals(expectedSalesPrice, salesPrice.substring(1).replace(",", "").trim());

    }


    @When("user remembers the number of products available")
    public void user_remembers_the_number_of_products_available() {
        numberOfProductsForSale = pages.products().numberOfProductsForSale.getText().trim();
        System.out.println("numberOfProductsForSale = " + numberOfProductsForSale);
    }

    @Then("users verifies the number from the database")
    public void users_verifies_the_number_from_the_database() {
        String query =  "SELECT COUNT(*) FROM product_template pt " +
                        "JOIN product_price_history pp ON pp.id = pt.id and pt.sale_ok='true' ";

        String expectedNumberOfProductsForSale = DatabaseUtility.getCellValue(query).toString().trim();

        System.out.println("expectedNumberOfProductsForSale = " + expectedNumberOfProductsForSale);

        Assert.assertEquals(expectedNumberOfProductsForSale, numberOfProductsForSale);
    }


}
