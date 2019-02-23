package com.briteerp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class PointOfSalePage extends BasePage {

    @FindBy(css = "span.oe_topbar_name")
    public WebElement topUsername;

    public PointOfSalePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
