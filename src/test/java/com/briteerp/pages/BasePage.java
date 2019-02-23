package com.briteerp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.briteerp.utilities.ConfigurationReader;
import com.briteerp.utilities.Driver;

public abstract class BasePage {



    @FindBy(css = "span.oe_topbar_name")
    public WebElement topUsername;

    @FindBy(xpath = "//a[@class='o_sub_menu_logo']//img")
    public WebElement imgLogoLink;

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.menu_pos_dashboard']")
    public WebElement dashboardLink;

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.menu_point_ofsale']")
    public WebElement ordersLink;

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.menu_pos_products']")
    public WebElement productsLink;

    @FindBy(xpath = "//a[@data-menu-xmlid='point_of_sale.pos_config_menu_action_product_pricelist']")
    public WebElement priceListLink;


    @FindBy(xpath = "//div[@class='o_control_panel']//ol/li")
    public WebElement tabTitle;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchInput;

    @FindBy(xpath = "//div[@class='o_searchview']//span[contains(@title,\"Advanced Search\")]")
    public WebElement advancedSearchBtn;


    @FindBy(xpath = "//button[@class='fa fa-chevron-left btn btn-icon o_pager_previous']")
    public WebElement previousPageBtn;

    @FindBy(xpath = "fa fa-chevron-right btn btn-icon o_pager_next']")
    public WebElement nextPageBtn;


    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-th-large o_cp_switch_kanban active']")
    public WebElement viewTypeKanban;

    @FindBy(xpath = "//button[@class='btn btn-icon fa fa-lg fa-list-ul o_cp_switch_list']")
    public WebElement viewTypeList;

    @FindBy(linkText = "Sessions")
    public WebElement sessionsLink;


    protected final int timeOutInSec = Integer.parseInt(ConfigurationReader.getProperty("timeOutInSec"));

    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}


