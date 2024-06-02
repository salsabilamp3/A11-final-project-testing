package stepdefinitions.apitesting;

import static org.junit.Assert.assertEquals;

import Model.apitesting.User;
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

    @Then("validate status response code is equals {int}")
    public void validate_status_response_code_is_equals(int statusCode){
        GenericProcessAPI.validateStatusCode(apiUpdate.getResponse(), statusCode);
    }

    @Then("validate error message {string}")
    public void validate_error_message(String errorMessage) {
        GenericProcessAPI.validateErrorMessage(apiUpdate.getResponse(), errorMessage);
    }

    /* Step Update User */
    @When("Hit api update user by id {string}")
    public void hit_api_update_user_by_id(String userId){
        dataTestUpdate = UpdateUserTest.prepareBodyUpdateAll();
        String url = SetUpEndPoint.getURL();
        apiUpdate.putUser(url, userId, dataTestUpdate);
    }

    @Then("validate response body updated user")
    public void validate_response_body_updated_user() {
        apiUpdate.checkResponseBodyUpdatedUser(dataTestUpdate);
    }

    @When("Hit api update user {string} {string} by id {string}")
    public void hit_api_update_user_by_id(String field, String value, String userId) {
        String url = SetUpEndPoint.getURL();
        apiUpdate.putUserOneField(url, userId, field, value);
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

}   