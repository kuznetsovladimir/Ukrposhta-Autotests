import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import ua.ukrposhta.Pages.PersonalAccountPage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class PersonalAccountPageTests extends TestData {

    @BeforeMethod
    public void setUp () throws InterruptedException {
        HomePage homePage = new HomePage();
        LogInPage logInPage = new LogInPage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        Waiter waiter = new Waiter();

        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");

        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        if(acceptCookiesButton.isDisplayed())
        {acceptCookiesButton.click();}
        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
    }

    @Test (priority = 1)
    public void sidebarNavigation () {
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();
        Waiter waiter = new Waiter();

        Assert.assertEquals(personalAccountPage.sideBarList(), personalAccountPage.sideBarListExpected());
        personalAccountPage.clickOnTheExpandButton();
        waiter.waitForVisibility(personalAccountPage.getExpandedSection());
        Assert.assertEquals(personalAccountPage.expressList(), personalAccountPage.expressListExpected());
        personalAccountPage.clickOnTheInstructionLink();
        waiter.waitForVisibility(personalAccountPage.getContactCenterHeader());
        Assert.assertEquals(personalAccountPage.getContactCenterHeaderText(), CONTACT_CENTER_EXPECTED_HEADER);

    }

}
