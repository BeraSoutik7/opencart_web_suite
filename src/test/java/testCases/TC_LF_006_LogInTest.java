package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.ForgetPassword;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import testBase.BaseClass;

public class TC_LF_006_LogInTest extends BaseClass {
    @Test(groups = {"master"},description = "varify is forget password button is displayed")
    public void varifyLogin(){
        try {
            logger.info("Starting TC_LF_003_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            SoftAssert sa = new SoftAssert();
            ForgetPassword fp = new ForgetPassword(driver);

            hp.clickMyAccount();
            logger.info("Clicked on My account");

            lp.clickForgetPassword();
            fp.waitForForgetPassTitle();
            Assert.assertEquals(fp.getTextForgetPasswordTitle(),"Forgot Your Password?");
        }
        catch (Exception e){
            logger.info("Login Test failed....");
            System.out.println(e);
            Assert.assertTrue(false);


        }

        logger.info("TC_LF_006_LogInTest Finished");

    }
}
