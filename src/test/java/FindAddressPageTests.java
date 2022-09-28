import Utils.WebDriverFactory;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ua.ukrposhta.Pages.FindAddressPage;
import ua.ukrposhta.Pages.FindPostalIndexPage;
import ua.ukrposhta.Pages.HomePage;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class FindAddressPageTests {
    int sleep = 3000;
    @BeforeMethod
    public void setUp () {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("FIREFOX");


        open("https://ukrposhta.ua/");
        SelenideElement acceptCookiesButton = $x("//*[@id=\"masseg_cookie\"]");
        if(acceptCookiesButton.isDisplayed())
        {acceptCookiesButton.click();}
    }

    @Test
    public void findAddressByIndex () {
        HomePage homePage = new HomePage();
        FindAddressPage findAddress = new FindAddressPage();
        FindPostalIndexPage findIndex = new FindPostalIndexPage();

        homePage.clickOnTheIndexSearchButton();
        Selenide.sleep(sleep);
        Assert.assertTrue(homePage.indexSearchPageOpened());
        findIndex.clickOnSearchAddressByIndexNavLink();
        Selenide.sleep(sleep);
        Assert.assertEquals(findAddress.pageHeaderText(), findAddress.getHEADER());
        findAddress.fillInputField();
        findAddress.clickOnSearchButton();
        Selenide.sleep(2000);
        Assert.assertTrue(findAddress.getResponseBlock().isDisplayed());
        Assert.assertEquals(findAddress.addressText(), findAddress.getADDRESS());
        Selenide.sleep(sleep);


    }
}
