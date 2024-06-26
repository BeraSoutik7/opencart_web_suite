package testCases;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_001_LogInTest extends BaseClass {

    @Test(groups = {"sanity","master"},description = "Login With valid credentials")
    public void verifyLogIn(){
        try {

            LogInPage logInPage = new LogInPage(driver);

            MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();

            boolean targetPage = myAccountPage.isMyAccountPageExists();
            if (targetPage) {

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
