Feature: User Update API
    As a user
    I want to be able to update my data
    So that my data can always be up to date

  @API
  Scenario: Update user all field valid
    Given Prepare url for "UPDATE_USER"
    When Hit api update user by id "60d0fe4f5311236168a109d1"
    Then validate status response code is equals 200
    And validate response body updated user

  @API
  Scenario: Update user title valid
    Given Prepare url for "UPDATE_USER"
    When Hit api update user "title" "mrs" by id "60d0fe4f5311236168a109db"
    Then validate status update response code is equals 200
    And validate response body updated user

  @API
  Scenario: Update user gender
    Given Prepare url for "UPDATE_USER"
    When Hit api update user "gender" "" by id "60d0fe4f5311236168a10a18"
    Then validate status update response code is equals 200
    And validate response body updated user

  @API
  Scenario: Update user email
    Given Prepare url for "UPDATE_USER"
    When Hit api update user "email" "emails@example.com" by id "60d0fe4f5311236168a10a27"
    Then validate status update response code is equals 400
    And validate error update message "BODY_NOT_VALID"

  @API
  Scenario: Update user title with not existed id
    Given Prepare url for "UPDATE_USER"
    When Hit api update user "title" "mrs" by id "60d0fe4f5311236168a10a35"
    Then validate status update response code is equals 404
    And validate error update message "RESOURCE_NOT_FOUND"
