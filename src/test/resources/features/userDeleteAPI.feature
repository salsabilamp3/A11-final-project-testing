Feature: Delete User API
    As a user
    I want to be able to delete user data
    So that I can remove user details from the system

  @APIDelete
  Scenario: Delete user without setting app-id in the request header
    Given Prepare url for "DELETE_USER"
    When Send a DELETE request without app-id in the header to delete user with id "60d0fe4f5311236168a109ce"
    Then validate status delete response code is equals 403
    And validate delete error message "APP_ID_MISSING"

  @APIDelete
  Scenario: Delete user with incorrect app-id in the request header
    Given Prepare url for "DELETE_USER"
    When Send a DELETE request with app-id "66273c13e26079618814e16" to delete user with id "60d0fe4f5311236168a109ce"
    Then validate status delete response code is equals 403
    And validate delete error message "APP_ID_NOT_EXIST"

  @APIDelete
  Scenario: Delete user with valid id but not registered or already deleted in the system
    Given Prepare url for "DELETE_USER"
    When Send a DELETE request with app-id "66273c13e26079618814ec16" to delete user with id "60d0fe4f5311236168a109ce"
    Then validate status delete response code is equals 404
    And validate delete error message "RESOURCE_NOT_FOUND"

  @APIDelete
  Scenario: Delete user with incorrect id format
    Given Prepare url for "DELETE_USER"
    When Send a DELETE request with app-id "66273c13e26079618814ec16" to delete user with id "15"
    Then validate status delete response code is equals 400
    And validate delete error message "PARAMS_NOT_VALID"

  @APIDelete
  Scenario: Delete user without setting id parameter in the endpoint
    Given Prepare url for "DELETE_USER"
    When Send a DELETE request with app-id "66273c13e26079618814ec16" to delete user with id ""
    Then validate status delete response code is equals 404
    And validate delete error message "PATH_NOT_FOUND"
