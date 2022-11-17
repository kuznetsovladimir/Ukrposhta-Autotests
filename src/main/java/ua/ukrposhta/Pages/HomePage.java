package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {



    private final SelenideElement contactCenter = $x("/html/body/header/div[1]/div/div/div/p[2]/a");
    private final SelenideElement languageDropdownButton = $x("/html/body/header/div[2]/div[1]/div/div[4]/span");
    private final SelenideElement firstLanguageButton = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[1]");
    private final SelenideElement secondLanguageButton = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[2]");
    private final SelenideElement indexSearchButton = $x("/html/body/div[3]/div/div[2]/div/div[2]/div[3]/a");
    private final SelenideElement indexPageHeader = $x("/html/body/app-root/div/div/div/div/h3");
    private  final SelenideElement searchIndexInput = $x("//*[@id=\"main\"]/div/div[6]/div/div/div/div/form/div/div[1]/input");
    private final SelenideElement registrationButton = $x("/html/body/header/div[2]/div[1]/div/div[2]/a[2]/span");
    private final SelenideElement bottomHeader = $("#bottom-header");


    public SelenideElement getLanguageDropdownButton() {
        return languageDropdownButton;
    }
    public SelenideElement getSearchIndexInput() {
        return searchIndexInput;
    }
    public SelenideElement getFirstLanguageButton() {
        return firstLanguageButton;
    }
    public SelenideElement getIndexPageHeader () {
        return indexPageHeader;
    }


    /**
     * Click on the language selection button
     */
    public void openLanguageSelectionDropdown() {
        languageDropdownButton.click();
    }
    /**
     * Comparing actual and expected values provided in the language selection dropdown
     */
    public boolean languageDropdownValuesCompare(String valueOne, String valueTwo){
        String firstValue = firstLanguageButton.getText();
        String secondValue = secondLanguageButton.getText();

        if(firstValue.equals(valueOne) && secondValue.equals(valueTwo)){
            return true;
        } return false;
    }
    /**
     * Click on the "RU" button of the dropdown-list
     */
    public void selectRuLanguage() {
        firstLanguageButton.click();
    }
    /**
     * Click on the "EN" button of the dropdown-list
     */
    public void selectEnLanguage() {
        secondLanguageButton.click();
    }
    /**
     * Check if the website language changed to RU
     */
    public boolean ruLanguageAppliedCheck (){
        String ruText = contactCenter.getText();
        return ruText.equals("контакт-центр");
    }
    /**
     * Check if the website language changed to RU
     *
     */
    public boolean enLanguageAppliedCheck () {
        String enText = contactCenter.getText();
        return enText.equals("contact center");
    }
    /**
     * Click on the indexSearchButton
     */
    public void clickOnTheIndexSearchButton () {
        indexSearchButton.click();
    }
    /**
     * Verify that the Index search page is opened
     */
    public boolean indexSearchPageOpened () {
        String headerText = indexPageHeader.getText();
        return headerText.equals("Знайти поштовий індекс");
    }
    /**
     * Scroll to the index search input field
     */
    public void scrollToIndexSearchInput () {
        searchIndexInput.scrollTo();
    }
    /**
     * Send keys to the index search input
     */
    public void sendKeysToIndexSearchInput () {
        searchIndexInput.sendKeys("Дніпро", Keys.ENTER);
    }
    /**
     * Click on the Registration button
     */
    public void clickOnTheRegistrationButton () {
        registrationButton.click();
    }

    public SelenideElement getBottomHeader () {
        return bottomHeader;
    }

    /**
     * Click on the language dropdown button
     */
    public void clickOnTheLanguageDropdownButton () {
        languageDropdownButton.click();
    }


}

