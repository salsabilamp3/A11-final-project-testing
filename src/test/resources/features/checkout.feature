Feature: Checkout product
    As a user
    I want to be able to checkout products that I added to cart
    So that I can pay for the products that I want

  Background:
    Given I am on the login page
    And I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I should be logged in successfully
    And I add "Sauce Labs Bike Light" to the cart
    And I click the cart icon
    And I should be navigated to cart page
    And the cart should contain 1 item
    And the item on cart at index 0 should have quantity "1", name "Sauce Labs Bike Light", description "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", and price "$9.99"
    And I click the 'Checkout' button
    And I should be navigated to checkout information page

  @checkoutTest
  Scenario: Cancel chekcout without filling the information form
    When I click the cancel checkout button
    Then I should be navigated to cart page
    And the cart should contain 1 item
    And the item on cart at index 0 should have quantity "1", name "Sauce Labs Bike Light", description "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", and price "$9.99"

  @checkoutTest
  Scenario: Continue checkout with providing valid information
    When I enter my firstname "Lebron", lastname "James", and postal code "40121"
    And I click the continue button
    Then I should be navigated to checkout overview page
    And the overview should contain 1 item
    And the item on overwiew at index 0 should have have quantity "1", name "Sauce Labs Bike Light", description "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", and price "$9.99"
    And the payment information should be "SauceCard #31337"
    And the shipping information should be "Free Pony Express Delivery!"
    And the item total should be "Item total: $9.99"
    And the tax should be "Tax: $0.80"
    And the total should be "Total: $10.79"

  @checkoutTest
  Scenario: Continue checkout without filling the information form
    When I click the continue button
    Then I should remain on the checkout information page
    And I should see an error checkout message saying "First Name, Last Name, and Zip/Postal Code is required!"
