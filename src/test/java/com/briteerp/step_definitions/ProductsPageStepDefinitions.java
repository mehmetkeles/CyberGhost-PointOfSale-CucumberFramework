package com.briteerp.step_definitions;

import com.briteerp.utilities.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class ProductsPageStepDefinitions {

    static int timeOutInSec = Integer.parseInt(ConfigurationReader.getProperty("timeOutInSec"));

    private String productName = null, salesPrice = null , noteToAdd = null;


    @When("user clicks on PointofSale link")
    public void user_clicks_on_PointofSale_link() {
        BrowserUtils.waitForClickablility(Pages.main().pointOfSaleLink, timeOutInSec);
        Pages.main().pointOfSaleLink.click();
    }

    @Then("PointOfSale page should be displayed")
    public void pointofsale_page_should_be_displayed() {
        BrowserUtils.waitUntilTextToBePresentInElement(Pages.pointOfSale().tabTitle,
                ApplicationConstants.POINTOFSALE_PAGE_HEADER, timeOutInSec);
        String title = Driver.getDriver().getTitle();
//        System.out.println("title = " + title);
        Assert.assertEquals(title, ApplicationConstants.POINTOFSALE_PAGE_TITLE);

    }



    @When("user clicks on Products link")
    public void user_clicks_on_Products_link() {
        WebElement element = Pages.pointOfSale().productsLink;
        BrowserUtils.waitForClickablility(element, timeOutInSec);
        element.click();
        BrowserUtils.waitUntilTextToBePresentInElement(Pages.products().tabTitle,ApplicationConstants.PRODUCTS_PAGE_HEADER, timeOutInSec);
//        Pages.pointOfSale().productsLink.click();
    }

    @Then("Products page should be displayed")
    public void products_page_should_be_displayed() {
        BrowserUtils.waitUntilTextToBePresentInElement(Pages.products().tabTitle,
                ApplicationConstants.PRODUCTS_PAGE_HEADER,timeOutInSec);

//        System.out.println("control " + Pages.products().tabTitle.getText());
        Assert.assertEquals(Pages.products().tabTitle.getText().trim(),
                ApplicationConstants.PRODUCTS_PAGE_HEADER);

    }

    @When("user selects a product")
    public void user_selects_a_product() {
        productName = Pages.products().selectAnyProduct();
        System.out.println("productName = " + productName);
    }

    @Then("user should see the name and sales price of the product")
    public void user_should_see_the_name_and_sales_price_of_the_product() {
        salesPrice = Pages.products().getPrice(productName);
        System.out.println("productName = " + productName);
        Assert.assertFalse(productName.isEmpty() && salesPrice.isEmpty() );
    }

    @When("user selects a product with a thumbnail picture")
    public void user_selects_a_product_with_a_thumbnail_picture() {
        boolean hasThumbnailPic = false;
        while (!hasThumbnailPic){
            productName = Pages.products().selectAnyProduct();
            hasThumbnailPic = Pages.products().hasThumbnailPicture(productName);
        }

        System.out.println("Product with a thumbnail picture: " + productName);
    }


    @Then("user clicks on the product")
    public void user_clicks_on_the_product() {
        Pages.products().selectProduct(productName).click();
        System.out.println(productName + " is clicked");
    }

    @Then("user should be able to see the picture of the product")
    public void user_should_be_able_to_see_the_picture_of_the_product() {
        BrowserUtils.waitForVisibility(Pages.products().detailsMediumImg, timeOutInSec);
        boolean flag = Pages.products().detailsMediumImg.isDisplayed();
        System.out.println("Verified that the prodcut has picture: " + flag);
        Assert.assertTrue(flag);
    }

    @When("user selects a product and remembers its price")
    public void user_selects_a_product_and_remembers_its_price() {
        productName = Pages.products().selectAnyProduct();
        salesPrice = Pages.products().getPrice(productName);
        System.out.println("Selected product deatils: " +productName + salesPrice );
    }

    @Then("user should be able to see the same price")
    public void user_should_be_able_to_see_the_same_price() {
        String price = Pages.products().detailsGenInfSalesPrice.getText().trim();
        System.out.println("price = " + price);
        Assert.assertEquals(price, salesPrice);
        System.out.println(salesPrice + "  is verified");
    }

    @Then("user types the name of the product into search box and hits ENTER")
    public void user_types_the_name_of_the_product_into_search_box_and_hits_ENTER() {
        Pages.products().searchInput.sendKeys(productName+ Keys.ENTER);
    }

    @Then("user should be able to see the product on the page")
    public void user_should_be_able_to_see_the_product_on_the_page() {
        BrowserUtils.hover(Pages.products().selectProduct(productName));
        Assert.assertTrue(Pages.products().products.size() > 0);
    }

    @Then("user clicks on Log note link")
    public void user_clicks_on_Log_note_link() {
        BrowserUtils.waitForClickablility(Pages.products().detailsLogNoteTab, timeOutInSec);
        Pages.products().detailsLogNoteTab.click();
        System.out.println("Clicked the Log note");
    }

    @Then("user writes some notes and clicks on Log button")
    public void user_writes_some_notes_and_clicks_on_Log_button() {
        BrowserUtils.waitForVisibility(Pages.products().detailsLogNoteLogBtn, timeOutInSec);
        noteToAdd = "CyberGhost team member updated at " + new Date().toString();
        Pages.products().detailsLogNoteMessage.sendKeys(noteToAdd);
        Pages.products().detailsLogNoteLogBtn.click();
        System.out.println("Note is written: " + noteToAdd);
    }

    @Then("user should be able to see the note on the page")
    public void user_should_be_able_to_see_the_note_on_the_page() {
//        BrowserUtils.waitForClickablility(Pages.products().detailsLogNoteTab, timeOutInSec);
        BrowserUtils.wait(3);
        String submittedNotes = BrowserUtils.getElementsText(Pages.products().detailsSubmittedNoteList).toString();
        System.out.println("submittedNotes = " + submittedNotes);
        System.out.println("noteToAdd : " + noteToAdd);
        Assert.assertTrue(submittedNotes.contains(noteToAdd));
    }

    @Then("user should be able to see that cost is less than sales price")
    public void user_should_be_able_to_see_that_cost_is_less_than_sales_price() {
        String priceStr = Pages.products().detailsGenInfSalesPrice.getText().trim().substring(1)
                .trim().replace(",", "");
        double price = Double.parseDouble(priceStr);

        String costStr = Pages.products().detailsGenInfCost.getText().trim().substring(1)
                .trim().replace(",", "");
        double cost = Double.parseDouble(costStr);

        Assert.assertTrue(price > cost);
    }

    @Then("user should be able to see the name of the product on the page")
    public void user_should_be_able_to_see_the_name_of_the_product_on_the_page() {
        BrowserUtils.waitForVisibility(Pages.products().detailsGenInfSalesPrice, timeOutInSec);
        String productNameAtTheTop = Pages.products().detailsProductNameAtTheTop.getText().trim();
        Assert.assertTrue(productNameAtTheTop.contains(productName));
    }


    @Then("user clicks the edit button")
    public void user_clicks_the_edit_button() {
        Pages.products().detailsEditBtn.click();
    }

    @Then("user can change the sales price and clicks the save button")
    public void user_can_change_the_sales_price_and_clicks_the_save_button() {
        WebElement element = Pages.products().detailsEditSalesPriceInput;
        String priceStr = element.getAttribute("value").replace(",", "").replace(",", "");
        element.clear();

        double price = Double.parseDouble(priceStr);
        String newPriceStr = "" + (price + 1);

        element.sendKeys(newPriceStr);
        BrowserUtils.waitUntilTextToBePresentInElementValue(element, newPriceStr, timeOutInSec);

        salesPrice = newPriceStr;

        Pages.products().detailsSaveBtn.click();

    }

    @Then("user should be able to see the update sales price")
    public void user_should_be_able_to_see_the_update_sales_price() {
        BrowserUtils.waitForVisibility(Pages.products().detailsGenInfSalesPrice, timeOutInSec);
        String actualValue = Pages.products().detailsGenInfSalesPrice.getText().trim().substring(1).trim();
        Assert.assertEquals(Double.parseDouble(actualValue), Double.parseDouble(salesPrice), 0.001);

    }


    @Then("user click on {string}")
    public void user_click_on(String product_name) {
        this.productName = product_name;
        Pages.products().selectProduct(productName).click();
        BrowserUtils.waitUntilTextToBePresentInElement(Pages.products().detailsProductNameLabel, productName, timeOutInSec);
        System.out.println(productName + " is clicked");
    }

    @Then("page should display details for the product")
    public void page_should_display_details_for_the_product() {
        System.out.println(productName + " details will be displayed ");
        String fileName ="./src/test/resources/products.xlsx";
//                "D:\\CyberTek\\Courses\\Selenium Test Automation\\CyberGhost-PointOfSale-BDD\\src\\test\\resources\\products.xlsx";
        String sheetName = "details";
        ExcelUtil productData = new ExcelUtil(fileName, sheetName);

        List<Map<String, String>> productMapList = productData.getDataList();


        for (Map<String, String> product : productMapList){
//            System.out.println("product = " + product);

            if ( productName.equalsIgnoreCase( product.get("product_name").trim() ) ){

                String actualSalesPrice = Pages.products().detailsGenInfSalesPrice.getText()
                        .trim().substring(1).trim();

//                System.out.println("actualSalesPrice = " + actualSalesPrice);
                String expectedSalesPrice = product.get("sales_price").trim();
//                System.out.println("expectedSalesPrice = " + expectedSalesPrice);
                Assert.assertEquals(Double.parseDouble(expectedSalesPrice), Double.parseDouble(actualSalesPrice), 0.001);


                String actualCost = Pages.products().detailsGenInfCost.getText().trim().substring(1).trim();
//                System.out.println("actualCost = " + actualCost);
                String expectedCost = product.get("cost").trim();
//                System.out.println("expectedCost = " + expectedCost);
                Assert.assertEquals(Double.parseDouble(expectedCost), Double.parseDouble(actualCost), 0.01);

                String actualProductType = Pages.products().detailsProductTypeLabel.getText().trim().toLowerCase();
//                System.out.println("actualProductType = " + actualProductType);
                String expectedProductType = product.get("product_type").trim().toLowerCase();
//                System.out.println("expectedProductType = " + expectedProductType);

                Assert.assertEquals(expectedProductType, actualProductType);


                return ;
            }

        }

        Assert.fail(productName + " was not found in the test data");
        System.out.println("page should display details for the product Completed");
    }


    @Then("user should be able to see the following products in the listing:")
    public void user_should_be_able_to_see_the_following_products_in_the_listing(List<String> products) {
        System.out.println("products = " + products);
        List<String> productsList  = BrowserUtils.getElementsText(Pages.products().products);

        for (String each : products){
            if ( ! productsList.toString().contains(each) )
                Assert.fail( each + " is not available in the products");
        }

    }

    @Then("user should see the product information")
    public void user_should_see_the_product_information(Map<String, String> productInfo) {
        System.out.println("Checking the product info");
//        System.out.println("productInfo = " + productInfo);

        String expectedType = productInfo.get("type").toLowerCase();
//        System.out.println("expectedType = " + expectedType);


        String expectedPrice = productInfo.get("price");
//        System.out.println("expectedPrice = " + expectedPrice);

        String expectedCost = productInfo.get("cost");
//        System.out.println("expectedCost = " + expectedCost);



//        WebElement product = Pages.products().selectProduct(productName);
//        product.click();

        String actualType = Pages.products().detailsProductTypeLabel.getText().toLowerCase();
//        System.out.println("actualType = " + actualType);
        String actualPrice = Pages.products().detailsGenInfSalesPrice.getText().trim().substring(1).trim();
//        System.out.println("actualPrice = " + actualPrice);
        String actualCost = Pages.products().detailsGenInfCost.getText().trim().substring(1).trim();
//        System.out.println("actualCost = " + actualCost);

        Assert.assertEquals(expectedType, actualType);
        Assert.assertEquals(Double.parseDouble(expectedPrice), Double.parseDouble(actualPrice), 0.001);
        Assert.assertEquals(Double.parseDouble(expectedCost), Double.parseDouble(actualCost), 0.001);

    }


}
