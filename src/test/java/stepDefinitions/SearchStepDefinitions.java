package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.SearchResultPage;
import utilities.ConfigReader;
import utilities.Driver;

public class SearchStepDefinitions {




    String searchTerm;

    @Given("I am on the homepage")
    public void i_a_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("I enter a product name on to the search and hit enter")
    public void i_enter_a_product_name_on_to_the_search_and_hit_enter() throws InterruptedException {
        HomePage homePage = new HomePage();
        searchTerm = "blouse";
        homePage.searchBox.sendKeys(searchTerm,  Keys.ENTER);
        Thread.sleep(3000);
    }
    @Then("The results page should contain the search term")
    public void the_results_page_should_contain_the_search_term() {
        SearchResultPage searchResultPage = new SearchResultPage();

        Assert.assertTrue(searchResultPage.searchHeader.getText().contains(searchTerm.toUpperCase()));


    }

    @When("I leave the search term empty and click search")
    public void i_leave_the_search_term_empty_and_click_search() {
        HomePage homePage = new HomePage();

        homePage.searchBox.sendKeys("",  Keys.ENTER);
    }
    @Then("The results page should have the warning message")
    public void the_results_page_should_have_the_warning_message() {

        Assert.assertTrue(new SearchResultPage().alert.isDisplayed());
    }


    @When("I pass invalid search term to the search bar and click")
    public void i_pass_invalid_search_term_to_the_search_bar_and_click() {
        HomePage homePage = new HomePage();
        searchTerm = ")))'''''''/////";
        homePage.searchBox.sendKeys(searchTerm,  Keys.ENTER);
    }
    @Then("The results page should not have any results with the warning message")
    public void the_results_page_should_not_have_any_results_with_the_warning_message() {
          Assert.assertTrue(new SearchResultPage().alert.getText().contains("No results were found for your search"));
    }





}
