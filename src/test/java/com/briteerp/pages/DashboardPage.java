package com.briteerp.pages;

import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class DashboardPage extends BasePage {
    public DashboardPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
