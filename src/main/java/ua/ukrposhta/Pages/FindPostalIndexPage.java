package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FindPostalIndexPage {

    private final String CITY_NAME = "Дніпро";
    private final String INDEX = "49086";

    private final SelenideElement cityDropdownField = $x("//div[@class=\"btn-group dropdown-group\"]/form-city-input/input");
    private final SelenideElement cityDropdownList = $x("//ul[@class=\"cities-dropdown-menu show ng-star-inserted\"]");
    private final SelenideElement cityDropdownListFirstOption = $x("//ul[@class=\"cities-dropdown-menu show ng-star-inserted\"]/div[1]/button");
    private final SelenideElement streetDropdownList = $x("//ul[@class=\"street-dropdown-menu show ng-star-inserted\"]");
    private final SelenideElement streetDropdownListFirstOption = $x("//ul[@class=\"street-dropdown-menu show ng-star-inserted\"]/div[1]/button");
    private final SelenideElement houseDropdownList = $x("//ul[@class=\"houses-dropdown-menu ng-star-inserted show\"]");
    private final SelenideElement houseDropdownListFirstOption = $x("//ul[@class=\"houses-dropdown-menu ng-star-inserted show\"]/div[1]/button");
    private final SelenideElement submitButton = $x("//button[@type=\"submit\"]");
    private final SelenideElement indexResponseBlock = $x("//response-index-loader[@id=\"indexResponse\"]");
    private final SelenideElement indexResponseBlockHeader = $x("//p[@class=\"postOfficeIndex ng-star-inserted\"]");
    private final SelenideElement searchAddressByIndexNavLink = $x("//a[@class=\"link-to-adress-page link-grey\"]");


    public String getCITY_NAME () {
        return CITY_NAME;
    }

    public String getINDEX () {
        return INDEX;
    }

    public SelenideElement getCityDropdownList () {
        return cityDropdownList;
    }

    public SelenideElement getStreetDropdownList () {
        return streetDropdownList;
    }

    public SelenideElement getHouseDropdownList () {
        return houseDropdownList;
    }

    public SelenideElement getIndexResponseBlock () {
        return indexResponseBlock;
    }

    public String indexResponseBlockHeaderText () {
        String text = indexResponseBlockHeader.getText();
        return text;
    }

    public String cityDropdownFieldText () {
        String value = cityDropdownField.getText();
        return value;
    }

    public void clickOnCityDropdownListFirstOption () {
        cityDropdownListFirstOption.click();
    }

    public void clickOnStreetDropdownListFirstOption () {
        streetDropdownListFirstOption.click();
    }

    public void clickOnHouseDropdownListFirstOption () {
        houseDropdownListFirstOption.click();
    }

    public void clickOnSubmitButton () {
        submitButton.click();
    }

    public void clickOnSearchAddressByIndexNavLink () {
        searchAddressByIndexNavLink.click();
    }


}
