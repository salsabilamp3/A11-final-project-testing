Feature: Dashboard
  As a user
  I want to add products to the cart
  So that I can purchase them later

  @dashboardTest
  Scenario: Add product to cart when cart is empty
    Given I am logged in to the inventory page
    When I add "Sauce Labs Backpack" to the cart
    Then The item "Sauce Labs Backpack" should be added to the cart

  @dashboardTest
  Scenario: Add product to cart when there is one product added
    Given I am logged in to the inventory page
    Given I add "Sauce Labs Backpack" to the cart
    When I add "Sauce Labs Bolt T-Shirt" to the cart
    Then The item "Sauce Labs Bolt T-Shirt" should be added to the cart

  @dashboardTest
  Scenario: Add product to cart when there are more than one product added
    Given I am logged in to the inventory page
    Given I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bolt T-Shirt" to the cart
    When I add "Sauce Labs Onesie" to the cart
    Then The item "Sauce Labs Onesie" should be added to the cart
