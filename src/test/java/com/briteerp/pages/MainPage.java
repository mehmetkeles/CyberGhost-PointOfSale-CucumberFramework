package com.briteerp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class MainPage extends BasePage {


    @FindBy(xpath = "//li//a//span[contains(text(),'Point of Sale')]")
    public WebElement pointOfSaleLink;

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
