package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import pageObjects.MyWishListPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

import java.io.IOException;

public class TC_WL_001_WishList extends BaseClass {
    @Test(groups = "{master}", description = "My wish list test")
    public void varifyMyWishList() throws IOException {
        LogInPage logInPage = new LogInPage(driver);

        MyAccountPage myAccountPage = logInPage.logInWithValidCredentials();

        SearchPage searchPage = myAccountPage.setSearchTxt();
        searchPage.clickWishlist();
        MyWishListPage myWishListPage = searchPage.openWishList();
        if(myWishListPage.txtProductMyWishList().equalsIgnoreCase("imac")){
            Assert.assertTrue(true);
            myWishListPage.removeProductFromList();
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
