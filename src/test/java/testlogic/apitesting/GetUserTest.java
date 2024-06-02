package testlogic.apitesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testlogic.apitesting.request.EndPoint;
import Model.apitesting.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class GetUserTest {
    private Response res;
    private static RequestSpecification request;

    private static void setUpHeader() {
        request = RestAssured.given()
                .header("Content-Type", "application/json");
    }

    public static Response getUserByIdWithoutAppId(String userId) {
        setUpHeader();
        return request.get(EndPoint.GET_USER_BY_ID + userId);
    }

    public static Response getUserByIdWithAppId(String userId, String appId) {
        setUpHeader();
        request.header("app-id", appId);
        return request.get(EndPoint.GET_USER_BY_ID + userId);
    }

    public Response getResponse() {
        return res;
    }

    public void setResponse(Response res) {
        this.res = res;
    }

    public void validateUserDetails(Response response, User expectedUser) {
        User actualUser = response.as(User.class);

        assertEquals(expectedUser.getId(), actualUser.getId());
        assertEquals(expectedUser.getTitle(), actualUser.getTitle());
        assertEquals(expectedUser.getFirstName(), actualUser.getFirstName());
        assertEquals(expectedUser.getLastName(), actualUser.getLastName());
        assertEquals(expectedUser.getEmail(), actualUser.getEmail());
        assertEquals(expectedUser.getGender(), actualUser.getGender());
        assertEquals(expectedUser.getDateOfBirth(), actualUser.getDateOfBirth());
        assertEquals(expectedUser.getRegisterDate(), actualUser.getRegisterDate());
        assertEquals(expectedUser.getPhone(), actualUser.getPhone());
        assertEquals(expectedUser.getPicture(), actualUser.getPicture());

        // Validate Location
        assertNotNull(actualUser.getLocation());
        assertEquals(expectedUser.getLocation().getStreet(), actualUser.getLocation().getStreet());
        assertEquals(expectedUser.getLocation().getCity(), actualUser.getLocation().getCity());
        assertEquals(expectedUser.getLocation().getState(), actualUser.getLocation().getState());
        assertEquals(expectedUser.getLocation().getCountry(), actualUser.getLocation().getCountry());
        assertEquals(expectedUser.getLocation().getTimezone(), actualUser.getLocation().getTimezone());

        assertEquals(expectedUser.getUpdatedDate(), actualUser.getUpdatedDate());
    }
}
