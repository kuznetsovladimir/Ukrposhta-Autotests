import Utils.WebDriverFactory;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.FindPostalIndexPage;
import ua.ukrposhta.Pages.HomePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FindPostalIndexTests {
    int sleep = 3000;
    @BeforeMethod
    public void setUp () {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("CHROME");


        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        acceptCookiesButton.click();
    }

    @Test
    public void FindPostalIndex () {
        HomePage homePage = new HomePage();
        FindPostalIndexPage postalPage = new FindPostalIndexPage();

        homePage.scrollToIndexSearchInput();
        homePage.sendKeysToIndexSearchInput();
        Selenide.sleep(sleep);
        Assert.assertTrue(homePage.indexSearchPageOpened());
        postalPage.clickOnCityDropdownListFirstOption();
        Assert.assertFalse(postalPage.getCityDropdownList().isDisplayed());
        Selenide.sleep(4000);
        Assert.assertTrue(postalPage.getStreetDropdownList().isDisplayed());
        postalPage.clickOnStreetDropdownListFirstOption();
        Assert.assertFalse(postalPage.getStreetDropdownList().isDisplayed());
        Selenide.sleep(sleep);
        Assert.assertTrue(postalPage.getHouseDropdownList().isDisplayed());
        postalPage.clickOnHouseDropdownListFirstOption();
        Assert.assertFalse(postalPage.getHouseDropdownList().isDisplayed());
        postalPage.clickOnSubmitButton();
        Selenide.sleep(2000);
        Assert.assertTrue(postalPage.getIndexResponseBlock().isDisplayed());
        Assert.assertEquals(postalPage.indexResponseBlockHeaderText(), postalPage.getINDEX());


    }



}
