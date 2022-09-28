import Utils.WebDriverFactory;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import ua.ukrposhta.Pages.PersonalAccountPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PersonalAccountPageTests {

    @BeforeMethod
    public void setUp () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");

        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        if(acceptCookiesButton.isDisplayed())
        {acceptCookiesButton.click();}
        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        logInPage.clickOnTheLogInButton();

        Thread.sleep(3000);

    }

    @Test (priority = 1)
    public void sidebarNavigation () {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        Assert.assertEquals(personalAccountPage.sideBarList(), personalAccountPage.sideBarListExpected());
        personalAccountPage.clickOnTheExpandButton();
        Selenide.sleep(3000);
        Assert.assertEquals(personalAccountPage.expressList(), personalAccountPage.expressListExpected());
        personalAccountPage.clickOnTheInstructionLink();
        Selenide.sleep(3000);
        Assert.assertEquals(personalAccountPage.getContactCenterHeader(), personalAccountPage.getContactCenterHeaderExpected());

    }

}
