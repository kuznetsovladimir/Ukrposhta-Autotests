import Utils.WebDriverFactory;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class LoginModuleTests {
    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("");
        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        acceptCookiesButton.click();
    }

    /*@Test
    public void resetPassword () throws InterruptedException {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        HomePage homePage = new HomePage();
        BrowserActions browser = new BrowserActions();
        GmailLoginPage gmail = new GmailLoginPage();
        /*homePage.clickOnTheRegistrationButton();
        Thread.sleep(2000);
        Assert.assertTrue(personalAccountPage.registrationPageOpened());
        personalAccountPage.clickOnTheLogInButton();
        personalAccountPage.clickOnTheForgotPasswordButton();
        Thread.sleep(2000);
        Assert.assertTrue(personalAccountPage.forgotPasswordSectionOpened());
        personalAccountPage.fillTheEmailField();
        personalAccountPage.clickOnTheGetNewPassButton();
        Thread.sleep(1500);
        Assert.assertTrue(personalAccountPage.checkMailboxMessageDisplayed());
        Thread.sleep(3000);
        browser.openNewTab();
        Thread.sleep(2000);
        Assert.assertTrue(gmail.checkEmailInsertSectionOpened());
        gmail.fillEmailField();
        gmail.clickOnTheNextButton();
        Thread.sleep(3000);
        gmail.againButton.click();
        Thread.sleep(5000);
    }*/

    @Test
    public void loginWithValidCreds () throws InterruptedException {
        HomePage homePage = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.registrationPageOpened());
        personalAccountPage.clickOnTheLogInButton();
        personalAccountPage.fillTheEmailField();
        personalAccountPage.fillPasswordField();
        personalAccountPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.verifyLogIn());

    }

    @Test
    public void loginWithInvalidEmail () throws InterruptedException {
        HomePage homePage = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.registrationPageOpened());
        personalAccountPage.clickOnTheLogInButton();
        personalAccountPage.fillEmailFieldInvalid();
        personalAccountPage.fillPasswordField();
        Assert.assertTrue(personalAccountPage.verifyPasswordIsHidden(personalAccountPage.getValidPass()));
        personalAccountPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.verifyErrorMessageMail());

    }

    @Test
    public void loginWithInvalidPassword () throws InterruptedException {
        HomePage homePage = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.registrationPageOpened());
        personalAccountPage.clickOnTheLogInButton();
        personalAccountPage.fillTheEmailField();
        personalAccountPage.fillPasswordFieldInvalid();
        Assert.assertTrue(personalAccountPage.verifyPasswordIsHidden(personalAccountPage.getInvalidPass()));
        personalAccountPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.verifyErrorMessagePass());

    }

    @Test
    public void loginWithNoData () throws InterruptedException {
        HomePage homePage = new HomePage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.registrationPageOpened());
        personalAccountPage.clickOnTheLogInButton();
        personalAccountPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(personalAccountPage.authorizationSectionOpened());

    }
}
