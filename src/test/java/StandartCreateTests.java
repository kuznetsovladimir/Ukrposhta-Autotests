import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import ua.ukrposhta.Pages.LogInPage;
import ua.ukrposhta.Pages.PersonalAccountPage;
import ua.ukrposhta.Pages.UkrPoshtaStandartPage;
import utils.TestData;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class StandartCreateTests extends TestData {

    @BeforeMethod
    public void setUp () throws InterruptedException {
        WebDriverFactory driver = new WebDriverFactory();

        driver.GetDriver("FIREFOX");
        open("https://ukrposhta.ua/");
    }

    @Test (priority = 1)

    public void createNewDespatch () {
        HomePage homePage  = new HomePage();
        LogInPage logInPage = new LogInPage();
        Waiter waiter = new Waiter();
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage();

        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        if (acceptCookiesButton.isDisplayed()) {acceptCookiesButton.click();};

        homePage.clickOnTheRegistrationButton();
        waiter.waitForVisibility(logInPage.getPersonalAccountHeader());
        logInPage.clickOnTheLogInButton();
        waiter.waitForVisibility(logInPage.getAuthorizationHeader());
        logInPage.fillTheEmailField(TEST_EMAIL);
        logInPage.fillPasswordField(VALID_PASS);
        logInPage.clickOnTheEnterButton();
        waiter.waitForVisibility(logInPage.getStopSessionButton());
        personalAccountPage.clickOnTheUkrPoshtaStandartLink();
        standartPage.clickOnTheStandartCreateBtn();
        waiter.waitForVisibility(standartPage.getFirstReceiverInputField());
        standartPage.fillReceiverSection();
        standartPage.clickOnTheDeliveryDropdown();
        standartPage.clickOnTheDeliveryOption();
        standartPage.fillReceiverAddressDropdowns();
        standartPage.fillStreetInput();
        standartPage.fillHouseInput();
        standartPage.fillWeightInput();
        standartPage.fillLengthInput();
        standartPage.getSubmitButton().scrollTo();
        waiter.waitForVisibility(standartPage.getSubmitButton());
        standartPage.clickOnSubmitButton();
        //waiter.waitForVisibility(standartPage.getDespatchCard());
        Selenide.sleep(10000);
    }

    @Test (priority = 2)
    public void modifyDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        Waiter waiter = new Waiter();
        open("https://ok.ukrposhta.ua/ua/lk/standart");

        standartPage.clickOnTheMoreInfoButton();
        waiter.waitForVisibility(standartPage.getDespatchMoreInfoReceiverName());
        Assert.assertTrue(standartPage.verifyReceiverName());
        standartPage.clickOnModifyButton();
        waiter.waitForVisibility(standartPage.getPhoneInputModifyPage());
        standartPage.clearPhoneInput();
        standartPage.fillPhoneInput();
        standartPage.clickOnSubmitButton();
        waiter.waitForVisibility(standartPage.getDespatchMoreInfoButton());
        standartPage.clickOnTheMoreInfoButton();
        waiter.waitForVisibility(standartPage.getDespatchMoreInfoReceiverPhone());
        Assert.assertTrue(standartPage.verifyNewNumber());
    }

    /*@Test (priority = 3)
    public void deleteDespatch () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        Waiter waiter = new Waiter();
        open("https://ok.ukrposhta.ua/ua/lk/standart");

        standartPage.clickOnTheMoreInfoButton();
        waiter.waitForVisibility(standartPage.getDeleteDespatchButton());
        standartPage.clickOnTheDeleteDespatchButton();
        waiter.waitForVisibility(standartPage.getDeleteMessageBox());
        Assert.assertTrue(standartPage.verifyConfirmDeleteBox());
        standartPage.clickOnDeleteButton();
        waiter.waitForVisibility(standartPage.getNoDespatchesMessageBox());
    }*/

    @Test (priority = 4)
    public void checkDeliveryMethodsValues () {
        UkrPoshtaStandartPage standartPage = new UkrPoshtaStandartPage();
        Waiter waiter = new Waiter();
        open("https://ok.ukrposhta.ua/ua/lk/standart");

        standartPage.clickOnTheStandartCreateBtn();
        waiter.waitForVisibility(standartPage.getFirstReceiverInputField());
        standartPage.clickOnTheDeliveryDropdown();
        waiter.waitForVisibility(standartPage.getDeliveryMethodDropdownList());
        Assert.assertTrue(standartPage.verifyDeliveryOptionsValues());
    }

}
