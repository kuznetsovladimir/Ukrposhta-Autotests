package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LogInPage {
    private final SelenideElement personalAccountHeader = $x("//*[@id=\"main-wrap\"]/div[2]/div/div[1]/div/div[1]");
    private final SelenideElement logInButton = $x("//a[@rel=\"login-form\"]");
    private final SelenideElement authorizationHeader = $x("//*[@id=\"login-form\"]/div[1]/h3");
    private final SelenideElement forgotPasswordButton = $x("//*[@id=\"login-form\"]/form/div[4]/div/div/a[2]");
    private final SelenideElement forgotPasswordSectionHeader = $x("//*[@id=\"login-form\"]/div[1]/h3");
    private final SelenideElement emailInputField = $x("//*[@id=\"login-form\"]/form/div[1]/div/input");
    private final SelenideElement getNewPasswordButton = $x("//*[@id=\"reset-password\"]");
    private final SelenideElement checkMailboxMessage = $x("//*[@id=\"chaked-mail\"]");
    private final SelenideElement passwordField = $x("//*[@id=\"login-form\"]/form/div[2]/div/input");
    private final SelenideElement enterButton = $x("//*[@id=\"login-form\"]/form/div[3]/div/input");
    private final SelenideElement stopSessionButton = $x("//*[@id=\"main-wrap\"]/div[1]/div/ul/li/a");
    private final String validPass = "Qwerty123";
    private final String invalidPass = "Qwerty143";
    private final String validEmail = "kuznietsov.qatask@gmail.com";
    private final String invalidEmail = "kuznietso.qatask@gmail.com";
    private final SelenideElement errorMessagePass = $x("//*[@id=\"filds-error-message\"]/div");
    private final SelenideElement errorMessageMail = $x("//*[@id=\"filds-error-message\"]/div");



    public SelenideElement getStopSessionButton () {
        return stopSessionButton;
    }
    public  SelenideElement getPersonalAccountHeader() {
        return personalAccountHeader;
    }
    public SelenideElement getErrorMessageMail () {
        return errorMessageMail;
    }
    public SelenideElement getErrorMessagePass () {
        return errorMessagePass;
    }
    public SelenideElement getAuthorizationHeader () {
        return authorizationHeader;
    }
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
    public void fillTheEmailField (String emailValue) {
        emailInputField.sendKeys(emailValue);
    }

    /**
     * Fill Password field with a valid password
     */
    public void fillPasswordField (String passwordValue) {
        passwordField.sendKeys(passwordValue);
    }

    /**
     * Fill Password field with an invalid password
     */
    public void fillPasswordFieldInvalid (String passwordValue) {
        passwordField.sendKeys(passwordValue);
    }

    /**
     *
     */
    public String getValidPass () {
        return validPass;
    }

    /**
     *
     */
    public String getInvalidPass () {
        return invalidPass;
    }

    /**
     *
     */
    public String getValidEmail () {
        return validEmail;
    }



    /**
     *
     */
    public String getInvalidEmail () {
        return invalidEmail;
    }

    /**
     * Fill Email field with invalid data
     */
    public void fillEmailFieldInvalid (String emailValue) {
        emailInputField.sendKeys(emailValue);
    }

    /**
     * Verify that password is hidden
     */
    public boolean verifyPasswordIsHidden (String password) {
    String inputValue = passwordField.getText();
    if (inputValue.equals(password)){
        return false;
    } return true;
    }

    /**
     * Verify Error message Pass
     */
    public boolean verifyErrorMessagePass () {
        String message = errorMessagePass.getText();
        return message.equals("Пароль недійсний або користувач не має пароля.");
    }

    /**
     * Verify Error message Mail
     */
    public boolean verifyErrorMessageMail () {
        String message = errorMessageMail.getText();
        return message.equals("Немає запису користувача, що відповідає цьому ідентифікатору. Користувач може бути видалено.");
    }

    /**
     * Click on the Enter button
     */
    public void clickOnTheEnterButton () {
        enterButton.click();
    }
    /**
     * Verify that the user is logged in
     */
    public boolean verifyLogIn () {
        String text = stopSessionButton.getText();
        return text.equals("ЗАВЕРШИТИ СЕАНС");
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
