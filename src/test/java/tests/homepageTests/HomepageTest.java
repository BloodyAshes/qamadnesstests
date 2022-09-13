package tests.homepageTests;

import enums.Alphabets;
import enums.RandomGenerator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObject.base.BasePage;
import pageObject.pages.Homepage;
import tests.baseTest.BaseTest;

import static constatns.Constant.Urls.MADNESS_PAGE;

public class HomepageTest extends BaseTest {
    Homepage homepage;

    @BeforeMethod
    public void beforeMethod(){
        open(MADNESS_PAGE);
        homepage = new Homepage(driver);
    }

    @Test
    public void subscribeOnEmails(){
    homepage.chooseSiteVersion()
            .subscribeOnEmail(BasePage.randomGenerator(RandomGenerator.EMAIL, 7, Alphabets.EN_ALPHABET.getAlphabet()));

        Assert.assertEquals(homepage.getSuccessMessage(), "Confirmation request has been sent.");
    }
}
