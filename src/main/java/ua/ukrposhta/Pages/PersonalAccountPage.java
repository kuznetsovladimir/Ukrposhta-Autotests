package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage {

    private final String email = "testemail1@gmail.com";// The different user with non-changeable credentials
    private final String password = "Qwerty123";

    private final SelenideElement sideBarUserProfile = $x("//*[@id=\"accordion\"]/li[1]/a");
    private final SelenideElement sideBarLoyaltyProgram = $x("//*[@id=\"accordion\"]/li[2]/div[1]/a[1]");
    private final SelenideElement sideBarPoshtaExpress = $x("//*[@id=\"accordion\"]/li[3]/div[1]/a[1]");
    private final SelenideElement sideBarPoshtaStandart = $x("//*[@id=\"accordion\"]/li[4]/div[1]/a[1]");
    private final SelenideElement sideBarPoshtaDocs = $x("//*[@id=\"accordion\"]/li[5]/div[1]/a[1]");
    private final SelenideElement sideBarLetter = $x("//*[@id=\"accordion\"]/li[6]/div[1]/a[1]");
    private final SelenideElement sideBarInternational = $x("//*[@id=\"accordion\"]/li[7]/div[1]/a[1]");
    private final SelenideElement sidebarDeliveryCall = $x("//*[@id=\"accordion\"]/li[8]/a");

    ArrayList<String> ActualValues = new ArrayList<String>();
    ArrayList<String> ExpectedValues = new ArrayList<String>();

    private final SelenideElement poshtaExpressExpandButton = $x("//*[@id=\"accordion\"]/li[3]/div[1]/a[2]");



    public ArrayList<String> fillActualArray () {


        ActualValues.add(sideBarUserProfile.getText());
        ActualValues.add(sideBarLoyaltyProgram.getText());
        ActualValues.add(sideBarPoshtaExpress.getText());
        ActualValues.add(sideBarPoshtaStandart.getText());
        ActualValues.add(sideBarPoshtaDocs.getText());
        ActualValues.add(sideBarLetter.getText());
        ActualValues.add(sideBarInternational.getText());
        ActualValues.add(sidebarDeliveryCall.getText());
        return ActualValues;
    }

    public ArrayList<String> fillExpectedArray () {

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
     * Get Email
     */
    public String getEmail () {
        return email;
    }

    /**
     * Get Password
     */
    public String getPassword () {
        return password;
    }

    public ArrayList<String> getActualValues() {
        return ActualValues;
    }

    public ArrayList<String> getExpectedValues() {
        return ExpectedValues;
    }

    public void clickOnTheExpandButton () {
        poshtaExpressExpandButton.click();
    }



}
