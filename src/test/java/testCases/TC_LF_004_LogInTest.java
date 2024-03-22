package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_004_LogInTest extends BaseClass {
    @Test(groups = {"master"}, description = "varify login valid email and invalid password ")
    public void varifyLogin(){
        try {
            logger.info("Starting TC_LF_003_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on My account");

            lp.setTxtEmail(p.getProperty("email"));
            logger.info("Entered Email");

            lp.setTxtPassword(p.getProperty("invalidpassword"));
            logger.info("Entered Password");

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
