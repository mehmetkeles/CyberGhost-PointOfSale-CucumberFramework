@pricelist
Feature: As a POSUser4, I want to go to Pricelists page so that I can use the functionalities of this page

  Background:
    Given user is on the Point of Sale page
    When user clicks on the Pricelist link

    #// Mehmet Keles 1- BRIT-2063
  Scenario: Verify that page header of the page is Pricelists
    Then user should see the header is displaying Pricelists

    #// Mehmet Keles 2- BRIT-2067
  Scenario: Verify that Pricelists page title contains Pricelists
    Then user should see the title contains Pricelists


