@products
Feature: Products functionality

#  Background: getting to the Point of Sale Page as user
#    Given user is already on the login page
#    When user enters "in_pos_user4@info.com" and "KjKtfgrs40"
#    Then homepage should be displayed
#    When user clicks on PointofSale link
#    Then PointOfSale page should be displayed

#  Background:
#    Given user is on the Point of Sale page

  @wip
  Scenario: valid ProductsPage Title
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then Products page should be displayed

  Scenario:Product has a name and sales price
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user selects a product
    Then user should see the name and sales price of the product

  Scenario: Has a product with a thumbnail picture have a picture when clicked.
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user selects a product with a thumbnail picture
    Then user clicks on the product
    Then user should be able to see the picture of the product

  Scenario: Verify the sales price of a product.
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user selects a product and remembers its price
    Then user clicks on the product
    And user should be able to see the same price


  Scenario: The product is displayed when searched
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user selects a product
    Then user types the name of the product into search box and hits ENTER
    Then user should be able to see the product on the page


  Scenario: User should be able to write some notes on a selected product
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user selects a product
    Then user clicks on the product
    Then user clicks on Log note link
    And user writes some notes and clicks on Log button
    Then user should be able to see the note on the page


  Scenario: The cost of a product is less than the sales price
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then user selects a product
    And user clicks on the product
    Then user should be able to see that cost is less than sales price


  Scenario: The name of the product is seen on the page
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then user selects a product
    And user clicks on the product
    Then user should be able to see the name of the product on the page


  Scenario Outline:  product information data driven test with excel <product_name>
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then user click on "<product_name>"
    And page should display details for the product

    Examples:
      | product_name          |
      | Boni Oranges          |
      | Conference pears      |
      | Carrots               |
      | Assembly Service Cost |
      | Car Travel Expenses   |


  Scenario: Availability of some products in the products list
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then user should be able to see the following products in the listing:
      | Bolka    |
      | Cleaning |
      | iphone 8 |
      | Airpods  |


  Scenario Outline: Product information data drivem test <product_name>
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user click on "<product_name>"
    Then user should see the product information
      | type  | <product_type> |
      | price | <sales_price>  |
      | cost  | <cost>         |

    Examples:
      | product_name          | sales_price | cost | product_type |
      | Boni Oranges          | 1.98        | 0.00 | Consumable   |
      | Conference pears      | 2.70        | 0.00 | Consumable   |
      | Carrots               | 2.90        | 0.00 | Consumable   |
      | Assembly Service Cost | 2.00        | 0.10 | Service      |
      | Car Travel Expenses   | 0.50        | 0.32 | Service      |

  @products_manager
  Scenario: Manager can update the sales price of the product
    Given manager is on the Point of Sale page
    When user clicks on Products link
    Then user selects a product
    And user clicks on the product
    Then user clicks the edit button
    And user can change the sales price and clicks the save button
    Then user should be able to see the update sales price

  @db
  Scenario: Verify the sales price of a product from the database
    Given user is on the Point of Sale page
    When user clicks on Products link
    And user selects a product and remembers its price
    Then user verifies the price


  @db
  Scenario Outline: Verify the sales price of a product from the database
    Given user is on the Point of Sale page
    When user clicks on Products link
    Then user click on "<product_name>" and remembers its price
    Then user verifies the price

    Examples:
      | product_name          |
      | Boni Oranges          |
      | Conference pears      |
      | Carrots               |

    @db
    Scenario: Verify the number of products which are for sale
      Given user is on the Point of Sale page
      When user clicks on Products link
      And user remembers the number of products available
      Then users verifies the number from the database
