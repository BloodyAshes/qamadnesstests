package pageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base.BasePage;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "pass")
    private WebElement passwordInput;

    @FindBy(id = "send2")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@Class='hello']")
    private WebElement helloText;

    @FindBy(id = "advice-validate-email-email")
    private WebElement emailError;

    @FindBy(xpath = "//li[@Class='error-msg']")
    private WebElement wrongPassOrEmailError;

    @Step("Method is used for filling email input in the login form")
    public MyAccountPage fillEmailInput(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step("Method is used for filling password input in the login form")
    public MyAccountPage fillPasswordInput(String pass) {
        passwordInput.sendKeys(pass);
        return this;
    }

    @Step("Method is used for use the login button")
    public MyAccountPage pressLoginButton() {
        loginButton.click();
        return this;
    }

    @Step("Method is used for getting hello text for logged in users")
    public String getHeader(){
        return helloText.getText();
    }

    @Step("Method is used for getting text of error for email input in the login form")
    public String getEmailError(){
        return emailError.getText();
    }

    @Step("Method is used for getting text of error for password input in the login form")
    public String getWrongError(){
        return wrongPassOrEmailError.getText();
    }
}
