package dude;


import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LandingPage;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client/");
        LandingPage landingPage = new LandingPage(driver);
        String productName = "ZARA COAT 3";
        driver.findElement(By.id("userEmail")).sendKeys("zlanirini69@xmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("k?x;?d+$36;c8Ay");
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
        List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
        WebElement prod = products.stream()
                .filter(product -> product.findElement(By.cssSelector("b")).getText()
                        .equals("ZARA COAT 3")).findFirst().orElse(null);
        assert prod != null;
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
        driver.findElement(By.cssSelector("[routerlink*='cart']")).click();

        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart h3"));

        boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.cssSelector(".subtotal button")).click();
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")), "india").build().perform();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
        driver.findElement(By.cssSelector(".action__submit")).click();
        String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        driver.close();





    }


}


