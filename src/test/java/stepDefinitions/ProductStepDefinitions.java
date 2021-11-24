package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.ProductPage;
import utilities.Driver;

import java.util.List;
import java.util.Map;

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


    @When("I click on plus button {int} times")
    public void iClickOnPlusButtonTimes(Integer times) {

        ProductPage productPage = new ProductPage();

        for (int i = 0; i < times; i++) {
            productPage.plusButton.click();
        }



    }
    @Then("The value must become {int}")
    public void theValueMustBecome(Integer expected) {

        Integer inputBoxText = Integer.valueOf(new ProductPage().quantity.getAttribute("value"));
        Assert.assertEquals(expected, inputBoxText);
    }


    @Then("The product details should be")
    public void theProductDetailsShouldBe(List<Map<String, String>> list) {

        Map<String, String> expectedData = list.get(0);
        ProductPage productPage = new ProductPage();

        Assert.assertEquals(expectedData.get("Product"), productPage.productName.getText());
        Assert.assertEquals(expectedData.get("Model"), productPage.modelNo.getText());
        Assert.assertEquals(expectedData.get("Price"), productPage.price.getText().substring(1));
        Assert.assertEquals(expectedData.get("Quantity"), productPage.quantity.getAttribute("value"));
        Assert.assertEquals(expectedData.get("Condition"), productPage.condition.getText());

    }





}
