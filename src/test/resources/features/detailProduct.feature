Feature: Detail products
    As a user
    I want to be able to see the detail of the product 
    So I can read more information about the product

  Background:
    Given I am on the login page
    And I enter my username "standard_user" and password "secret_sauce"
    And I click the login button
    And I should be logged in successfully

  @detailProductTest
  Scenario: Check detail product by clicking the product image
    When I click the product "Sauce Labs Backpack" image
    Then I should be navigated to detail product page
    And the detail product name is "Sauce Labs Backpack"
    And the detail product description is "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
    And the detail prodcut price is "$29.99"
    And the detail product image alt is "Sauce Labs Backpack"

  @detailProductTest
  Scenario: Check detail product by clicking the product name
    When I click the product "Sauce Labs Backpack" name
    Then I should be navigated to detail product page
    And the detail product name is "Sauce Labs Backpack"
    And the detail product description is "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
    And the detail prodcut price is "$29.99"
    And the detail product image alt is "Sauce Labs Backpack"

  @detailProductTest
  Scenario: Add product to cart in detail product page
    Given I click the product "Sauce Labs Backpack" name
    And I should be navigated to detail product page
    And the detail product name is "Sauce Labs Backpack"
    When I click Add to cart button in detail product
    Then I should remain on the detail product page
    And the detail product name is "Sauce Labs Backpack"
    And the detail product description is "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection."
    And the detail prodcut price is "$29.99"
    And the detail product image alt is "Sauce Labs Backpack"
    And the detail product button become remove
