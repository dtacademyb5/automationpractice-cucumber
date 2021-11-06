package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

import java.time.Duration;

public class Hooks {


    @Before   //@Before ("@ui")
    public void setupScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();

    }


    @Before ("@db")
    public void setupScenarioDb(){
        System.out.println("Connect to DB");

    }

    @After ("@db")
    public void tearDownScenarioDb(){
        System.out.println("Close the connection DB");

    }




    @After
    public void tearDownScenario(Scenario scenario){

         if(scenario.isFailed()){

             byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

             scenario.attach(screenshot, "image/png", "failed");

         }

        Driver.quitDriver();
    }




}
