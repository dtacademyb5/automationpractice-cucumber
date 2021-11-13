package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utilities.Driver;

public class ProductStepDefinitions {



    @When("I click on a Blouse")
    public void iClickOnABlouse() throws InterruptedException {
          new HomePage().blouseLink.click();
          Thread.sleep(2000);

    }
    @Then("I should land on Blouse page and see its details")
    public void iShouldLandOnBlousePageAndSeeItsDetails() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Blouse"));
    }

    @When("I click on a {string}")
    public void iClickOnA(String productName) {
        new HomePage().clickOnProduct(productName);

    }
    @Then("I should land on {string} page and see its details")
    public void iShouldLandOnPageAndSeeItsDetails(String productName) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(productName));
    }


    @Given("I have {int} {string}")
    public void iHave(Integer int1, String string) {
        System.out.println(int1);
        System.out.println(string);
    }
    @When("I add {double} on top")
    public void iAddOnTop(Double double1) {
        System.out.println(double1);
    }
    @Then("I should have {double} {string}")
    public void iShouldHave(Double double1, String string) {
        System.out.println(double1);
        System.out.println(string);
    }


    @When("I send the following text")
    public void iSendTheFollowingText(String docString) {
        System.out.println(docString);
    }






}
