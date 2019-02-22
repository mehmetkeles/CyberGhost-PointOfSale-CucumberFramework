package com.briteerp.utilities;

import com.briteerp.pages.*;

public class Pages {
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static MainPage mainPage;
    private static PointOfSalePage pointOfSalePage;



    private DashboardPage dashboardPage;
    private OrdersPage ordersPage;
    private static ProductsPage productsPage;
    private PricelistPage pricelistPage;
    private SessionsPage sessionsPage;
    private LocalhostPage localhostPage;



    public static HomePage home() {
        return new HomePage();
    }

    public static LoginPage login() {
        return new LoginPage();
    }

    public static MainPage main() {
        return new MainPage();
    }

    public static PointOfSalePage pointOfSale() {
            return  new PointOfSalePage();
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

    public static ProductsPage products() {
         return  new ProductsPage();
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
