package com.briteerp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class SessionsPage extends BasePage {
    //a[@name='user_id']
    @FindBy(name = "user_id")
    public WebElement userIDField;


    public SessionsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getStore(String storeName) {
        //tbody[@class='ui-sortable']//td[contains(text(),'Tysons corner mall')]
        String beforeXpath = "//tbody[@class='ui-sortable']//td[contains(text(),'";
        String afterXpath = "')]";
        String xpath = beforeXpath + storeName + afterXpath;

        WebElement element = Driver.getDriver().findElement(By.xpath(xpath));

        return element;

//Comment 2

    }
}
