package pageObjects;

import AbstractComponent.AbstractReusable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckOutPage extends AbstractReusable {
    WebDriver driver;
    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver =driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".cartSection h3")
    List<WebElement> cartProducts;

    @FindBy(css = ".subtotal button")
    WebElement checkoutButton;

    @FindBy(xpath = "//input[@placeholder='Select Country']" )
    WebElement countryPlaceholder;



    @FindBy(xpath = "(//button[contains(@class, 'ta-item')])[2]")
     WebElement selectIndia;

    @FindBy(css = ".action__submit")
     WebElement placeOrderButton;

    @FindBy(css = ".hero-primary")
            WebElement finalAf;



    By countryTable = (By.cssSelector(".ta-results"));


    public boolean verifyListOfCartProducts(String productName){
        return cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
    }

    public void ClickOnCheckOutButton(){
        checkoutButton.click();

    }

    public void selectCountry(String countryName){
        Actions a = new Actions(driver);
        countryPlaceholder.sendKeys(countryName);
        waitForElementToAppear(countryTable);
        selectIndia.click();

    }

    public void placeOrder(){
        placeOrderButton.click();

    }

    public String confirmOrder(){
        return finalAf.getText();

    }
}
