package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.*;
import testBase.BaseClass;

import java.io.IOException;

public class TC_PC_001_ProductCompare extends BaseClass {
    @Test(groups = {"master"},description = "Product compare test cases")
    public void varifyProductCompare() throws IOException {
        LogInPage logInPage = new LogInPage(driver);
        SoftAssert sa = new SoftAssert();
        MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();
        SearchPage searchPage = myAccountPage.setSearchTxt();
        ProductDisplayPage productDisplayPage = searchPage.clickProduct();
        if(productDisplayPage.getTextCompareThisProMsg().equalsIgnoreCase("Compare This Product")){
            productDisplayPage.clickCompareThisProduct();
            sa.assertTrue(true);
        }
        else{
            sa.assertTrue(false);
        }

        ProductComparePage productComparePage = searchPage.clickProductCompare1();

        if (productComparePage.isProductExist()){
            productComparePage.removeProductFromProductCompare();
            sa.assertTrue(true);
        }
        else {
            sa.assertTrue(false);
        }
        sa.assertAll();
    }
}
