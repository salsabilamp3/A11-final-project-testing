Feature: User Creation API
    As a user
    I want to be able to create a new user
    So that I can register in the system

  @APICreate
  Scenario: Add user without setting app-id in the request header
    Given Prepare url for "CREATE_USER"
    When Send a CREATE request without app-id in the header
    And Set the request body as:
      """
      {
        "firstName": "Amel",
        "lastName": "Dewi",
        "email": "amelidew@examples.com"
      }
      """
    Then validate status create response code is equals 403
    And validate create error message "APP_ID_MISSING"

  @APICreate
  Scenario: Add user with valid data and correct app-id in the request header
    Given Prepare url for "CREATE_USER"
    And Set the header "app-id" with value "66273c13e26079618814ec16"
    When Send a CREATE request with valid data and correct app-id in the header
    And Set the request body as:
      """
      {
        "firstName": "Harry",
        "lastName": "Potter",
        "email": "{random}@examples.com"
      }
      """
    Then validate status create response code is equals 200
    And Verify the response body contains user details

  @APICreate
  Scenario: Add user with email already registered in the system
    Given Prepare url for "CREATE_USER"
    And Set the header "app-id" with value "66273c13e26079618814ec16"
    When Send a CREATE request with email already registered in the system
    And Set the request body as:
      """
      {
        "firstName": "Haliya",
        "lastName": "Potter",
        "email": "hapotters@examples.com"
      }
      """
    Then validate status create response code is equals 400
    And validate create error message "BODY_NOT_VALID"

  @APICreate
  Scenario: Add user with empty firstName
    Given Prepare url for "CREATE_USER"
    And Set the header "app-id" with value "66273c13e26079618814ec16"
    When Send a CREATE request with empty firstName
    And Set the request body as:
      """
      {
        "firstName": "",
        "lastName": "Granger",
        "email": "hapotters@examples.com"
      }
      """
    Then validate status create response code is equals 400
    And validate create error message "BODY_NOT_VALID"

@APICreate
  Scenario: Add user with invalid firstName length and valid lastName and email
    Given Prepare url for "CREATE_USER"
    And Set the header "app-id" with value "66273c13e26079618814ec16"
    When Send a CREATE request with invalid firstName length, valid lastName, and valid email
    And Set the request body as:
      """
      {
        "firstName": "F",
        "lastName": "Elix",
        "email": "{random}@examples.com"
      }
      """
    Then validate status create response code is equals 400
    And validate create error message "BODY_NOT_VALID"