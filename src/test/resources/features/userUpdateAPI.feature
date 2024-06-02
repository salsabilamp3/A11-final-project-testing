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
