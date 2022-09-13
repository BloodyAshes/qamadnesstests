package tests.baseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import webDriverFactory.WebDriverFactory;

import java.util.concurrent.TimeUnit;

import static constatns.Constant.CLEAR_COOKIES_AND_STORAGE;
import static constatns.Constant.TimeoutVariables.IMPLICIT_WAIT;
import static constatns.Constant.TimeoutVariables.PAGE_LOAD_WAIT;


public class BaseTest {

    protected WebDriver driver = null;


    @BeforeSuite
    public void setUp() {
        driver = WebDriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
    }

    @AfterTest
    public void clearCookiesAndLocalStorage() {
            if (CLEAR_COOKIES_AND_STORAGE) {
                JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
                driver.manage().deleteAllCookies();
                javascriptExecutor.executeScript("window.sessionStorage.clear()");
            }
        }

        @AfterSuite(alwaysRun = true)
        public void afterSuite(){
            if (driver !=null){
                driver.quit();
            }
        }

        public void open (String url){
            driver.navigate().to(url);
        }
    }