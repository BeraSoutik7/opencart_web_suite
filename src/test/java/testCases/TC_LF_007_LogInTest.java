package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_007_LogInTest extends BaseClass {
    @Test(groups = {"master"}, description = "Validate logging into the Application using Keyboard keys (Tab and Enter)")
    public void verifyLogIn(){
        try {

            logger.info("Starting TC_LF_007_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            MyAccountPage ma = new MyAccountPage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on My account");

            lp.setTxtEmail(p.getProperty("email"));
            logger.info("Entered Email");

            lp.setTxtPassword(p.getProperty("password"));
            logger.info("Entered Password");

            for (int i = 0; i < 2; i++) {
                pressTab();
            }
            pressEnter();

            boolean targetPage = ma.isMyAccountPageExists();
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
            Assert.assertTrue(false);
        }
        logger.info("TC_LF_001_LogInTest Finished");

    }
}
