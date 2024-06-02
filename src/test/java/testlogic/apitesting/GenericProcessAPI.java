package testlogic.apitesting;

import org.junit.Assert;

import io.restassured.response.Response;

public class GenericProcessAPI {
    public static void validateStatusCode(Response actual, int expected){
        Assert.assertEquals(actual.getStatusCode(), expected);
    }
}
