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
    public void changeLanguageToRu () throws InterruptedException {
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        waiter.waitForVisibility(homePage.getLanguageDropdownButton());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.languageDropdownValuesCompare("RU", "EN"));
        homePage.selectRuLanguage();
        Assert.assertTrue(homePage.ruLanguageAppliedCheck());
        waiter.waitForVisibility(homePage.getLanguageDropdownButton());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.languageDropdownValuesCompare("UA", "EN"));
    }

    @Test (priority = 2)
    public void changeLanguageToEn () throws InterruptedException {
        HomePage homePage = new HomePage();
        Waiter waiter = new Waiter();

        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.languageDropdownValuesCompare("RU", "EN"));
        homePage.selectEnLanguage();
        Thread.sleep(3000);
        Assert.assertTrue(homePage.enLanguageAppliedCheck());
        homePage.clickOnTheLanguageDropdownButton();
        waiter.waitForVisibility(homePage.getFirstLanguageButton());
        Assert.assertTrue(homePage.languageDropdownValuesCompare("UA", "RU"));
    }


    @Test (priority = 3)
    public void openIndexSearchPage () throws InterruptedException {
        HomePage homePage = new HomePage();

        homePage.clickOnTheIndexSearchButton();
        Assert.assertTrue(homePage.indexSearchPageOpened());
    }

    @Test (priority = 4)
    public void openIndexSearchPageFromInput () throws InterruptedException {
        HomePage homepage = new HomePage();
        Waiter waiter = new Waiter();

        homepage.scrollToIndexSearchInput();
        waiter.waitForVisibility(homepage.getSearchIndexInput());
        homepage.sendKeysToIndexSearchInput();
        Assert.assertTrue(homepage.indexSearchPageOpened());
    }


}
