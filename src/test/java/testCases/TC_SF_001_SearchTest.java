package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_SF_001_SearchTest extends BaseClass {
    @Test(groups = {"sanity"},description = "Search Test... of one product")
    public void varifySearchTest() throws IOException {
        try {
            LogInPage logInPage = new LogInPage(driver);
            MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();
            SearchPage searchPage = myAccountPage.setSearchTxt();
            boolean target = searchPage.isProductiMacExists();
            if (target) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
        catch (Exception e){
            System.out.println(e);
            Assert.assertTrue(false);
        }
    }
}
