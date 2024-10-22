package pageObjects;


import VarunHasToWork.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ErrorValidationsTest extends BaseTest {

    @Test(groups = {"errorHandling"})
    public void wrongEmailPasswordValidation() throws IOException {



        landingPage.loginApplication("zlanirinisd6559@xmail.com","k?x;?d+$3sa6;c8Ay");

        Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());

    }

    @Test(retryAnalyzer = retry.class)
    public void correctValidation() throws IOException {

        landingPage.loginApplication("zlanirini69@xmail.com","k?x;?d+$36;c8Ay");
        String productName = "ZARA COAT 3";
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.addProductToCart(productName);
        landingPage.clickOnCartButton();
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        boolean match = checkOutPage.verifyListOfCartProducts("ZARA COAT 33");
        Assert.assertFalse(match);

    }



}


