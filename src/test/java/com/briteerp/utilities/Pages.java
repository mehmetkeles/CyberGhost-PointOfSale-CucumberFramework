package com.briteerp.utilities;

import com.briteerp.pages.*;


public class Pages {
    private HomePage homePage;
    private LoginPage loginPage;
    private MainPage mainPage;
    private PointOfSalePage pointOfSalePage;


    private DashboardPage dashboardPage;
    private OrdersPage ordersPage;
    private ProductsPage productsPage;
    private PricelistPage pricelistPage;
    private SessionsPage sessionsPage;
    private LocalhostPage localhostPage;


    public HomePage home() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public LoginPage login() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public MainPage main() {
        if (mainPage == null) {
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public PointOfSalePage pointOfSale() {
        if (pointOfSalePage == null) {
            pointOfSalePage = new PointOfSalePage();
        }
        return pointOfSalePage;
    }

    public DashboardPage dashboard() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }

    public OrdersPage orders() {
        if (ordersPage == null) {
            ordersPage = new OrdersPage();
        }
        return ordersPage;
    }

    public ProductsPage products() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

    public PricelistPage pricelist() {
        if (pricelistPage == null) {
            pricelistPage = new PricelistPage();
        }
        return pricelistPage;
    }

    public SessionsPage sessions() {
        if (sessionsPage == null) {
            sessionsPage = new SessionsPage();
        }
        return sessionsPage;
    }

    public LocalhostPage localhost() {
        if (localhostPage == null) {
            localhostPage = new LocalhostPage();
        }
        return localhostPage;
    }
}
