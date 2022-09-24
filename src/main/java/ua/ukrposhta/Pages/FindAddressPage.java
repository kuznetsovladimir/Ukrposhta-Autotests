package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FindAddressPage {

    private final String INDEX = "49086";
    private final String ADDRESS = "вул. Підгірна, 19.";
    private final String HEADER = "Знайти адресу";

    private final SelenideElement pageHeader = $x("//div[@id=\"main\"]/div/div/div/h3");
    private final SelenideElement searchInputField = $("#postIndex");
    private final SelenideElement searchButton = $x("//button[@class=\"submitButton col-md-12 col-xs-12\"]");
    private final SelenideElement responseBlock = $x("//div[@class=\"adressesResponse ng-star-inserted\"]");
    private final SelenideElement address = $x("//div[@class=\"adressesResponse ng-star-inserted\"]/p[4]");


    public String getINDEX () {
        return INDEX;
    }

    public String getADDRESS () {
        return ADDRESS;
    }

    public String getHEADER () {
        return HEADER;
    }

    public String pageHeaderText () {
        return pageHeader.getText();
    }

    public void fillInputField () {
        searchInputField.sendKeys(INDEX);
    }

    public void clickOnSearchButton () {
        searchButton.click();;
    }

    public SelenideElement getResponseBlock () {
        return responseBlock;
    }

    public String addressText () {
        return address.getText();
    }


}
