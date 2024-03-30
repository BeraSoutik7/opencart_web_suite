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

    @Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class,description = "Login with multiple valid and invalid credentials")
    public void varifyLogin_DDT(String email,String password, String exp){
        logger.info("Starting TC_LF_002_LoginTestDD");
        try {
            LogInPage logInPage = new LogInPage(driver);
            MyAccountPage myAccountPage = logInPage.logInWithValidCredentials(email,password);

            boolean targetPage = myAccountPage.isMyAccountPageExists();
            if(exp.equals("valid")){
                if( targetPage==true) {
                    myAccountPage.clickLogout();
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
                    myAccountPage.clickLogout();
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
