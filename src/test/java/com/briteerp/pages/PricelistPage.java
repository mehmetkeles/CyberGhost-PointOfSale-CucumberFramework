package com.briteerp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

import java.util.List;
import java.util.Random;

public class PricelistPage extends BasePage {
    @FindBy(xpath = "//td[@class='o_data_cell o_readonly_modifier o_required_modifier']")
    public List<WebElement> pricelistsNames;

    @FindBy(xpath = "//span[@class='o_field_char o_field_widget o_readonly_modifier o_required_modifier']")
    public WebElement pricelistNameHeader;

    @FindBy(xpath = "//input[contains(@id,'o_field_input')]")
    public WebElement selectableMenu;

    @FindBy(xpath = "//td[@class='o_list_record_selector']")
    public List<WebElement> PriceListNameCheckBoxes;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]")
    public WebElement actionButton;

    @FindBy(xpath = "//a[@data-index='1']")
    public WebElement archiveButton;

    @FindBy(className = "modal-title")
    public WebElement accessError;

    @FindBy(xpath = "(//a[contains(@id,'o_field_input')])[2]")
    public WebElement localhostLink;

    public PricelistPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement selectAPricelistName() {
        int rnd = new Random().nextInt(pricelistsNames.size());
        WebElement pricelistName = pricelistsNames.get(rnd);
        return pricelistName;
    }

    public WebElement selectAPricelistNameCheckBox() {
        int rnd = new Random().nextInt(PriceListNameCheckBoxes.size());
        WebElement PricelistNameCheckBox = PriceListNameCheckBoxes.get(rnd);
        return PricelistNameCheckBox;
    }
    //keles
}
