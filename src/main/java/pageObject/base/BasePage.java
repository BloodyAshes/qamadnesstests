package pageObject.base;

import enums.RandomGenerator;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;

import static constatns.Constant.TimeoutVariables.EXPLICIT_WAIT;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public WebElement waitElementIsVisible(WebElement element){
        new WebDriverWait(driver, EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    @Step("Generated random data for inputs")
    public static String randomGenerator(RandomGenerator option, int symbols, String alphabet) {
        String random = "";
        switch (option) {
            case PASSWORD:{
                return random = getRandomWord(symbols, alphabet);
            }
            case EMAIL: {
                return random = getRandomWord(symbols, alphabet) + "@gmail.com";
            }
        }
        return null;
    }

    @Step("Method is used for generate random string")
    public static String getRandomWord(int length, String alphabet) {
        StringBuilder sb = new StringBuilder(Math.max(length, 16));
        SecureRandom RND = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int len = alphabet.length();
            int random = RND.nextInt(len);
            char c = alphabet.charAt(random);
            sb.append(c);
        }
        return sb.toString();
    }
}
