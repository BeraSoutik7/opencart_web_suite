package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_008_LogInTest extends BaseClass {
    SoftAssert sa;
    @Test(groups = {"master"}, description = "Validate E-Mail Address and Password text fields in the Login page have the place holder text ")
    public void verifyLogIn(){
        try {

            logger.info("Starting TC_LF_007_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            MyAccountPage ma = new MyAccountPage(driver);
            sa = new SoftAssert();
            hp.clickMyAccount();
            logger.info("Clicked on My account");

            sa.assertEquals(lp.getPlaceHolderEmail(),"E-Mail Address");
            sa.assertEquals(lp.getPlaceHolderPassword(),"Password");

        }
        catch (Exception e){
            logger.info("Login Test failed....");
            sa.assertTrue(false);
        }
        sa.assertAll();
        logger.info("TC_LF_001_LogInTest Finished");

    }
}
