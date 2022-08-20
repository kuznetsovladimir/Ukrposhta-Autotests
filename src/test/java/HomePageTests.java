import Utils.WebDriverFactory;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @Test
    public void openWebsite () throws InterruptedException {
        WebDriverFactory driver = new WebDriverFactory();
        driver.GetDriver("");
        open("https://ukrposhta.ua/");
        Thread.sleep(3000);
        $x("/html/body/header/div[2]/div[1]/div/div[4]/span").click();
        $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[2]").click();
        Thread.sleep(3000);



    }
}
