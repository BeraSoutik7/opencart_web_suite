package pageObjects;

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
    @FindBy(xpath = "//h1[@class='page-title h3 mb-3']")
    WebElement forgetPasswordMsg;
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
    public boolean isForgetPasswordDisplayed(){
        return forgetPassword.isDisplayed();
    }
    public void clickForgetPassword(){
        forgetPassword.click();
    }
    public String getForgetPasswordMsg(){
       return  forgetPasswordMsg.getText();
    }
}
