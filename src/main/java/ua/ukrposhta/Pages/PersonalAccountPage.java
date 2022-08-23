package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PersonalAccountPage {
    private final SelenideElement personalAccountHeader = $x("//*[@id=\"main-wrap\"]/div[2]/div/div[1]/div/div[1]");
    private final SelenideElement logInButton = $x("//*[@id=\"registration-form\"]/form/div[24]/div[2]/div");
    private final SelenideElement authorizationHeader = $x("//*[@id=\"login-form\"]/div[1]/h3");
    private final SelenideElement forgotPasswordButton = $x("//*[@id=\"login-form\"]/form/div[4]/div/div/a[2]");
    private final SelenideElement forgotPasswordSectionHeader = $x("//*[@id=\"login-form\"]/div[1]/h3");
    private final SelenideElement emailInputField = $x("//*[@id=\"login\"]");
    private final SelenideElement getNewPasswordButton = $x("//*[@id=\"reset-password\"]");
    private final SelenideElement checkMailboxMessage = $x("//*[@id=\"chaked-mail\"]");


    /**
     * Verify Log in page header
     */
    public boolean registrationPageOpened () {
        String header = personalAccountHeader.getText();
        return header.equals("Особистий кабінет");
    }

    /**
     * Click on the Log In button
     */
    public void clickOnTheLogInButton () {
        logInButton.click();
    }

    /**
     * Verify Authorization block header
     */
    public boolean authorizationSectionOpened () {
        String header = authorizationHeader.getText();
        return header.equals("Авторизація");
    }

    /**
     * Click on the Forgot Password button
     */
    public void clickOnTheForgotPasswordButton () {
        forgotPasswordButton.click();
    }

    /**
     * Verify Forgot Password section opened
     */
    public boolean forgotPasswordSectionOpened () {
        String header = forgotPasswordSectionHeader.getText();
        return header.equals("Забули пароль?");
    }

    /**
     * Fill E-mail field with a valid email
     */
    public void fillTheEmailField () {
        emailInputField.sendKeys("kuznietsov.qatask@gmail.com");
    }

    /**
     * Click on the Get New Password button
     */
    public void clickOnTheGetNewPassButton () {
        getNewPasswordButton.click();
    }

    /**
     * Verify Check Mailbox message
     */
    public boolean checkMailboxMessageDisplayed () {
        String message = checkMailboxMessage.getText();
        return message.equals("Перевірте пошту.");
    }
}
