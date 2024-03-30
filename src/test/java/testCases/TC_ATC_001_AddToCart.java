package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import testBase.BaseClass;

import java.io.IOException;

public class TC_ATC_001_AddToCart extends BaseClass {

    @Test(groups = "master", description = "Add to cart test")
    public void varifyAddToCart() throws IOException {
        SoftAssert sa = new SoftAssert();

        LogInPage logInPage = new LogInPage(driver);

        MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();

        SearchPage searchPage = myAccountPage.setSearchTxt();

        ProductDisplayPage productDisplayPage = searchPage.clickProduct();

        productDisplayPage.clickAddToCartBtn();

       ShoppingCartPage shoppingCartPage = productDisplayPage.clickViewCart();

       if(shoppingCartPage.txtMsgShoppingCartProduct().equalsIgnoreCase("imac")){
           sa.assertTrue(true);
       }
       else{
           sa.assertTrue(false);
       }
       shoppingCartPage.removeProductFromCart();
       if(shoppingCartPage.txtEmptyMsg().equalsIgnoreCase("Your shopping cart is empty!")){
           sa.assertTrue(true);
       }
       else{
           sa.assertTrue(false);
       }
        sa.assertAll();

    }

}
