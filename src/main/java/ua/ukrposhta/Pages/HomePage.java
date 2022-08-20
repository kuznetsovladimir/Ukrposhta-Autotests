package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private final SelenideElement LANGUAGE_DROPDOWN_BUTTON = $x("/html/body/header/div[2]/div[1]/div/div[4]/span");
    private final SelenideElement RU_LANGUAGE = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[1]");
    private final SelenideElement EN_LANGUAGE = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[2]");
    private final SelenideElement UA_LANGUAGE = $x("/html/body/header/div[2]/div[1]/div/div[4]/div/div/a[1]");
    private final SelenideElement FIRST_SLICK_BUTTON = $x("/html/body/div[3]/div/div[1]/ul/li[1]/button");
    private final SelenideElement SECOND_SLICK_BUTTON = $x("/html/body/div[3]/div/div[1]/ul/li[2]/button");
    private final SelenideElement THIRD_SLICK_BUTTON = $x("/html/body/div[3]/div/div[1]/ul/li[3]/button");
    private final SelenideElement SLIDER_ITEM_CONTENT = $x("/html/body/div[3]/div/div[1]/div/div/a[1]/div[2]/div");

}

