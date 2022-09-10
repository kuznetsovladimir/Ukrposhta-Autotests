package ua.ukrposhta.Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.*;

public class UkrPoshtaStandartPage {
    private final String DELETE_BUTTON_NAME = "Видалити";
    private final String CANCEL_BUTTON_NAME = "Скасувати";
    private final String DELETE_MESSAGE = "Ви дійсно бажаєте видалити відправлення?";
    private final String NO_DESPATCHES_MESSAGE = "Увага! Відправлення відсутні. Для початку роботи натисніть кнопку Створити відправлення.";

    private final SelenideElement standartCreateBtn = $("#standardCreate");

    private final ElementsCollection receiverInputFields =
            $$(By.xpath("//input[@id=\"last-name\" or @id=\"first-name\" or @id=\"patronymic\" or @id=\"phone\"]"));
    private final ElementsCollection receiverAddressDropdownValues =
            $$(By.xpath("//option[@label=\"Вінницька\" or @label=\"Вінницький\" or @label=\"Агрономічне\"]"));
    private final ElementsCollection receiverAddressDropdowns =
            $$(By.xpath("//select[@id=\"region\" or @id=\"district\" or @id=\"city\"]"));
    private final ElementsCollection deliveryMethodDropdownList =
            $$(By.xpath("//option[@data-ng-repeat=\"(key,type) in deliveryTypes\"]"));
    private final SelenideElement streetInput = $x("//input[@id=\"street\"]");
    private final SelenideElement houseInput = $x("//input[@id=\"house\"]");
    private final SelenideElement weightInput = $x("//input[@id=\"weight\"]");
    private final SelenideElement lengthInput = $x("//input[@id=\"length\"]");
    private final SelenideElement submitButton = $x("//button[@type=\"submit\"]");
    private final SelenideElement deliveryMethodDropdown = $("#delivery-method");
    private final SelenideElement deliveryMethodOption = $x("//option[@value=\"W2W\"]");

    private final SelenideElement despatchCard = $x("//div[@class=\"tab-content\"]");
    private final SelenideElement despatchMoreInfoButton = $x("//button[@title=\"Більше інформації\"]");
    private final SelenideElement despatchMoreInfoReceiverName = $x("//div[@class=\"tab-content\"]/div[1]/div[2]/div/div/div[2]/table/tbody/tr[3]/td");
    private final SelenideElement despatchMoreInfoReceiverPhone = $x("//div[@class=\"tab-content\"]/div[1]/div[2]/div/div/div[2]/table/tbody/tr[4]/td");
    private final SelenideElement modifyButton = $x("//button[@id=\" standardChange\"]");
    private final SelenideElement phoneInputModifyPage = $x("//input[@id=\"phone\"]");
    private final SelenideElement deleteDespatchButton = $x("//button[@id=\"standardRemove\"]");
    private final SelenideElement deleteMessageBox = $x("//div[@class=\"modal-footer\"]/div[3]");
    private final SelenideElement deleteMessage = $x("//div[@class=\"modal-footer\"]/div[3]/h4");
    private final SelenideElement deleteButton = $x("//div[@class=\"modal-footer\"]/div[3]/div[1]/button[1]");
    private final SelenideElement cancelButton = $x("//div[@class=\"modal-footer\"]/div[3]/div[1]/button[2]");
    private final SelenideElement noDespatchesMessageBox = $x("//*[@id=\"main-wrap\"]/div[2]/div/div[2]/div[2]/div/div[4]/div/div[1]");


    public void clickOnTheStandartCreateBtn() {
        standartCreateBtn.click();
    }

    public ArrayList<String> setReceiverData () {
        ArrayList<String> data = new ArrayList<>();
        data.add("Іванов");
        data.add("Іван");
        data.add("Іванович");
        data.add("+380960121385");
        return data;
    }

    public ArrayList<String> deliveryMethods () {
        ArrayList<String> values = new ArrayList<>();
        values.add("склад – склад");
        values.add("двері – двері");
        values.add("склад – двері");
        values.add("двері – склад");
        return values;
    }

    public void fillReceiverSection () {
        boolean state = true;
        for(int i = 0; i < receiverInputFields.size(); i++){
            receiverInputFields.get(i).sendKeys(setReceiverData().get(i));
        }
    }

    public void clickOnTheDeliveryDropdown () {
        deliveryMethodDropdown.click();
    }

    public void clickOnTheDeliveryOption () {
        deliveryMethodOption.click();
    }

    public void fillReceiverAddressDropdowns () {
        for(int i = 0; i < receiverAddressDropdowns.size(); i++){
            receiverAddressDropdowns.get(i).click();
            receiverAddressDropdownValues.get(i).click();
        }
    }

    public void fillStreetInput () {
        streetInput.sendKeys("вул. Будівельників");
    }

    public void fillHouseInput () {
        houseInput.sendKeys("1");
    }

    public void fillWeightInput () {
        weightInput.sendKeys("1000");
    }

    public void fillLengthInput () {
        lengthInput.sendKeys("15");
    }

    public void clickOnSubmitButton () {
        submitButton.click();
    }

    public SelenideElement getDespatchCard() {
        return despatchCard;
    }

    public void clickOnTheMoreInfoButton () {
        despatchMoreInfoButton.click();
    }

    public boolean verifyReceiverName () {
        return despatchMoreInfoReceiverName.getText().equals("Іванов Іван Іванович");
    }

    public void clickOnModifyButton () {
        modifyButton.click();
    }
    public void clearPhoneInput () {
        phoneInputModifyPage.clear();
    }

    public void fillPhoneInput () {
        phoneInputModifyPage.sendKeys("+380970121385");
    }

    public boolean verifyNewNumber () {
        return despatchMoreInfoReceiverPhone.getText().equals("+380970121385");
    }

    public void clickOnTheDeleteDespatchButton () {
        deleteDespatchButton.click();
    }

    public SelenideElement getDeleteMessageBox () {
        return deleteMessageBox;
    }

    public boolean verifyConfirmDeleteBox () {
        boolean verified = true;
        if(!(deleteMessage.getText().equals(DELETE_MESSAGE) || deleteButton.getText().equals(DELETE_BUTTON_NAME) || cancelButton.getText().equals(CANCEL_BUTTON_NAME))){
            verified = false;
        } return verified;
    }

    public void clickOnDeleteButton () {
        deleteButton.click();
    }

    public SelenideElement getNoDespatchesMessageBox () {
        return noDespatchesMessageBox;
    }
    public boolean verifyDespatchDeleted () {
        return noDespatchesMessageBox.getText().equals(NO_DESPATCHES_MESSAGE);
    }



     public boolean verifyDeliveryOptionsValues () {
        boolean verify = true;
        for (SelenideElement selenideElement : deliveryMethodDropdownList) {

            for (String text : deliveryMethods()) {
                if (!selenideElement.getText().equals(text)) {
                    verify = false;
                } return verify;
            }
        }
        return verify;
    }

}

