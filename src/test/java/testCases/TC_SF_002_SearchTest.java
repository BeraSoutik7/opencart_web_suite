package testCases;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

import java.io.IOException;
import java.nio.file.WatchEvent;
import java.util.Properties;

public class TC_SF_002_SearchTest extends BaseClass {
    @Test(groups = {"master"},description = "Search test with non existing product ")
    public void varifySearch() throws IOException {
        try{
            SoftAssert sa = new SoftAssert();
        LogInPage logInPage = new LogInPage(driver);
        MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();
        SearchPage searchPage = myAccountPage.setSearchTxtNonEx();
        boolean target = searchPage.isNonExProductTxtExist();
        if (target) {
            sa.assertTrue(true);
        } else {
           sa.assertTrue(false);
        }
        myAccountPage.logOut();
        sa.assertAll();
    }
        catch (Exception e){
        System.out.println(e);
        Assert.assertTrue(false);
    }

    }

}
