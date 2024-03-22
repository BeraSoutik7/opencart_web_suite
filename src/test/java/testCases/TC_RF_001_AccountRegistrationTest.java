package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC_RF_001_AccountRegistrationTest extends BaseClass{

    @Test(groups = {"regression","master"})
    public void verifyAccountRegistration() {
        logger.debug("Application log started.....");
        try {
            logger.info("*******Starting TC_RF_001_AccountRegistrationTest*******");
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("*******Clicked on My Account*******");
            hp.clickRegister();
            logger.info("*******Clicked on Register*******");

            RegisterPage rp = new RegisterPage(driver);
            logger.info("*******Entering customer information*******");
            rp.setTxtFirstName(generateName());
            rp.setTxtLastName(generateName());
            rp.setTxtEmail(generateEmail());
            rp.setTxtTelephone(generatePhnNum());
            String pass = generatePassword();
            rp.setTxtPassword(pass);
            rp.setTxtConfirmPassword(pass);
            rp.clickCheckBox();
            rp.pressButton();
            logger.info("******clicked on continue******");
            logger.info("*******Validating Expected message*******");
            if(rp.getRegistrationMsg().equals("Your Account Has Been Created!")){
                logger.info("Test  is passed");
                Assert.assertTrue(true);
            }
            else {
                logger.error("Test is failed");
                Assert.assertTrue(false);

            }
            logger.info("*******Validating Expected message*******");
        }
        catch (Exception e){
            logger.error("Test case failed...");
            Assert.fail();
        }
        logger.debug("Application log ended.....");
        logger.info("*******TC_RF_001_AccountRegistrationTest Finished*******");
    }
}
