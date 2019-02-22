package com.briteerp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.BrowserUtils;
import com.briteerp.utilities.Driver;

import java.util.List;
import java.util.Random;

public class ProductsPage extends BasePage {
    @FindBy(xpath = "//div[@class='oe_kanban_global_click o_kanban_record']")
    public List<WebElement> products;

    @FindBy(xpath = "//ol[@class='breadcrumb']//li[@class='active']")
    public WebElement detailsProductNameAtTheTop;

    @FindBy(xpath = "(//div[@class='o_form_buttons_view']/button)[1]")
    public WebElement detailsEditBtn;

    @FindBy(xpath = "(//div[@class='o_form_buttons_edit']/button)[1]")
    public WebElement detailsSaveBtn;

    @FindBy(xpath = "//div[@name='list_price']/input")
    public WebElement detailsEditSalesPriceInput;

    @FindBy(xpath = "//img[@class='img img-responsive']")
    public WebElement detailsMediumImg;

    @FindBy(xpath = "//div[@class='oe_title']//span[@name='name']")
    public WebElement detailsProductNameLabel;

    @FindBy(xpath = "//table[@class='o_group o_inner_group o_group_col_6']//span[@name='type']")
    public WebElement detailsProductTypeLabel;

    @FindBy(xpath = "//div[@class='o_notebook']//span[@name='list_price']")
    public WebElement detailsGenInfSalesPrice;

    @FindBy(xpath = "//div[@class='o_notebook']//span[@name='standard_price']")
    public WebElement detailsGenInfCost;

    @FindBy(xpath = "//button[contains(text(),'Log note')]")
    public WebElement detailsLogNoteTab;

    //    @FindBy(css = "div.o_followers_actions")
    @FindBy(xpath = "(//div[@class='o_followers_actions']/div/button)[1]")
    public WebElement detailsFollowingLabel;

    @FindBy(xpath = "//span[@class='o_follow']")
    public WebElement detailsFollowingLabel_Follow;

    @FindBy(xpath = "//span[@class='o_followers_following']")
    public WebElement detailsFollowingLabel_Following;

    @FindBy(xpath = "//span[@class='o_followers_unfollow']")
    public WebElement detailsFollowingLabel_Unfollow;


    //    @FindBy(xpath = "(//div[@class='modal-footer']//span)[1]")
//    @FindBy(xpath = "//div[@class='modal-dialog']//div[@class='modal-footer']//span[text()='Ok']")
    @FindBy(css = "div.modal-content>div.modal-footer>button.btn.btn-sm.btn-primary")
    public WebElement detailsPopUpConfirmationOkBtn;

    @FindBy(css = "div.o_composer_input>textarea")
    public WebElement detailsLogNoteMessage;

    @FindBy(css = "div.o_composer_send>button")
    public WebElement detailsLogNoteLogBtn;

    @FindBy(css = "div.o_thread_message_content")
    public List<WebElement> detailsSubmittedNoteList;

    @FindBy(xpath = "//a[text()='Notes']")
    public WebElement NotesTab;

    @FindBy(xpath = "//div[text()='Description for Customers']")
    public WebElement descriptionForCustomer;

    @FindBy(xpath = "//div[text()='Description for Internal']")
    public WebElement descriptionForInternal;

    public ProductsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Mehmet Acikgoz
     * picks up a product randomly and returns the name of the product
     *
     * @return the name of the randomly selected product.
     */

    public String selectAnyProduct() {
        BrowserUtils.wait(3);
        int rnd = new Random().nextInt(products.size());
        WebElement element = products.get(rnd).findElement(By.className("o_kanban_record_title"));
        BrowserUtils.waitForVisibility(element, timeOutInSec);
//        String productName = element.getText().trim();
        String productName = products.get(rnd).findElement(By.cssSelector("strong[class='o_kanban_record_title']>span")).getText();

        return productName;
    }


    /**
     * Mehmet Acikgoz
     * clicks on the product which is sent as parameter
     *
     * @param product
     */
    public void clickOnProduct(WebElement product) {
        BrowserUtils.waitForClickablility(product, timeOutInSec);
        product.click();
    }

    /**
     * Returns the price of the product on the products main pagee
     *
     * @param product,
     * @return the price of the product
     */
    public String getPrice(WebElement product) {
        WebElement price = product.findElement(
                By.xpath("..//following-sibling::ul//span[@name='lst_price']"));
        return price.getText();
    }

    /**
     * Mehmet Acikgoz
     * Returns the price of the product on the products main page
     *
     * @param productName,
     * @return the price of the product
     */
    public String getPrice(String productName) {
        WebElement product = selectProduct(productName);
        return getPrice(product);
    }

    /**
     * Mehmet Acikgoz
     * Returns the product element when productname is given as paremeter
     *
     * @param productname, the product name
     * @return, the Webelement
     */
    public WebElement selectProduct(String productname) {
        String beforeXpath = "//*[text() ='";
        String afterXpath = "']";
        String xpath = beforeXpath + productname + afterXpath;
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    /**
     * Mehmet Acikgoz
     * Returns true if the product has a thumbnail picture on the prodocts main page, otherwise false.
     *
     * @param element, the produst element itsef
     * @return , true/false depending on the case.
     */
    public boolean hasThumbnailPicture(WebElement element) {
        String src = element.findElement(By.xpath("ancestor::div[@class='oe_kanban_global_click o_kanban_record']//img"))
                .getAttribute("src");
//       System.out.println("src = " + src);

        if (src.equals("http://52.39.162.23/web/static/src/img/placeholder.png"))
            return false;
        else
            return true;
    }

    /**
     * Mehmet Acikgoz
     * Returns true if the product has a thumbnail picture on the products main page, otherwise false.
     *
     * @param productname, the product name is given
     * @return true/false depending on the case.
     */
    public boolean hasThumbnailPicture(String productname) {
        WebElement product = selectProduct(productname);
        return hasThumbnailPicture(product);
    }
}
