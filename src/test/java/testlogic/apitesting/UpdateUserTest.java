package testlogic.apitesting;

import static org.junit.Assert.assertEquals;

import Model.apitesting.Location;
import Model.apitesting.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUserTest {

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

    public void putUserOneField(String url, String userId, String fieldName, String fieldValue){
        String endpoint = url + userId;
        setUpHeader();
        request.body("{\"" + fieldName + "\":\"" + fieldValue + "\"}");
        res =  request.put(endpoint);
    }

    public void putUser(String url, String userId, User user){
        String endpoint = url + userId;
        setUpHeader();
        request.body(user);
        res = request.put(endpoint);
    }

    public void checkResponseBodyUpdatedUser(User dataTestUser){
        User expectedBody = prepareTestUpdateAll();
        User actualBody = res.as(User.class);

        assertEquals(expectedBody.getId(), actualBody.getId());
        assertEquals(expectedBody.getTitle(), actualBody.getTitle());
        assertEquals(expectedBody.getFirstName(), actualBody.getFirstName());
        assertEquals(expectedBody.getLastName(), actualBody.getLastName());
        assertEquals(expectedBody.getPicture(), actualBody.getPicture());
        assertEquals(expectedBody.getGender(), actualBody.getGender());
        assertEquals(expectedBody.getEmail(), actualBody.getEmail());
        assertEquals(expectedBody.getDateOfBirth(), actualBody.getDateOfBirth());
        assertEquals(expectedBody.getPhone(), actualBody.getPhone());

        assertEquals(expectedBody.getLocation().getStreet(), actualBody.getLocation().getStreet());
        assertEquals(expectedBody.getLocation().getCity(), actualBody.getLocation().getCity());
        assertEquals(expectedBody.getLocation().getState(), actualBody.getLocation().getState());
        assertEquals(expectedBody.getLocation().getCountry(), actualBody.getLocation().getCountry());
        assertEquals(expectedBody.getLocation().getTimezone(), actualBody.getLocation().getTimezone());

        assertEquals(expectedBody.getRegisterDate(), actualBody.getRegisterDate());
        assertEquals(expectedBody.getUpdatedDate(), actualBody.getUpdatedDate());

    }

    public static User prepareTestUpdateAll(){
        User dataUser = new User();

        dataUser.setId("60d0fe4f5311236168a109d1");
        dataUser.setTitle("mr");
        dataUser.setFirstName("Kento");
        dataUser.setLastName("Yamazaki");
        dataUser.setPicture("https://randomuser.me/api/portraits/med/men/52.jpg");
        dataUser.setGender("male");
        dataUser.setEmail("kent.brewer@example.com");
        dataUser.setDateOfBirth("1955-07-19T00:57:14.606Z");
        dataUser.setPhone("025-351-5176");

        Location location = new Location();
        location.setStreet("4015, Okikawa Road");
        location.setCity("Buncrana");
        location.setState("Roscommoni");
        location.setCountry("Ireland");
        location.setTimezone("+6:00");
        dataUser.setLocation(location);

        dataUser.setRegisterDate("2021-06-21T21:02:08.506Z");
        dataUser.setUpdatedDate("2021-06-21T21:02:08.506Z");

        return dataUser;
    }

    public static User prepareBodyUpdateAll(){
        User dataUser = new User();

        dataUser.setTitle("mr");
        dataUser.setFirstName("Kento");
        dataUser.setLastName("Yamazaki");
        dataUser.setPicture("https://randomuser.me/api/portraits/med/men/52.jpg");
        dataUser.setGender("male");
        dataUser.setDateOfBirth("1955-07-19T00:57:14.606Z");
        dataUser.setPhone("025-351-5176");

        Location location = new Location();
        location.setStreet("4015, Okikawa Road");
        location.setCity("Buncrana");
        location.setState("Roscommoni");
        location.setCountry("Ireland");
        location.setTimezone("+6:00");
        dataUser.setLocation(location);

        return dataUser;
    }

}
