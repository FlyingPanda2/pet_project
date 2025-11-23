package UI.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import UI.pages.TextBoxPage;
import UI.properties.BaseTest;

import java.util.List;

public class DemoqaTextBoxTests extends BaseTest {

    private final static String TEXT_BOX_URL = "https://demoqa.com/text-box";

    private String fullNameExample = "John Doe";
    private String emailExample = "john@example.com";
    private String currentAddressExample = "Alivia street 28 house";
    private String permanentAddressExample = "Giorgio street 13 house";

    /**
     * Подстановка 4 строк в Text Box на странице, проверка значений, которые выводятся после отображения
     */
    @Test
    public void checkTextBoxResults(){
        TextBoxPage textBoxPage = new TextBoxPage(TEXT_BOX_URL);
        List<String> expectedValues = List.of(
                "Name:" + fullNameExample,
                "Email:" + emailExample,
                "Current Address :" + currentAddressExample,
                "Permananet Address :" + permanentAddressExample); // Ошибка в названии текстовой строки!

        textBoxPage.fillFullName(fullNameExample);
        textBoxPage.fillEmail(emailExample);
        textBoxPage.fillCurrentAddress(currentAddressExample);
        textBoxPage.fillPermanentAddress(permanentAddressExample);

        textBoxPage.clickOnSubmitButton();

        List<String> obtainedValues = textBoxPage.getResult();

        Assertions.assertEquals(expectedValues, obtainedValues);
    }
}
