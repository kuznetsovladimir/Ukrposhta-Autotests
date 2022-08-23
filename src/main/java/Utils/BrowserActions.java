package Utils;

import static com.codeborne.selenide.Selenide.open;

public class BrowserActions {
    public void openNewTab () {
        open("https://mail.google.com/");
    }
}
