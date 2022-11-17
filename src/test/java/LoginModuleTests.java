import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginModuleTests extends TestData {
    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        if(acceptCookiesButton.isDisplayed())
        {acceptCookiesButton.click();}

    }


    @Test (priority = 1)
    public void loginWithValidCreds () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        logInPage.fillTheEmailField(VALID_EMAIL);
        logInPage.fillPasswordField(VALID_PASS);
        logInPage.clickOnTheEnterButton();
        waiter.waitForVisibility(logInPage.getStopSessionButton());
        logInPage.getStopSessionButton().click();

    }

    @Test (priority = 2)
    public void loginWithInvalidEmail () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        logInPage.fillEmailFieldInvalid(INVALID_EMAIL);
        logInPage.fillPasswordField(VALID_PASS);
        Assert.assertTrue(logInPage.verifyPasswordIsHidden(VALID_PASS));
        logInPage.clickOnTheEnterButton();
        waiter.waitForVisibility(logInPage.getErrorMessageMail());
        Assert.assertTrue(logInPage.verifyErrorMessageMail());

    }

    @Test (priority = 3)
    public void loginWithInvalidPassword () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        waiter.waitForVisibility(logInPage.getAuthorizationHeader());
        logInPage.fillTheEmailField(VALID_EMAIL);
        logInPage.fillPasswordFieldInvalid(INVALID_PASS);
        Assert.assertTrue(logInPage.verifyPasswordIsHidden(INVALID_PASS));
        logInPage.clickOnTheEnterButton();
        waiter.waitForVisibility(logInPage.getErrorMessagePass());
        Assert.assertTrue(logInPage.verifyErrorMessagePass());

    }

    @Test (priority = 4)
    public void loginWithNoData () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        waiter.waitForVisibility(logInPage.getAuthorizationHeader());
        logInPage.clickOnTheEnterButton();
        Assert.assertTrue(logInPage.authorizationSectionOpened());

    }
}
