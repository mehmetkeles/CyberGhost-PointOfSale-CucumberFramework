@Orders
Feature: Products functionality

#  Background: getting to the Point of Sale Page as user
#    Given user is already on the login page
#    When user enters "in_pos_user4@info.com" and "KjKtfgrs40"
#    Then homepage should be displayed
#    When user clicks on PointofSale link
#    Then PointOfSale page should be displayed


  @wip
  Scenario: valid OrdersPage Title
    Given user is on the Point of Sale page
    When user clicks on orders link
    Then Orders page should be displayed

  //Serkan2- BRIT-760
  Scenario: Verify that Orderlists page title contains Orderlists
  Then user should see the title contains Orderlists

  //
  Scenario: The name of the order is seen on the page
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then user selects a order
    And user clicks on the order