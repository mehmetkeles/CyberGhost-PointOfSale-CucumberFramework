@sessions
Feature: As a manager, I should be able to login successfully



  Background:

    Given manager on the login page
    When manager selects demo
    When use valid credentials
    Then click on Point of Sale module on the top

    #Eyup Savas 1- BRIT-

  Scenario: manager login


    And manager user name should be displayed on the top right

    #Eyup Savas 2- BRIT-
  Scenario: Point of Sale header

  And Verify that Point of Sale page has a header as Point of Sale on the top left

