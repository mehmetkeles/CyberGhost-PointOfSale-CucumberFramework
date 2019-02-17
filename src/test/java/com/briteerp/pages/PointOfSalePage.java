package com.briteerp.pages;

import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class PointOfSalePage extends BasePage {
    public PointOfSalePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
