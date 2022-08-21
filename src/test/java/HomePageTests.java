import Utils.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @BeforeMethod
    public void setUp() {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("");
        open("https://ukrposhta.ua/");
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

    
}
