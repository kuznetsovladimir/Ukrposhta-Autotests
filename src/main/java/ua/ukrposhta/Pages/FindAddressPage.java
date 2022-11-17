package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;


public class FindAddressPage extends TestData {

    private final SelenideElement pageHeader = $x("//div[@class=\"container\"]/h3");
    private final SelenideElement searchInputField = $("#postIndex");
    private final SelenideElement searchButton = $x("//button[@class=\"submitButton col-md-12 col-xs-12\"]");
    private final SelenideElement responseBlock = $x("//div[@class=\"adressesResponse ng-star-inserted\"]");
    private final SelenideElement address = $x("//div[@class=\"adressesResponse ng-star-inserted\"]/p[4]");


    public SelenideElement getPageHeader () {
        return pageHeader;
    }
    public String getPageHeaderText () {
        return pageHeader.getText();
    }

    public void fillInputField () {
        searchInputField.sendKeys(POSTAL_INDEX);
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
