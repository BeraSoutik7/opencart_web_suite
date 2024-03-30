package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_009_LogInTest extends BaseClass {
    SoftAssert sa;
    @Test(groups = {"master"}, description = "Validate Logging into the Application and browsing back using Browser back button")
    public void verifyLogIn(){
        try {

            logger.info("Starting TC_LF_001_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            MyAccountPage ma = new MyAccountPage(driver);
            sa = new SoftAssert();
            hp.clickMyAccount();
            logger.info("Clicked on My account");


            lp.setTxtEmail(p.getProperty("email"));
            logger.info("Entered Email");

            lp.setTxtPassword(p.getProperty("password"));
            logger.info("Entered Password");

            lp.clickLogInBtn();
            logger.info("Clicked on log in button");

            boolean targetPage = ma.isMyAccountPageExists();
            if (targetPage) {
                logger.info("Login test passed");
                sa.assertTrue(true);
            } else {
                logger.info("Login Test failed");
                sa.assertTrue(false);
            }

            pressBack();
            Thread.sleep(5000);
            sa.assertEquals(getTitle(),"Your Store");


        }
        catch (Exception e){
            logger.info("Login Test failed....");
            sa.assertTrue(false);
        }
        sa.assertAll();
        logger.info("TC_LF_001_LogInTest Finished");

    }
}
