import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;
import utils.Waiter;
import utils.WebDriverFactory;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");
        open("https://ukrposhta.ua/");
    }

    @Test (priority = 1)
    public void changeLanguageToRu () {
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        waiter.waitForVisibility(homePage.getLanguageDropdownButton());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.getLanguageDropdownValuesCompare("RU", "EN"));
        homePage.selectRuLanguage();
        Assert.assertTrue(homePage.getRuLanguageAppliedCheck());
        waiter.waitForVisibility(homePage.getLanguageDropdownButton());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.getLanguageDropdownValuesCompare("UA", "EN"));
    }

    @Test (priority = 2)
    public void changeLanguageToEn () {
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.getLanguageDropdownValuesCompare("RU", "EN"));
        homePage.selectEnLanguage();
        Assert.assertTrue(homePage.getEnLanguageAppliedCheck());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.getLanguageDropdownValuesCompare("UA", "RU"));
    }

    @Test (priority = 3)
    public void openIndexSearchPage () {
        HomePage homePage = new HomePage();

        homePage.clickOnTheIndexSearchButton();
        Assert.assertTrue(homePage.getIndexSearchPageOpened());
    }

    @Test (priority = 4)
    public void openIndexSearchPageFromInput () {
        HomePage homepage = new HomePage();
        Waiter waiter = new Waiter();

        homepage.scrollToIndexSearchInput();
        waiter.waitForVisibility(homepage.getSearchIndexInput());
        homepage.sendKeysToIndexSearchInput();
        Assert.assertTrue(homepage.getIndexSearchPageOpened());
    }
}
