package ua.ukrposhta.Pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Page404 {
    private final String TEXT_404 = "404!";
    private final String TEXT_ERROR = "На жаль, таку сторінку не знайдено.";

    private final SelenideElement pageHeader = $x("//*[@class=\"title-block-container text-center\"]/h1");
    private final SelenideElement errorExp = $x("//*[@class=\"title-block-container text-center\"]/p");
    private final SelenideElement toTheHomePageButton = $x("//*[@class=\"title-block-container text-center\"]/a");

    public SelenideElement getPageHeader () {
        return pageHeader;
    }

    public String getHeaderText () {
        String text = pageHeader.getText();
        return text;
    }

    public String getTEXT_404 () {
        return TEXT_404;
    }

    public String getErrorText () {
        String text = errorExp.getText();
        return text;
    }

    public String getTEXT_ERROR () {
        return TEXT_ERROR;
    }

    public SelenideElement getToTheHomePageBtn () {
        return toTheHomePageButton;
    }
}
