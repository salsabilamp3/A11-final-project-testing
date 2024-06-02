package helper;

import testlogic.apitesting.request.EndPoint;

public class SetUpEndPoint {
    private static SetUpEndPoint helperClass;
    private static String URL;

    public static void setUpApi() {
        if (helperClass==null) {

            helperClass = new SetUpEndPoint();
        }
    }

    public static String getURL() {
        return URL;
    }

    public static void prepareURL(String url) {
        System.out.println("Prepare URL : " + url);
        URL = "";
        switch (url) {
            case "GET_USER" :
                URL = EndPoint.GET_USER_BY_ID;
                break;
            case "CREATE_USER" :
                URL = EndPoint.CREATE_USER;
                break;
            case "UPDATE_USER" :
                URL = EndPoint.UPDATE_USER;
                break;
            case "DELETE_USER" :
                URL = EndPoint.DELETE_USER;
                break;
            default:
                System.out.println("Please Input Right URL : ");
        }

        if(!url.isBlank()){
            System.out.println("URL is : " + URL);
        }
    }
}
