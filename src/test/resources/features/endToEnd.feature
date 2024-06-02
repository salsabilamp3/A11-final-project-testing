Feature: Checkout Product
    As a user
    I want to be able to checkout a product successfully

  @endToEnd
  Scenario: Successfully checkout product
    Given User is on the login page
    When User enter their username "standard_user" and password "secret_sauce" then login
    Then User navigated to dashboard page
    
    When User click add to cart on product "Sauce Labs Backpack"
    And User see badge with number 1 on icon cart
    And User click icon cart
    Then User navigated to cart page
    And User see list of a product that added before
    
    When User click Checkout button
    Then User navigated to checkout information page
    And User enter first name "Lebron", last name "James", and postal code "40121" and continue
    Then User navigated to checkout overview page
    And User see list of the product that they checkout "Sauce Labs Backpack"
    And User see payment information "SauceCard #31337"
    And User see shipping information "Free Pony Express Delivery!"
    And User see item total "Item total: $29.99"
    And User see tax "Tax: $2.40"
    And User see total "Total: $32.39"
    
    When User click Finish button
    Then User should be navigated to checkout complete page
    And User should see a message saying 'Thank you for your order!'
