package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.plugin.dom.html.HTMLInputElement;
import utilities.Driver;

import java.util.List;

public class HomePage {


    @FindBy (linkText = "Sign in")
    public WebElement signInLink;

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (id = "search_query_top")
    public WebElement searchBox;

    @FindBy (xpath = "(//a[@title='Blouse'])[2]")
    public WebElement blouseLink;

    @FindBy (xpath = "//ul[@id='homefeatured']//a[@class='product-name']")
    public List<WebElement> allproduct;







    public void clickOnProduct(String name){
       String xpath =  "(//a[@title='" + name +  "'])[2]";
       Driver.getDriver().findElement(By.xpath(xpath)).click();
    }


}
