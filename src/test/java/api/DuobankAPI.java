package api;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DuobankAPI {


    @BeforeClass
    public static void setup(){
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }


    @Test
    public void testAPItoUIFlow(){


        // Create a user through the register API endpoint
        String email = new Faker().internet().emailAddress();
        String password = "bendydendy";

        given().
                body("{\n" +
                        "    \"first_name\" : \"BENDY\",\n" +
                        "\"last_name\" : \"DENDY\",\n" +
                        "\"email\" : \""+ email+"\",\n" +
                        "\"password\" : \""+password+"\"\n" +
                        "\n" +
                        "}").
        when().
                post("/register.php").
                then().
                statusCode(200);



         // Verify the new user creation by logging in with the same details thru the UI

        Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");

        Driver.getDriver().findElement(By.id("exampleInputEmail1")).sendKeys(email);
        Driver.getDriver().findElement(By.id("exampleInputPassword1")).sendKeys(password + Keys.ENTER);

        Assert.assertEquals("http://qa-duobank.us-east-2.elasticbeanstalk.com/dashboard.php",
                Driver.getDriver().getCurrentUrl());


        Driver.getDriver().quit();




    }
}
