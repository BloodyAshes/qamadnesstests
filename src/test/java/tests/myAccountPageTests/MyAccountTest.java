package tests.myAccountPageTests;

import enums.Alphabets;
import enums.RandomGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.base.BasePage;
import pageObject.pages.Homepage;
import pageObject.pages.MyAccountPage;
import tests.baseTest.BaseTest;

import static constatns.Constant.Urls.MADNESS_PAGE;

public class MyAccountTest extends BaseTest {
    Homepage homepage;
    MyAccountPage myAccountPage;


    @BeforeMethod
    public void beforeMethod(){
        open(MADNESS_PAGE);
        homepage = new Homepage(driver);
        myAccountPage = new MyAccountPage(driver);
    }

    @DataProvider(name = "data")
    public Object[][] data(){
        return new Object[][]{
                {"oleg@gmail.com", "A123321"}
        };
    }

    @Owner(value = "Vlad Matsenko")
    @Description(value = "Check that user should be able to login in with valid login and password")
    @Test(dataProvider = "data")
    public void successfulLogin(String email, String password){
    homepage.chooseSiteVersion()
            .navigateToMyAccountPage()
            .fillEmailInput(email)
            .fillPasswordInput(password)
            .pressLoginButton();

        Assert.assertTrue(myAccountPage.getHeader().contains("Hello,"));
    }


    @DataProvider(name = "validation")
    public Object[][] validation(){
        return new Object[][]{
                {BasePage.getRandomWord(8, Alphabets.EN_ALPHABET.getAlphabet())},
                {BasePage.getRandomWord(8, Alphabets.RU_ALPHABET.getAlphabet())},
                {BasePage.getRandomWord(8, Alphabets.NUMBERS.getAlphabet())},
                {BasePage.getRandomWord(8, Alphabets.SPECIAL_SYMBOLS.getAlphabet())}
        };
    }

    @Owner(value = "Vlad Matsenko")
    @Description(value = "Verify validation for email input in the login form")
    @Test(dataProvider = "validation")
    public void emailValidation(String email){
        homepage.chooseSiteVersion()
                .navigateToMyAccountPage()
                .fillEmailInput(email)
                .pressLoginButton();

        Assert.assertEquals(myAccountPage.getEmailError(), "Please enter a valid email address. For example johndoe@domain.com.");
    }


    @Owner(value = "Vlad Matsenko")
    @Description(value = "Check that it's impossible to login in with wrong password")
    @Test
    public void loginWithWrongPassword(){
        homepage.chooseSiteVersion()
                .navigateToMyAccountPage()
                .fillEmailInput("oleg@gmail.com")
                .fillPasswordInput(BasePage.randomGenerator(RandomGenerator.PASSWORD, 7, Alphabets.EN_ALPHABET.getAlphabet()))
                .pressLoginButton();

        Assert.assertEquals(myAccountPage.getWrongError(), "Invalid login or password.");
    }
}
