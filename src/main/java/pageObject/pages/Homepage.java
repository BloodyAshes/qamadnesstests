package pageObject.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.base.BasePage;

public class Homepage extends BasePage {
    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement myAccountPage;

    @FindBy(xpath = "//a[@href='http://testing-com.qamadness.com/en/switch/index/index/']")
    private WebElement englishSite;

    @FindBy(id = "newsletter")
    private WebElement subscribeInput;

    @FindBy(xpath = "//button[@title='Subscribe']")
    private WebElement subscribeButton;

    @FindBy(xpath = "//li[@Class='success-msg']")
    private WebElement successMessage;

    public MyAccountPage navigateToMyAccountPage(){
        myAccountPage.click();
        return new MyAccountPage(this.driver);
    }

    @Step("Method is used for choosing site version")
    public Homepage chooseSiteVersion(){
        try {
            englishSite.click();
        }catch (NoSuchElementException e){
            return this;
        }
        return this;
    }

    @Step("Method is used for apply subscribe on email texts")
    public Homepage subscribeOnEmail(String email){
        subscribeInput.sendKeys(email);
        subscribeButton.click();
        return this;
    }

    @Step("Method is used for getting successful message")
    public String getSuccessMessage(){
        return successMessage.getText();
    }

}
