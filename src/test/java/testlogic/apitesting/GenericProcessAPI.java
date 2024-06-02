package testlogic.apitesting;

import org.junit.Assert;

import io.restassured.response.Response;

public class GenericProcessAPI {
    public static void validateStatusCode(int expected, Response actual){
        Assert.assertEquals(expected, actual.getStatusCode());
    }

    public static void validateErrorMessage(String expected, Response actual){
        Assert.assertEquals(expected, actual.getBody().jsonPath().getString("error"));
    }
}
