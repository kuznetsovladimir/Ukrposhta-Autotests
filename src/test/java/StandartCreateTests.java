import Utils.WebDriverFactory;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import ua.ukrposhta.Pages.PersonalAccountPage;
import ua.ukrposhta.Pages.UkrPoshtaStandartPage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class StandartCreateTests {
    public int sleep = 3000;
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
        Selenide.sleep(sleep);
        logInPage.clickOnTheLogInButton();
        logInPage.fillTheEmailField(personalAccountPage.getEmail());
        logInPage.fillPasswordField(personalAccountPage.getPassword());
        logInPage.clickOnTheEnterButton();
        Selenide.sleep(sleep);
        personalAccountPage.clickOnTheUkrPoshtaStandartLink();
    }

    @Test
    public void createNewDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();

        standartPage.clickOnTheStandartCreateBtn();
        Selenide.sleep(sleep);
        standartPage.fillReceiverSection();
        standartPage.clickOnTheDeliveryDropdown();
        standartPage.clickOnTheDeliveryOption();
        standartPage.fillReceiverAddressDropdowns();
        standartPage.fillStreetInput();
        standartPage.fillHouseInput();
        standartPage.fillWeightInput();
        standartPage.fillLengthInput();
        Selenide.sleep(4000);
        standartPage.clickOnSubmitButton();
        Selenide.sleep(4000);
        Assert.assertTrue(standartPage.getDespatchCard().isDisplayed());
        Selenide.sleep(4000);
    }

    @Test
    public void modifyDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();

        standartPage.clickOnTheMoreInfoButton();
        Selenide.sleep(sleep);
        Assert.assertTrue(standartPage.verifyReceiverName());
        standartPage.clickOnModifyButton();
        Selenide.sleep(sleep);
        standartPage.clearPhoneInput();
        standartPage.fillPhoneInput();
        standartPage.clickOnSubmitButton();
        Selenide.sleep(sleep);
        standartPage.clickOnTheMoreInfoButton();
        Selenide.sleep(sleep);
        Assert.assertTrue(standartPage.verifyNewNumber());
    }

    @Test
    public void deleteDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();

        standartPage.clickOnTheMoreInfoButton();
        Selenide.sleep(sleep);
        standartPage.clickOnTheDeleteDespatchButton();
        Selenide.sleep(1000);
        Assert.assertTrue(standartPage.getDeleteMessageBox().isDisplayed());
        Assert.assertTrue(standartPage.verifyConfirmDeleteBox());
        standartPage.clickOnDeleteButton();
        Selenide.sleep(sleep);
        Assert.assertTrue(standartPage.getNoDespatchesMessageBox().isDisplayed());
        Selenide.sleep(1000);
        Assert.assertTrue(standartPage.verifyDespatchDeleted());
    }

    @Test
    public void checkDeliveryMethodsValues () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();

        standartPage.clickOnTheStandartCreateBtn();
        Selenide.sleep(sleep);
        standartPage.clickOnTheDeliveryDropdown();
        Selenide.sleep(sleep);
        Assert.assertTrue(standartPage.verifyDeliveryOptionsValues());

    }

}
