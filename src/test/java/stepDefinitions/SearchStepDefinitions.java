package stepDefinitions;

import io.cucumber.java.en.Given;
import utilities.ConfigReader;
import utilities.Driver;

public class SearchStepDefinitions {





    @Given("I am on the homepage")
    public void i_am_on_the_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
}
