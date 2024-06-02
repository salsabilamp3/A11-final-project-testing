package testlogic.apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testlogic.apitesting.request.EndPoint;
import Model.apitesting.User;
import Model.apitesting.UserRequired;
import io.restassured.http.ContentType;
import static org.junit.Assert.*;

public class CreateUserTest {
    private Response res;
    private static RequestSpecification request;

    public Response getResponse(){
        return res;
    }

    public void setResponse(Response res){
        this.res = res;
    }

    private static void setUpHeader(){
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("app-id", "66273be9e26079c76814ec13");
    }

    public static Response createAllField(UserRequired user) {
        setUpHeader();
        request.body(user);
        return request.post(EndPoint.CREATE_USER);
    }

    public static void setHeader(String header, String value) {
        request.header(header, value);
    }

    public static void setBody(String body) {
        request.body(body);
    }

    public static Response createWithoutAppId(String firstName, String lastName, String email) {
        // Set up the request body
        String body = "{\"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName + "\", \"email\": \"" + email + "\"}";
    
        // Set up the request without app-id
        request = RestAssured.given()
                .header("Content-Type", "application/json");
        
        // Send the request and return the response
        return request.body(body).post(EndPoint.CREATE_USER);
    }     

    public static void validateCreateUserResponse(Response response, UserRequired user) {
        User actualBody = response.as(User.class);

        assertEquals(user.getFirstName(), actualBody.getFirstName());
        assertEquals(user.getLastName(), actualBody.getLastName());
        assertEquals(user.getEmail(), actualBody.getEmail());

        // Check for auto-generated fields by the server
        assertNotNull(actualBody.getId());
        assertNotNull(actualBody.getRegisterDate());
        assertNotNull(actualBody.getUpdatedDate());
    }
}
