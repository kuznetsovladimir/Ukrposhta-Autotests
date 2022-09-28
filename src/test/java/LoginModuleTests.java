import Utils.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginModuleTests {
    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open("https://ukrposhta.ua/");

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

    @Test (priority = 1)
    public void loginWithValidCreds () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();


        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.registrationPageOpened());
        logInPage.clickOnTheLogInButton();
        logInPage.fillTheEmailField(logInPage.getValidEmail());
        logInPage.fillPasswordField(logInPage.getValidPass());
        logInPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.verifyLogIn());
        logInPage.getStopSessionButton().click();

    }

    @Test (priority = 2)
    public void loginWithInvalidEmail () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.registrationPageOpened());
        logInPage.clickOnTheLogInButton();
        logInPage.fillEmailFieldInvalid(logInPage.getInvalidEmail());
        logInPage.fillPasswordField(logInPage.getValidPass());
        Assert.assertTrue(logInPage.verifyPasswordIsHidden(logInPage.getValidPass()));
        logInPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.verifyErrorMessageMail());

    }

    @Test (priority = 3)
    public void loginWithInvalidPassword () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.registrationPageOpened());
        logInPage.clickOnTheLogInButton();
        logInPage.fillTheEmailField(logInPage.getValidEmail());
        logInPage.fillPasswordFieldInvalid(logInPage.getInvalidPass());
        Assert.assertTrue(logInPage.verifyPasswordIsHidden(logInPage.getInvalidPass()));
        logInPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.verifyErrorMessagePass());

    }

    @Test (priority = 4)
    public void loginWithNoData () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.registrationPageOpened());
        logInPage.clickOnTheLogInButton();
        logInPage.clickOnTheEnterButton();
        Thread.sleep(3000);
        Assert.assertTrue(logInPage.authorizationSectionOpened());

    }
}
