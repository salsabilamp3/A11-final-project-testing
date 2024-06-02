Feature: Retrieve User API
    As a user
    I want to be able to retrieve user data
    So that I can see user details

  @APIGet
  Scenario: Retrieve user data without setting app-id in the request header
    Given Prepare url for "GET_USER"
    When Send a GET request without app-id in the header to retrieve user data with id "60d0fe4f5311236168a109fa"
    Then validate status get response code is equals 403
    And validate get error message "APP_ID_MISSING"

  @APIGet
  Scenario: Retrieve user data with incorrect app-id in the request header
    Given Prepare url for "GET_USER"
    When Send a GET request with app-id "66273be9e26079c76814ec99" to retrieve user data with id "60d0fe4f5311236168a109fa"
    Then validate status get response code is equals 403
    And validate get error message "APP_ID_NOT_EXIST"

  @APIGet
  Scenario: Retrieve user data with a valid and registered user id
    Given Prepare url for "GET_USER"
    When Send a GET request with app-id "66273be9e26079c76814ec13" to retrieve user data with id "60d0fe4f5311236168a109fa"
    Then validate status get response code is equals 200
    And verify the response body contains user details with id "60d0fe4f5311236168a109fa"

  @APIGet
  Scenario: Retrieve user data with a valid but unregistered user id
    Given Prepare url for "GET_USER"
    When Send a GET request with app-id "66273be9e26079c76814ec13" to retrieve user data with id "60d0fe4f5311236168a10999"
    Then validate status get response code is equals 404
    And validate get error message "RESOURCE_NOT_FOUND"

  @APIGet
  Scenario: Retrieve user data with an invalid user id format
    Given Prepare url for "GET_USER"
    When Send a GET request with app-id "66273be9e26079c76814ec13" to retrieve user data with id "123abc"
    Then validate status get response code is equals 400
    And validate get error message "PARAMS_NOT_VALID"
