import Utils.WebDriverFactory;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("");
        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        acceptCookiesButton.click();
    }

    @Test
    public void changeLanguageToRu () throws InterruptedException {
        HomePage homePage = new HomePage();
        Thread.sleep(3000);
        homePage.openLanguageSelectionDropdown();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.languageDropdownValuesCompare("RU", "EN"));

        homePage.selectRuLanguage();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.ruLanguageAppliedCheck());
        Thread.sleep(3000);
        homePage.openLanguageSelectionDropdown();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.languageDropdownValuesCompare("UA", "EN"));
    }

    @Test
    public void changeLanguageToEn () throws InterruptedException {
        HomePage homePage = new HomePage();
        Thread.sleep(3000);
        homePage.openLanguageSelectionDropdown();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.languageDropdownValuesCompare("RU", "EN"));
        homePage.selectEnLanguage();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.enLanguageAppliedCheck());
        Thread.sleep(3000);
        homePage.openLanguageSelectionDropdown();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.languageDropdownValuesCompare("UA", "RU"));
    }

    @Test
    public void checkSliderItemContent () throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.clickOnTheFirstSlickButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.firstSliderContentHeader());
        homePage.clickOnTheSecondSlickButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.secondSliderContentHeader());
        homePage.clickOnTheThirdSlickButton();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.thirdSliderContentHeader());
    }

    @Test
    public void openIndexSearchPage () throws InterruptedException {
        HomePage homePage = new HomePage();
        homePage.clickOnTheIndexSearchButton();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.indexSearchPageOpened());
    }

    @Test
    public void openIndexSearchPageFromInput () throws InterruptedException {
        HomePage homepage = new HomePage();
        homepage.scrollToIndexSearchInput();
        Thread.sleep(2000);
        homepage.sendKeysToIndexSearchInput();
        Thread.sleep(2000);
        Assert.assertTrue(homepage.indexSearchPageOpened());
    }
}
