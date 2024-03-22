package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_LF_002_LoginTestDD extends BaseClass {

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
    public void varifyLogin_DDT(String email,String password, String exp){
        logger.info("Starting TC_LF_002_LoginTestDD");
        try {
            logger.info("Starting TC_LF_001_LogInTest");
            HomePage hp = new HomePage(driver);
            LogInPage lp = new LogInPage(driver);
            MyAccountPage ma = new MyAccountPage(driver);

            hp.clickMyAccount();
            logger.info("Clicked on My account");

            lp.setTxtEmail(email);
            logger.info("Entered Email");

            lp.setTxtPassword(password);
            logger.info("Entered Password");

            lp.clickLogInBtn();
            logger.info("Clicked on log in button");

            boolean targetPage = ma.isMyAccountPageExists();
            if(exp.equals("valid")){
                if( targetPage==true) {
                    ma.clickLogout();
                    logger.info("Login Test passed....");
                    Assert.assertTrue(true);
                }
                else{
                    logger.info("Login Test failed....");
                    Assert.assertTrue(false);
                }
            }
            if(exp.equals("invalid")){
                if(targetPage==true){
                    ma.clickLogout();
                    logger.info("Login Test failed....");
                    Assert.assertTrue(false);
                }
                else{
                    logger.info("Login Test passed....");
                    Assert.assertTrue(true);
                }
            }
        }
        catch (Exception e){
            logger.info("Login Test failed....");
            Assert.assertTrue(false);
        }
        logger.info("Finished TC_LF_002_LoginTestDD");

    }

}
