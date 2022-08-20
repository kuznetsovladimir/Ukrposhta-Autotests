import Utils.WebDriverFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.HomePage;

import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @Test
    public void changeLanguage () throws InterruptedException {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("");
        open("https://ukrposhta.ua/");
        HomePage homePage = new HomePage();
        Thread.sleep(3000);
        homePage.openLanguageSelectionDropdown();
        Thread.sleep(3000);
        //Assert.assertTrue(homePage.languageDropdownValuesCompare("RU", "EN"));
        homePage.selectRuLanguage();
        Thread.sleep(3000);

        Assert.assertTrue(homePage.ruLanguageAppliedCheck());
        Thread.sleep(3000);



    }
}
