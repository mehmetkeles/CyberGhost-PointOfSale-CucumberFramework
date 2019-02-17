package com.briteerp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class LocalhostPage extends BasePage {

    public LocalhostPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[@name='social_twitter']")
    public WebElement twitter;

    @FindBy(xpath = "//label[@class='o_form_label']")
    public WebElement language;
}
