package UI.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import UI.pages.RadioButtonsPage;
import UI.properties.BaseTest;

public class DemoqaRadioTests extends BaseTest {

    private final static String RADIO_URL = "https://demoqa.com/radio-button";

    /**
     * Жмет на Yes Radio Button "Yes" и проверяет показываемое сообщение, ожидаемый результат "Yes" сообщение
     */
    @Test
    public void checkYesRadioMessage(){
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage(RADIO_URL);
        radioButtonsPage.yesRadioClick();

        Assertions.assertEquals("Yes", radioButtonsPage.getRadioMessage());
    }

    /**
     * Жмет на Yes Radio Button "Impressive" и проверяет показываемое сообщение, ожидаемый результат "Impressive" сообщение
     */
    @Test
    public void checkImpressiveRadioMessage(){
        RadioButtonsPage radioButtonsPage = new RadioButtonsPage(RADIO_URL);
        radioButtonsPage.impressiveRadioClick();

        Assertions.assertEquals("Impressive", radioButtonsPage.getRadioMessage());
    }
}
