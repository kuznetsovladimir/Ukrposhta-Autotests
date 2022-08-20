package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {



    private final SelenideElement contactCenterRu = $x("/html/body/header/div[1]/div/div/div/p[2]/a");
    //private final String EN_URL = WebDriverRunner.getWebDriver().getCurrentUrl();
    private final SelenideElement languageDropdownButton = $x("/html/body/header/div[2]/div[1]/div/div[4]/span");
    private final SelenideElement firstLanguageButton = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[1]");
    private final SelenideElement secondLanguageButton = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[2]");
    private final SelenideElement firstSlickButton = $x("/html/body/div[3]/div/div[1]/ul/li[1]/button");
    private final SelenideElement secondSlickButton = $x("/html/body/div[3]/div/div[1]/ul/li[2]/button");
    private final SelenideElement thirdSlickButton = $x("/html/body/div[3]/div/div[1]/ul/li[3]/button");
    private final SelenideElement sliderItemContent = $x("/html/body/div[3]/div/div[1]/div/div/a[1]/div[2]/div");
    List<String> initialValues = new ArrayList<String>();
    List<String> actualValues= new ArrayList<String>();


    public void openLanguageSelectionDropdown() {
        languageDropdownButton.click();
    }

    public void selectRuLanguage() {
        firstLanguageButton.click();
    }

    /**
     * Comparing actual and expected values provided in the language selection dropdown
     */
    public boolean languageDropdownValuesCompare(String valueOne, String valueTwo){
        String firstValue = firstLanguageButton.getText(); // Get text of the first dropdown value
        String secondValue = secondLanguageButton.getText(); // Get text of the second dropdown value

        initialValues.add(valueOne); // Adding first reference dropdown value to an array
        initialValues.add(valueTwo); // Adding second reference dropdown value to an array

        actualValues.add(firstValue); // Adding  first actual dropdown value to an array
        actualValues.add(secondValue); // Adding  second actual dropdown value to an array

        for(int i = 0; i < actualValues.size(); i++){                   // Arrays comparison
            if(actualValues.get(i).equals(initialValues.get(i))){
                return true;
            }
        } return false;

    }

    /**
     * Comparing actual and expected URL
     */
    public boolean ruLanguageAppliedCheck (){
        String ruText = contactCenterRu.getText();
        return ruText.equals("контакт-центр");
    }

}

