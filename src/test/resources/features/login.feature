@login
Feature: login functionality
  As a user, I should be able to login to the website with valid credentials.

  
  Scenario: user login
    Given user is already on the login page
    When user enters "in_pos_user4@info.com" and "KjKtfgrs40"
    Then homepage should be displayed

  Scenario: manager login
    Given user is already on the login page
    When user enters "in_pos_manager10@info.com" and "KjKtfgrs38"
    Then homepage should be displayed

  Scenario: login as user
    Given user is already on the login page
    When user logs in as user
    Then homepage should be displayed

  Scenario: login as manager
    Given user is already on the login page
    When user logs in as manager
    Then homepage should be displayed
    