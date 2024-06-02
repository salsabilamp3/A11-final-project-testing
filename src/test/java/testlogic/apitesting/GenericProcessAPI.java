package testlogic.apitesting;

import org.junit.Assert;

import io.restassured.response.Response;

public class GenericProcessAPI {
    public static void validateStatusCode(Response actual, int expected){
        Assert.assertEquals(actual.getStatusCode(), expected);
    }

    public static void validateErrorMessage(Response actual, String expected){
        Assert.assertEquals(actual.getBody().jsonPath().getString("error"), expected);
    }
}
