Feature: Cart Page
  As a user
  I want to view the cart page
  So that I can see the items I have added to the cart

  @cartTest
  Scenario: Display cart page when the cart is empty
    Given I am logged in to the inventory page
    When I click the cart icon
    Then The system displays the cart page without any items listed

  @cartTest
  Scenario: Display cart page when the cart contains at least one item
    Given I am logged in to the inventory page
    And I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bolt T-Shirt" to the cart
    When I click the cart icon
    Then The system displays the cart page with the items that have been added, namely 'Sauce Labs Backpack' and 'Sauce Labs Bolt T-Shirt'

  @cartTest
  Scenario: Continue shopping from the cart page when the cart is empty
    Given I am logged in to the inventory page
    When I click the cart icon
    And I click the 'Continue Shopping' button
    Then The system displays the dashboard page

  @cartTest
  Scenario: Proceed to checkout when the cart is empty
    Given I am logged in to the inventory page
    When I click the cart icon
    And I click the 'Checkout' button
    Then The current screen remains on the cart page, and an error message 'You Need Item In Cart To Proceed Checkout Process' is displayed

  @cartTest
  Scenario: Continue shopping from the cart page when the cart contains at least one item
    Given I am logged in to the inventory page
    And I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bolt T-Shirt" to the cart
    When I click the cart icon
    And I click the 'Continue Shopping' button
    Then The system displays the dashboard page

  @cartTest
  Scenario: Proceed to checkout when the cart contains at least one item
    Given I am logged in to the inventory page
    And I add "Sauce Labs Backpack" to the cart
    And I add "Sauce Labs Bolt T-Shirt" to the cart
    When I click the cart icon
    And I click the 'Checkout' button
    Then The system displays the checkout information page
