package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

public class Waiter {
    public void waitForVisibility (SelenideElement element) {
        element.should(Condition.visible, Duration.ofSeconds(10));
    }
}
