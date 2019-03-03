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

        #// Mehmet Keles 3- BRIT-2069
  Scenario: Verify that Pricetlist name is displayed on the page when user searched it
    When user types the name of the pricelist into the search box and hits ENTER
    Then user should be able to see the pricelist name on the page

        #// Mehmet Keles 4- BRIT-2086
  Scenario: Verify that selectable menu is disabled for any pricelist name
    When user clicks on any pricelist name
    Then user should be able to see selectable menu is disabled for any pricelist name

            #// Mehmet Keles 5- BRIT-2092
  Scenario: Verify that header of the page contains name of pricelist
    When user clicks on any pricelist name
    Then user should be able to see name of the pricelist at the header

              #// Mehmet Keles 6- BRIT-2095
  Scenario: Verify that Language is English
    When user clicks on any pricelist name
    And user clicks on Website localhost link
    Then user should be able to see that Language is English

            #// Mehmet Keles 7- BRIT-2096
  Scenario: Verify that title of the pricelist name contains pricelist name
    When user clicks on any pricelist name
    Then user should be able to see that title of the pricelist name contains pricelist name

           #// Mehmet Keles 8- BRIT-2103
  Scenario: Verify that header of the page contains "Access Error
    Given user clicks on check box of the one of the price name
    When user click on action drop down menu button
    And user selects archive
    Then user should be able to see that header of the page contains "Access Error"

           #// Mehmet Keles 9- BRIT-2106
  Scenario: Verify that Website localhost page is displayed
    Given user clicks on any pricelist name
    When user clicks on Website localhost link
    Then user should be able to see that Website localhost page is displayed

               #// Mehmet Keles 10- BRIT-2110
  Scenario: Verify that Twitter Account is correct.
    Given user clicks on any pricelist name
    When user clicks on Website localhost link
    Then user should be able to see that Twitter Account is correct.

  @w
  Scenario Outline: Verify that pricelist name exist or not.
    When user types "<pricelist_name>" into search box and hits ENTER
    Then user should not be able to see the name of the product on the page

    Examples:
      | pricelist_name |
      | apple          |
      | orange         |
      | lemon          |
      | cherry         |
      | peach          |








