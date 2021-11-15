package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.assertj.core.api.SoftAssertions;
import static org.junit.Assert.*;
import pages.HomePage;
import pages.ProductPage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class HomepageStepDefs {


    @Then("The product names should be the following")
    public void theProductNamesShouldBeTheFollowing(List<String> expectedList) {

        List<String> actualList = SeleniumUtils.getElementsText(new HomePage().allproduct);


        assertEquals(expectedList, actualList);



    }
    @Then("The title should be {string}")
    public void theTitleShouldBe(String string) {
        assertTrue(Driver.getDriver().getTitle().equals(string));
    }


    @When("I pass this table information")
    public void iPassThisTableInformation(List<List<String>> dataTable) {

        for (List<String> row : dataTable) {
            System.out.println(row);
        }

        assertEquals(23,   Integer.parseInt(dataTable.get(1).get(3)) );

    }


    @When("I pass this table information as List of Maps")
    public void iPassThisTableInformationAsListOfMaps(List<Map<String,String>> dataTable) {

        for (Map<String, String> row : dataTable) {

            System.out.println(row);
        }

    }


    @When("I pass this table information as a Map")
    public void iPassThisTableInformationAsAMap(Map<String, String> dataTable) {
        System.out.println(dataTable);
    }
    @Then("It should be correct")
    public void itShouldBeCorrect() {

    }


    @When("I pass this table information as Map<String,List<String>>")
    public void iPassThisTableInformationAsMapStringListString(Map<String,List<String>>  dataTable) {
        System.out.println(dataTable);
    }


    @When("I pass this table information as Map<String,Map<String,String>>")
    public void iPassThisTableInformationAsMapStringMapStringString( Map<String,Map<String,String>> dataTable) {
        System.out.println(dataTable);
    }


    @Then("The details of the product should be")
    public void theDetailsOfTheProductShouldBe(List<Map<String, String>> dataTable) {

        Map<String, String> map = dataTable.get(0);
        String expectedName = map.get("Name");
        String expectedModel = map.get("Model No");
        String expectedCondition = map.get("Condition");
        String expectedDescription = map.get("Description");
        String expectedPrice = map.get("Price");
        String expectedQuantity = map.get("Quantity");

        ProductPage productPage = new ProductPage();
        SoftAssertions softAssertion = new SoftAssertions();
        softAssertion.assertThat(expectedName).isEqualTo(productPage.productName.getText());
        softAssertion.assertThat(expectedModel).isEqualTo(productPage.modelNo.getText()+623455);
        softAssertion.assertThat(expectedCondition).isEqualTo(productPage.condition.getText());
        softAssertion.assertThat(expectedDescription).isEqualTo(productPage.description.getText()) ;
        softAssertion.assertThat(expectedPrice).isEqualTo(productPage.price.getText()+12) ;
        softAssertion.assertThat(expectedQuantity).isEqualTo(productPage.quantity.getAttribute("value")) ;

        softAssertion.assertAll();



    }


//    @Then("It should {word} correct")
//    public void itShouldBeCorrect3271534214(String str) {
//
//
//    }

    //Common Cucumber exceptions -> PendingException
    // DuplicateStepDefinitionException -> happens when we have 2 identical step definition methods
    // AmbiguousStepDefinitionsException -> happens when we have multiple possible matches, for example when we use {word}
}
