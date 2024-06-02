package testlogic.apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testlogic.apitesting.request.EndPoint;

public class DeleteUserTest {
    private Response res;
    private static RequestSpecification request;

    private static void setUpHeader() {
        request = RestAssured.given()
                .header("Content-Type", "application/json");
    }

    public static Response deleteUserByIdWithoutAppId(String userId) {
        setUpHeader();
        return request.delete(EndPoint.DELETE_USER + userId);
    }

    public static Response deleteUserByIdWithAppId(String userId, String appId) {
        setUpHeader();
        request.header("app-id", appId);
        return request.delete(EndPoint.DELETE_USER + userId);
    }

    public Response getResponse() {
        return res;
    }

    public void setResponse(Response res) {
        this.res = res;
    }
}
