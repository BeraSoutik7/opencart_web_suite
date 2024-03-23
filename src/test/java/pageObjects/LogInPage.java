package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage{

    public LogInPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmail;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement logInBtn;
    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMsg;
    @FindBy(xpath = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
    WebElement forgetPassword;


    public void setTxtEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void clickLogInBtn(){
        logInBtn.click();
    }
    public boolean isWarningDisplayed(){
        return warningMsg.isDisplayed();
    }
    public void clickForgetPassword(){
        forgetPassword.click();
    }

    public String getPlaceHolderEmail(){
        return txtEmail.getAttribute("placeholder");
    }
    public String getPlaceHolderPassword(){
        return txtPassword.getAttribute("placeholder");
    }

}
