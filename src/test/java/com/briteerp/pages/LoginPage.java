package com.briteerp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.Driver;

public class LoginPage extends BasePage {

    @FindBy(linkText = "Sign in")
    public WebElement sign;

    @FindBy(id = "login")
    public WebElement email;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void login(String username, String password) {
        this.email.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }
}
