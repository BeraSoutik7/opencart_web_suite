package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static testBase.BaseClass.myWait;

public class ForgetPassword extends BasePage{

    public ForgetPassword(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h1[@class='page-title h3 mb-3']")
    WebElement forgetPassTitle;

    public void waitForForgetPassTitle(){
        myWait.until(ExpectedConditions.visibilityOf(forgetPassTitle));
    }
    public String getTextForgetPasswordTitle(){
        System.out.println(forgetPassTitle.getText());
        return forgetPassTitle.getText();
    }
}
