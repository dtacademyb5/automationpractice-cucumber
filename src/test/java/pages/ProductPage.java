package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ProductPage {

    @FindBy(xpath = "//i[@class='icon-plus']")
    public WebElement plusButton;

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h1")
    public WebElement productName;

    @FindBy (xpath = "//span[@itemprop='sku']")
    public WebElement modelNo;

    @FindBy (xpath = "//p[@id='product_condition']//span")
    public WebElement condition;

    @FindBy (xpath = "//div[@id='short_description_content']//p")
    public WebElement description;

    @FindBy (id = "our_price_display")
    public WebElement price;

    @FindBy (id = "quantity_wanted")
    public WebElement quantity;
}
