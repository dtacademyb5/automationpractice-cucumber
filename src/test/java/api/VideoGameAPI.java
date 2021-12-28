package api;
import io.restassured.RestAssured;
import org.apache.hc.core5.http.HttpRequest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static  io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class VideoGameAPI {


    @BeforeClass
    public static void setup(){
        baseURI = "http://localhost:8080/app";
    }

    @Test
    public void demo(){

        // Builder pattern

        //



        given().
                header("Accept", "application/json").

        when().log().all().
                get("/videogames/9").
        then().log().all().
                statusCode(200).
                body("id", equalTo(9)).
                body("name", is("Bendy")).
                body("reviewScore", equalTo(100)).
                header("content-type", "application/json");


    }



    @Test
    public void testPostRequest(){

        int randomId = (int)(System.currentTimeMillis());
        given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body("{\n" +
                        "  \"id\": "+randomId+",\n" +
                        "  \"name\": \"Bendy\",\n" +
                        "  \"releaseDate\": \"2021-12-22T18:52:54.990Z\",\n" +
                        "  \"reviewScore\": 99,\n" +
                        "  \"category\": \"FPS\",\n" +
                        "  \"rating\": \"PG13\"\n" +
                        "}").
        when().log().all().
                post("/videogames").
        then().log().all().
                statusCode(200).
                body("status", is("Record Added Successfully")).
                header("content-length", "39").
                header("content-type", "application/json").
                time(lessThan(1000L));





    }




    @Test
    public void testPUTRequest(){

         int id = 22;
         given().
                body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"name\": \"Dendy\",\n" +
                        "  \"releaseDate\": \"2021-12-22T18:52:54.991Z\",\n" +
                        "  \"reviewScore\": 90,\n" +
                        "  \"category\": \"Adventure\",\n" +
                        "  \"rating\": \"PG12\"\n" +
                        "}").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                pathParam("videoGameId", "22").
                when().log().all().
                put("/videogames/{videoGameId}").
                then(). log().all().
                statusCode(200).
                 body("id", is(id));


    }


    @Test
    public void testDeleteRequest(){



        given().
                header("Accept", "application/json").
                pathParam("videoGameId", "22").
        when().log().all().
                delete("/videogames/{videoGameId}").
        then().log().all().statusCode(200).
                body("status", is("Record Deleted Successfully"));

    }



    @Test
    public void testEndToEndScenario(){


        // Create a new videogame

         int id = 101;
        given().
                given().
                header("Content-Type", "application/json").
                header("Accept", "application/json").
//                body(new File("newGame.json")).
                body("{\n" +
        "  \"id\": "+id+",\n" +
        "  \"name\": \"Bendy\",\n" +
        "  \"releaseDate\": \"2021-12-28T15:58:29.877Z\",\n" +
        "  \"reviewScore\": 99,\n" +
        "  \"category\": \"Adventure\",\n" +
        "  \"rating\": \"PG13\"\n" +
        "}").
                when().log().all().
                post("/videogames").
                then().log().all().
                statusCode(200);

        // Verify if the videogame is created

        given().
                header("Accept", "application/json").
                pathParam("videoGameId", id).
                when().log().all().
                get("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200).
                body("id", equalTo(id));


        // Update the video game details

        String name = "Dendy";
        given().
                body("{\n" +
                        "  \"id\": "+id+",\n" +
                        "  \"name\": \""+name+"\",\n" +
                        "  \"releaseDate\": \"2021-12-22T18:52:54.991Z\",\n" +
                        "  \"reviewScore\": 99,\n" +
                        "  \"category\": \"Adventure\",\n" +
                        "  \"rating\": \"PG13\"\n" +
                        "}").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                pathParam("videoGameId", id).
                when().log().all().
                put("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200);


        // Verify if the update was successful

        given().
                header("Accept", "application/json").
                pathParam("videoGameId", id).
                when().log().all().
                get("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200).
                body("name", equalTo(name));


        // Delete the vidogame

        given().
                header("Accept", "application/json").
                pathParam("videoGameId", id).
                when().log().all().
                delete("/videogames/{videoGameId}").
                then().log().all().
                statusCode(200);


        // Verify if delete happened successfully

        given().
                header("Accept", "application/json").
                pathParam("videoGameId", id).
                when().log().all().
                get("/videogames/{videoGameId}").
                then().log().all().
                statusCode(not(200));


    }














    }
