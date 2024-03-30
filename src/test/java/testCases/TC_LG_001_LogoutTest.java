package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_LG_001_LogoutTest extends BaseClass {

    @Test(groups = {"master"},description = "Logout test")
    public void varifyLogout() throws IOException {
        try {
            LogInPage logInPage = new LogInPage(driver);
            MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();

            myAccountPage.logOut();
            boolean target = myAccountPage.isLogoutTextExist();
            if(target) {
                Assert.assertTrue(true);
            }
            else{
                Assert.assertTrue(false);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }
    }

}
