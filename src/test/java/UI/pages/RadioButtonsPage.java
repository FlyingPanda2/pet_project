package UI.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница с Radio Buttons на demoqa.com
 */
public class RadioButtonsPage {

    private final SelenideElement yesRadioButton = $x("//label[@for='yesRadio']");
    private final SelenideElement impressiveRadioButton = $x("//label[@for='impressiveRadio']");

    private final SelenideElement radioMessage = $x("//span[@class='text-success']");

    public RadioButtonsPage(String url){
        Selenide.open(url);
    }

    public void yesRadioClick(){
        yesRadioButton.click();
    }

    public void impressiveRadioClick(){
        impressiveRadioButton.click();
    }

    public String getRadioMessage(){
        return radioMessage.getText();
    }
}
