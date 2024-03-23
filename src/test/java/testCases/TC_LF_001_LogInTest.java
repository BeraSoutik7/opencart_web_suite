package testCases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_001_LogInTest extends BaseClass {
    @Test(groups = {"sanity","master"})
    public void verifyLogIn(){
        try {


            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            MyAccountPage ma = new MyAccountPage(driver);

            hp.clickMyAccount();

            lp.setTxtEmail(p.getProperty("email"));


            lp.setTxtPassword(p.getProperty("password"));


            lp.clickLogInBtn();


            boolean targetPage = ma.isMyAccountPageExists();
            if (targetPage) {

                Assert.assertTrue(true);
            } else {

                Assert.assertTrue(false);
            }
        }
        catch (Exception e){
            Assert.assertTrue(false);
        }
        test.log(Status.INFO,"Test end");

    }
}
