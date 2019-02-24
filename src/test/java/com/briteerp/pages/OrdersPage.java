package com.briteerp.pages;

import com.briteerp.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

import java.util.List;
import java.util.Random;

public class OrdersPage extends BasePage {

    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public List<WebElement> OrderlistsNames;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement OrderlistNameHeader;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement SelectAOrder;


    @FindBy(xpath = "//input[contains(@id,'o_field_input')]")
    public WebElement selectableMenu;


    @FindBy(xpath = "(//a[contains(@id,'o_field_input')])[2]")
    public WebElement localhostLink;

    @FindBy(xpath = "//td[@class='o_list_record_selector']")
    public List<WebElement> OrdersNameCheckBoxes;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default oe_highlight']")
    public List<WebElement> payment;

    @FindBy(xpath = "//div//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement EditButton;




    public OrdersPage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public WebElement selectOrderlistName() {
        int rnd = new Random().nextInt(OrderlistsNames.size());
        WebElement orderlistName = OrderlistsNames.get(rnd);
        return orderlistName;
    }

    public void clickOnOrder(WebElement Orders) {
        BrowserUtils.waitForClickablility(Orders, timeOutInSec);
        Orders.click();
    }







}
