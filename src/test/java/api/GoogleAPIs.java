package api;

import org.junit.BeforeClass;
import org.junit.Test;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GoogleAPIs {

    @BeforeClass
    public static void setup(){
        baseURI = "https://maps.googleapis.com/maps/api";
    }



    @Test
    public void getPlaceGoogleMaps(){
       // place/findplacefromtext/json

        given().
                queryParam("fields", "formatted_address").
                queryParam("input", "Lowes Pittsboro").
                queryParam("inputtype", "textquery").
                queryParam("key", "AIzaSyDdNmHK2RgQVbpksSzAFI6A2byAcdm_5l8").
                header("Accept", "*/*").

        when().log().all().
                get("/place/findplacefromtext/json").
        then().log().all().
                assertThat().
                            statusCode(200).
                            body("status", equalTo("OK"));


    }
}
