package stepdefinitions.apitesting;

import static org.junit.Assert.assertEquals;

import Model.apitesting.User;
import Model.apitesting.Location;
import Model.apitesting.UserRequired;
import helper.SetUpEndPoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import testlogic.apitesting.CreateUserTest;
import testlogic.apitesting.DeleteUserTest;
import testlogic.apitesting.GenericProcessAPI;
import testlogic.apitesting.GetUserTest;
import testlogic.apitesting.RandomEmailGenerator;
import testlogic.apitesting.UpdateUserTest;

public class ApiUserSteps {
    GetUserTest apiGet;
    CreateUserTest apiCreate;
    UpdateUserTest apiUpdate;
    DeleteUserTest apiDelete;
    User dataTestUpdate;
    private Response response;
    private UserRequired userRequired;
    
    public ApiUserSteps(){
        apiGet = new GetUserTest();
        apiCreate = new CreateUserTest();
        apiUpdate = new UpdateUserTest();
        apiDelete = new DeleteUserTest();
    }

    @Given("Prepare url for {string}")
    public void prepare_url_for(String endpoint){
        SetUpEndPoint.prepareURL(endpoint);
    }

    /* Step Update User */
    @When("Hit api update user by id {string}")
    public void hit_api_update_user_by_id(String userId){
        dataTestUpdate = apiUpdate.prepareBodyUpdateAll();
        String url = SetUpEndPoint.getURL();
        apiUpdate.putUser(url, userId, dataTestUpdate);
    }

    @Then("validate response body updated user")
    public void validate_response_body_updated_user() {
        User expected = apiUpdate.prepareTestUpdateAll();
        apiUpdate.checkResponseBodyUpdatedUser(expected);
    }

    @Then("validate response body updated gender user")
    public void validate_response_body_updated_gender_user() {
        User expected = apiUpdate.dataTestUpdateGender();
        apiUpdate.checkResponseBodyUpdatedUser(expected);
    }

    @Then("validate response body updated title user")
    public void validate_response_body_updated_title_user() {
        User expected = apiUpdate.dataTestUpdateTitle();
        apiUpdate.checkResponseBodyUpdatedUser(expected);
    }

    @When("Hit api update user {string} {string} by id {string}")
    public void hit_api_update_user_by_id(String field, String value, String userId) {
        String url = SetUpEndPoint.getURL();
        apiUpdate.putUserOneField(url, userId, field, value);
    }

    @Then("validate status update response code is equals {int}")
    public void validate_status_response_code_is_equals(int statusCode){
        GenericProcessAPI.validateStatusCode(apiUpdate.getResponse(), statusCode);
    }

    @Then("validate error update message {string}")
    public void validate_error_message(String errorMessage) {
        GenericProcessAPI.validateErrorMessage(apiUpdate.getResponse(), errorMessage);
    }

    // create
    @When("Send a CREATE request without app-id in the header")
    public void send_create_request_without_app_id_in_header(){
        response = CreateUserTest.createWithoutAppId("Amel", "Dewi", "amelidew@examples.com");
    }

    @Given("Set the header {string} with value {string}")
    public void set_the_header_with_value(String header, String value) {
        CreateUserTest.setHeader(header, value);
    }

    @When("Set the request body as:")
    public void set_the_request_body_as(String docString) {
        CreateUserTest.setBody(docString);
    }

    @When("Send a CREATE request with incorrect app-id in the header")
    public void send_create_request_with_incorrect_app_id_in_header(){
        // Set header "app-id" with incorrect value
        CreateUserTest.setHeader("app-id", "66273c13e26079618814e20");
        // Create request with incorrect app-id
        userRequired = new UserRequired("Amel", "Dewi", "amelidew@examples.com");
        response = CreateUserTest.createAllField(userRequired);
    }

    @When("Send a CREATE request with valid data and correct app-id in the header")
    public void send_create_request_with_valid_data_and_correct_app_id_in_header(){
        userRequired = new UserRequired("Harry", "Potter", RandomEmailGenerator.generateRandomEmail());
        response = CreateUserTest.createAllField(userRequired);
    }

    @Then("Verify the response body contains user details")
    public void verify_response_body_contains_user_details() {
        CreateUserTest.validateCreateUserResponse(response, userRequired);
    }

    @When("Send a CREATE request with email already registered in the system")
    public void send_create_request_with_email_already_registered_in_the_system(){
        userRequired = new UserRequired("Haliya", "Potter", "hapotters@examples.com");
        response = CreateUserTest.createAllField(userRequired);
    }

    @When("Send a CREATE request with empty firstName")
    public void send_create_request_with_empty_firstName(){
        userRequired = new UserRequired("", "Granger", "hapotters@examples.com");
        response = CreateUserTest.createAllField(userRequired);
    }

    @Then("validate status create response code is equals {int}")
    public void validate_status_create_response_code_is_equals(int expectedStatusCode){
        assertEquals("Unexpected status code", expectedStatusCode, response.statusCode()); // Membandingkan kode status respons dengan yang diharapkan
    }

    @Then("validate create error message {string}")
    public void validate_creat_error_message(String errorMessage) {
        GenericProcessAPI.validateErrorMessage(response, errorMessage);
    }

    @When("Send a CREATE request with invalid firstName length, valid lastName, and valid email")
    public void send_create_request_with_invalid_firstName_length_valid_lastName_valid_email() {
        CreateUserTest.setHeader("app-id", "66273c13e26079618814ec16");
        userRequired = new UserRequired("F", "Elix", "felies@examples.com");
        response = CreateUserTest.createAllField(userRequired);
    }

    // Step Definitions for GET User API Tests
    @When("Send a GET request without app-id in the header to retrieve user data with id {string}")
    public void send_get_request_without_app_id(String userId) {
        response = GetUserTest.getUserByIdWithoutAppId(userId);
    }

    @When("Send a GET request with app-id {string} to retrieve user data with id {string}")
    public void send_get_request_with_app_id(String appId, String userId) {
        response = GetUserTest.getUserByIdWithAppId(userId, appId);
    }

    @Then("validate status get response code is equals {int}")
    public void validate_status_get_response_code_is_equals(int statusCode) {
        GenericProcessAPI.validateStatusCode(response, statusCode);
    }

    @Then("validate get error message {string}")
    public void validate_get_error_message(String errorMessage) {
        GenericProcessAPI.validateErrorMessage(response, errorMessage);
    }

    @Then("verify the response body contains user details with id {string}")
    public void verify_response_body_contains_user_details(String userId) {
        User expectedUser = new User();
        expectedUser.setId(userId);
        expectedUser.setTitle("ms");
        expectedUser.setFirstName("Ann");
        expectedUser.setLastName("Mason");
        expectedUser.setEmail("ann.mason@example.com");
        expectedUser.setGender("female");
        expectedUser.setDateOfBirth("1959-09-26T07:05:56.725Z");
        expectedUser.setRegisterDate("2021-06-21T21:02:15.705Z");
        expectedUser.setPhone("(385)-245-2517");
        expectedUser.setPicture("https://randomuser.me/api/portraits/med/women/18.jpg");

        Location location = new Location();
        location.setStreet("2698, Paddock Way");
        location.setCity("Orange");
        location.setState("Wyoming");
        location.setCountry("United States");
        location.setTimezone("+3:00");
        expectedUser.setLocation(location);

        expectedUser.setUpdatedDate("2021-06-21T21:02:15.705Z");

        apiGet.validateUserDetails(response, expectedUser);
    }

    // Step Definitions for DELETE User API Tests
    @When("Send a DELETE request without app-id in the header to delete user with id {string}")
    public void send_delete_request_without_app_id(String userId) {
        response = DeleteUserTest.deleteUserByIdWithoutAppId(userId);
    }

    @When("Send a DELETE request with app-id {string} to delete user with id {string}")
    public void send_delete_request_with_app_id(String appId, String userId) {
        response = DeleteUserTest.deleteUserByIdWithAppId(userId, appId);
    }

    @Then("validate status delete response code is equals {int}")
    public void validate_status_delete_response_code_is_equals(int statusCode) {
        GenericProcessAPI.validateStatusCode(response, statusCode);
    }

    @Then("validate delete error message {string}")
    public void validate_delete_error_message(String errorMessage) {
        GenericProcessAPI.validateErrorMessage(response, errorMessage);
    }

    @Then("verify the response body contains deleted user id {string}")
    public void verify_response_body_contains_deleted_user_id(String userId) {
        assertEquals("Unexpected user id in response", userId, response.jsonPath().getString("id"));
    }

}   