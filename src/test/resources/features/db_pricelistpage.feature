@dbpricelist @db
Feature: As a POSManager9, I want to go to Pricelists page so that I can use the functionalities of this page for
  database testing

  Background:
    Given manager is on the Point of Sale page
    When user clicks on the Pricelist link

  Scenario Outline: Verify that new pricelist name is in database after it is created by manager
    And manager clicks on the create button
    When manager enters a "<pricelist_name>" and clicks on save button
    Then manager verifies that new "<pricelist_name>" is in database
    And manager deletes that new "<pricelist_name>" on pricelist page
    Then manager verifies that new "<pricelist_name>" is not in database

    Examples:
      | pricelist_name  |
      | Computers       |
      | Office Supplies |
      | School Supplies |





