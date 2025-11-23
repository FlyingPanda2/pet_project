package UI.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница с кнопками на demoqa.com
 */
public class ButtonPage {

    private final SelenideElement doubleClickButton = $x("//button[@id = 'doubleClickBtn']");
    private final SelenideElement rightClickButton = $x("//button[@id = 'rightClickBtn']");
    private final SelenideElement clickMeButton = $x("//button[text()='Click Me']");

    public ButtonPage(String url) {
        Selenide.open(url);
    }

    public void doubleClickOnDoubleClickButton() {
        doubleClickButton.doubleClick();
    }

    public void rightClickOnRightClickButton() {
        rightClickButton.contextClick();
    }

    public void clickOnClickMeButton() {
        clickMeButton.click();
    }

    public String getDoubleClickMessage() {
        return $x("//p[@id='doubleClickMessage']").getText();
    }

    public String getRightClickMessage() {
        return $x("//p[@id='rightClickMessage']").getText();
    }

    public String getDynamicClickMessage() {
        return $x("//p[@id='dynamicClickMessage']").getText();
    }
}