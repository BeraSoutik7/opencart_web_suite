package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_005_LogInTest extends BaseClass {
    @Test(groups = {"master"}, description ="varify login without email and password")
    public void varifyLogin(){
        try {
            logger.info("Starting TC_LF_003_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on My account");

            lp.clickLogInBtn();
            logger.info("Clicked on log in button");

            boolean targetPage = lp.isWarningDisplayed();
            if (targetPage) {
                logger.info("Login test passed");
                Assert.assertTrue(true);
            } else {
                logger.info("Login Test failed");

                Assert.assertTrue(false);
            }
        }
        catch (Exception e){
            logger.info("Login Test failed....");
            System.out.println(e);
            Assert.assertTrue(false);
        }
        logger.info("TC_LF_001_LogInTest Finished");

    }
}
