package stepdefinitions.apitesting;

import Model.apitesting.User;
import helper.SetUpEndPoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testlogic.apitesting.CreateUserTest;
import testlogic.apitesting.DeleteUserTest;
import testlogic.apitesting.GenericProcessAPI;
import testlogic.apitesting.GetUserTest;
import testlogic.apitesting.UpdateUserTest;

public class ApiUserSteps {
    GetUserTest apiGet;
    CreateUserTest apiCreate;
    UpdateUserTest apiUpdate;
    DeleteUserTest apiDelete;
    User dataTestUpdate;

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

}
