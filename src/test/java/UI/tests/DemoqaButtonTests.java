package UI.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import UI.pages.ButtonPage;
import UI.properties.BaseTest;

public class DemoqaButtonTests extends BaseTest {

    private final static String BUTTONS_URL = "https://demoqa.com/buttons";

    /**
     * Проверка получения текста "You have done a double click" при двойном нажатии на кнопку
     */
    @Test
    public void checkDoubleClickMessage(){
        ButtonPage buttonPage = new ButtonPage(BUTTONS_URL);
        buttonPage.doubleClickOnDoubleClickButton();
        Assertions.assertEquals("You have done a double click", buttonPage.getDoubleClickMessage());
    }

    /**
     * Проверка получения текста "You have done a right click" при нажатии ПКМ на кнопку
     */
    @Test
    public void checkRightClickMessage(){
        ButtonPage buttonPage = new ButtonPage(BUTTONS_URL);
        buttonPage.rightClickOnRightClickButton();
        Assertions.assertEquals("You have done a right click", buttonPage.getRightClickMessage());
    }

    /**
     * Проверка получения текста "You have done a dynamic click" при нажатии на кнопку
     */
    @Test
    public void checkClickMeMessage(){
        ButtonPage buttonPage = new ButtonPage(BUTTONS_URL);
        buttonPage.clickOnClickMeButton();
        Assertions.assertEquals("You have done a dynamic click", buttonPage.getDynamicClickMessage());
    }
}
