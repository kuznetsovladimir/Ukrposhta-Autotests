package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class GmailLoginPage {
    private final SelenideElement emailInputField = $x("//*[@id=\"identifierId\"]");
    private final SelenideElement emailSectionHeader = $x("//*[@id=\"headingText\"]/span");
    private final SelenideElement nextButton = $x("//*[@id=\"identifierNext\"]/div/button");
    public final SelenideElement againButton = $x("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div[2]/div[2]/div/div[2]/div/div/div/div/div/a");
    /**
     * Verify that gmail insert email page opened
     */
    public boolean checkEmailInsertSectionOpened () {
        String header = emailSectionHeader.getText();
        return header.equals("Вход");
    }

    /**
     * Insert an email address to the input field
     */
    public void fillEmailField () {
        emailInputField.sendKeys("kuznietsov.qatask@gmail.com");
    }

    /**
     * Click on the Next button
     */
    public void clickOnTheNextButton () {
        nextButton.click();
    }
}
