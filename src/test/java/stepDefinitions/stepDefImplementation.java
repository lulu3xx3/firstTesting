package stepDefinitions;

import VarunHasToWork.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.ProductCatalogue;


public class stepDefImplementation {

    public LandingPage landingPage;

    WebDriver driver;

    @Given("I landed on Ecommerce Page")
    public void start(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client");
        landingPage = new LandingPage(driver);
        //no need of this println command bro.
        System.out.println("what the bro");


    }

    @When("Logged in with username {} and password {}")
    public void loggedInWithUsernameAndPassword(String arg0, String arg1) {
        landingPage.loginApplication(arg0,arg1);
        System.out.println("what the bro");

    }


    @Then("{string} is to be displayed")
    public void isToBeDisplayed(String arg0) {
        Assert.assertEquals(arg0,landingPage.getErrorMessage());
        driver.close();
        System.out.println("what the bro");
        System.out.println("what the bro");

    }
}
