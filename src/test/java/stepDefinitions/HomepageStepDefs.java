package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.HomePage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class HomepageStepDefs {


    @Then("The product names should be the following")
    public void theProductNamesShouldBeTheFollowing(List<String> expectedList) {

        List<String> actualList = SeleniumUtils.getElementsText(new HomePage().allproduct);


        Assert.assertEquals(expectedList, actualList);



    }
    @Then("The title should be {string}")
    public void theTitleShouldBe(String string) {
        Assert.assertTrue(Driver.getDriver().getTitle().equals(string));
    }


    @When("I pass this table information")
    public void iPassThisTableInformation(List<List<String>> dataTable) {

        for (List<String> row : dataTable) {
            System.out.println(row);
        }

        Assert.assertEquals(23,   Integer.parseInt(dataTable.get(1).get(3)) );

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


//    @Then("It should {word} correct")
//    public void itShouldBeCorrect3271534214(String str) {
//
//
//    }

    //Common Cucumber exceptions -> PendingException
    // DuplicateStepDefinitionException -> happens when we have 2 identical step definition methods
    // AmbiguousStepDefinitionsException -> happens when we have multiple possible matches, for example when we use {word}
}
