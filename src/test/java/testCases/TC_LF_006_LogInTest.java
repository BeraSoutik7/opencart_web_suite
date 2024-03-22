package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import testBase.BaseClass;

public class TC_LF_006_LogInTest extends BaseClass {
    SoftAssert sa = new SoftAssert();
    @Test(groups = {"master"},description = "varify is forget password button is displayed")
    public void varifyLogin(){
        try {
            logger.info("Starting TC_LF_003_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            SoftAssert sa = new SoftAssert();

            hp.clickMyAccount();
            logger.info("Clicked on My account");

            boolean targetBtn = lp.isForgetPasswordDisplayed();
            if (targetBtn) {
                logger.info("Login test passed");
                sa.assertTrue(true);
            } else {
                logger.info("Login Test failed");

                sa.assertTrue(false);
            }
            lp.clickForgetPassword();
            sa.assertEquals(lp.getForgetPasswordMsg(),"Forgot Your Passwor?");
        }
        catch (Exception e){
            logger.info("Login Test failed....");
            System.out.println(e);
            sa.assertTrue(false);

        }
        sa.assertAll();
        logger.info("TC_LF_006_LogInTest Finished");

    }
}
