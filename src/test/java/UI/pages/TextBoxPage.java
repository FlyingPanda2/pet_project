package UI.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import UI.properties.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

/**
 * Страница с Text Box на demoqa.com
 */
public class TextBoxPage extends BaseTest {

    private final SelenideElement fullName = $x("//input[@placeholder = 'Full Name']");
    private final SelenideElement email = $x("//input[@placeholder = 'name@example.com']");
    private final SelenideElement currentAddress = $x("//textarea[@id = 'currentAddress']");
    private final SelenideElement permanentAddress = $x("//textarea[@id = 'permanentAddress']");
    private final SelenideElement submitButton = $x("//button[@id='submit']");

    public TextBoxPage(String url){
        Selenide.open(url);
    }

    public void fillFullName(String fullNameExample){
        fullName.setValue(fullNameExample);
    }

    public void fillEmail(String emailExample){
        email.setValue(emailExample);
    }

    public void fillCurrentAddress(String currentAddressExample){
        currentAddress.setValue(currentAddressExample);
    }

    public void fillPermanentAddress(String permanentAddressExample){
        permanentAddress.setValue(permanentAddressExample);
    }

    public void clickOnSubmitButton(){
        submitButton.click();
    }

    /**
     * Получение вывода страницы после нажатия кнопки submit
     * @return возвращает List<String>, элементы :  Full Name, Email, Current Address, Permanent Adress
     */
    public List<String> getResult(){
        List<String> result = new ArrayList<>();

        result.add($x("//p[@id='name']").getText());
        result.add($x("//p[@id='email']").getText());
        result.add($x("//p[@id='currentAddress']").getText());
        result.add($x("//p[@id='permanentAddress']").getText());

        return result;
    }
}
