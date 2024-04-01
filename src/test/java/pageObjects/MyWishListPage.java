package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends BasePage{
    public MyWishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[normalize-space()='iMac']")
    WebElement productMyWish;
    @FindBy(xpath = "//i[@class='fa fa-times']")
    WebElement removeFromList;

    public String txtProductMyWishList(){
        return productMyWish.getText();
    }
    public void removeProductFromList(){
        removeFromList.click();
    }
}
