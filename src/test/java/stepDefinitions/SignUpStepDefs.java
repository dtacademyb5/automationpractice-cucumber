package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

public class SignUpStepDefs {


    @When("I click on Sign in")
    public void iClickOnSignIn() {

        new HomePage().signInLink.click();
    }
    @When("I enter the valid email address {string}")
    public void iEnterTheValidEmailAddress(String email) {
        LoginPage loginPage = new LoginPage();

        loginPage.emailInputBox.sendKeys(email);
        loginPage.createEmailButton.click();

    }
    @Then("I should be able to land on registration page")
    public void iShouldBeAbleToLandOnRegistrationPage() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Login"));
    }
}
