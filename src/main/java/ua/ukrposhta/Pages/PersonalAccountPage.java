package ua.ukrposhta.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage {

    private final SelenideElement sideBarUserProfile = $x("//*[@id=\"accordion\"]/li[1]/a");
    private final SelenideElement sideBarLoyaltyProgram = $x("//*[@id=\"accordion\"]/li[2]/div[1]/a[1]");
    private final SelenideElement sideBarPoshtaExpress = $x("//*[@id=\"accordion\"]/li[3]/div[1]/a[1]");
    private final SelenideElement sideBarPoshtaStandart = $x("//*[@id=\"accordion\"]/li[4]/div[1]/a[1]");
    private final SelenideElement sideBarPoshtaDocs = $x("//*[@id=\"accordion\"]/li[5]/div[1]/a[1]");
    private final SelenideElement sideBarLetter = $x("//*[@id=\"accordion\"]/li[6]/div[1]/a[1]");
    private final SelenideElement sideBarInternational = $x("//*[@id=\"accordion\"]/li[7]/div[1]/a[1]");
    private final SelenideElement sidebarDeliveryCall = $x("//*[@id=\"accordion\"]/li[8]/a");
    private final SelenideElement expressPoshtaExpand = $x("//a[@href=\"#expressLink\"]");
    private final SelenideElement contactCenterHeader = $x("//div[@class=\"container\"]/h3");
    private final SelenideElement ukrPoshtaStandartLink = $x("//*[@id=\"accordion\"]/li[4]/div[1]/a[1]");
    private final SelenideElement expandedSection = $x("//div[@class=\"accordion-inner collapse in\"]");
    private final ElementsCollection actualValues = $$("li.panel.sidebar-item");
    private final ElementsCollection expressListValues = $$(By.xpath("//*[@id=\"expressLink\"]/ul/li"));
    ArrayList<String> expressListText = new ArrayList<>();
    ArrayList<String> actualValuesText = new ArrayList<String>();


    /**
     * List of expected values
     */
    public ArrayList<String> expressListExpected() {
        ArrayList<String> values = new ArrayList<>();

        values.add("Інструкція");
        values.add("Питання-відповіді");
        values.add("Тарифи");
        values.add("Терміни");
        values.add("Місця приймання");
        values.add("Упакування");
        return values;
    }

    /**
     * List of expected values
     */
    public ArrayList<String> sideBarListExpected () {
        ArrayList<String> ExpectedValues = new ArrayList<String>();
        ExpectedValues.add("Профіль користувача");
        ExpectedValues.add("Програма лояльності");
        ExpectedValues.add("Укрпошта Експрес");
        ExpectedValues.add("Укрпошта Стандарт");
        ExpectedValues.add("Укрпошта Документи");
        ExpectedValues.add("Лист");
        ExpectedValues.add("Міжнародні відправлення");
        ExpectedValues.add("Виклик кур’єра");
        return ExpectedValues;
    }

    /**
     * Click on the Expand button
     */
    public void clickOnTheExpandButton () {
        expressPoshtaExpand.click();
    }

    /**
     * Convert elements collection to String list
     */
    public ArrayList<String> expressList () {
        for (SelenideElement expressListValue : expressListValues) {
            String value = expressListValue.getText();
            expressListText.add(value);
        }
        return expressListText;
    }

    /**
     * Convert elements collection to String list
     */
    public ArrayList<String> sideBarList () {
        for (SelenideElement actualValue : actualValues) {
            String value = actualValue.getText();
            actualValuesText.add(value);
        } return actualValuesText;
    }

    public void clickOnTheInstructionLink () {
        expressListValues.get(1).click();
    }

    public String getContactCenterHeaderText () {
        return contactCenterHeader.getText();
    }
    public SelenideElement getContactCenterHeader () {
        return contactCenterHeader;
    }

    public void clickOnTheUkrPoshtaStandartLink() {
        ukrPoshtaStandartLink.click();
    }
    public SelenideElement getExpandedSection () {
        return expandedSection;
    }
}
