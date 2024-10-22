package AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.OrderPage;

import java.time.Duration;

public class AbstractReusable {
    WebDriver driver;
    public AbstractReusable(WebDriver driver) {

        this.driver = driver;
    }

    public void waitForElementToAppear(By findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForElementToDisappear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(ele));


    }
    public void waitForWebElementToAppear(WebElement findBy){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }


    @FindBy(css = "[routerlink*='cart']")
    WebElement cartButton;

    @FindBy(css = "[routerLink*='myorders']")
    WebElement orderHeader;

    public void clickOnCartButton(){
        cartButton.click();
    }

    public OrderPage goToOrdersPage(){
        orderHeader.click();
        return new OrderPage(driver);
    }
}
