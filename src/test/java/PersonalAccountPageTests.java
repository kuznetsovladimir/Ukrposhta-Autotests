import Utils.ArraysComparison;
import Utils.WebDriverFactory;
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
        driver.GetDriver("CHROME");

        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        acceptCookiesButton.click();

        homePage.clickOnTheRegistrationButton();
        Thread.sleep(3000);
        logInPage.clickOnTheLogInButton();
        logInPage.fillTheEmailField(personalAccountPage.getEmail());
        logInPage.fillPasswordField(personalAccountPage.getPassword());
        logInPage.clickOnTheEnterButton();
        Thread.sleep(3000);

    }

    @Test
    public void sidebarNavigation () {
        ArraysComparison compareArrays = new ArraysComparison();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        Assert.assertTrue(compareArrays.compareTwoArrays(personalAccountPage.fillActualArray(), personalAccountPage.fillExpectedArray()));

    }

}
