package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchResultPage {



    public SearchResultPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[@class='lighter']")
    public WebElement searchHeader;

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    public WebElement alert;



}
