package UI.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import UI.pages.RegisterPage;
import UI.properties.BaseTest;

import java.util.Map;

/**
 * Flaky Test
 */
public class DemoqaRegisterTest extends BaseTest {

    private final static String REGISTER_URL = "https://demoqa.com/automation-practice-form";

    Map<String, String> values = Map.ofEntries(
                                Map.entry("firstName", "John"),
                                Map.entry("lastName", "Almert"),
                                Map.entry("email", "asddasdwad@example.com"),
                                Map.entry("gender", "Male"),
                                Map.entry("mobile", "9644576829"),
                                Map.entry("dateOfBirth", "20 May 2025"), // Формат: "День Месяц(сокращен до 3 первых символов) Год" НЕ РАБОТАЕТ С Apr?
                                Map.entry("subjects", "Maths"),
                                Map.entry("hobbies", "Sports, Reading"),
                                Map.entry("picture", ""),
                                Map.entry("currentAddress", "Chernaya street 21 house"),
                                Map.entry("state", "Haryana"), // только те из которых есть выбор
                                Map.entry("city", "Karnal") // только те из которых есть выбор
    );

    @Test
    public void checkRegister(){
        RegisterPage registerPage = new RegisterPage(REGISTER_URL);
        registerPage.fillFirstName(values.get("firstName"));
        registerPage.fillLastName(values.get("lastName"));
        registerPage.fillEmail(values.get("email"));
        registerPage.selectGender(values.get("gender"));
        registerPage.fillMobileNum(values.get("mobile"));
        registerPage.fillDateOfBirth(values.get("dateOfBirth"));
        registerPage.fillSubjects(values.get("subjects"));
        registerPage.fillCurrentAddress(values.get("currentAddress"));
        registerPage.selectHobbies(values.get("hobbies"));
        registerPage.fillState(values.get("state"));
        registerPage.fillCity(values.get("city"));
        registerPage.submitClick();
        String actual = registerPage.getResult();

        String expected =
                "Label Values\n" +
                "Student Name " + values.get("firstName") + " " + values.get("lastName") + "\n"+
                "Student Email " + values.get("email") + "\n" +
                "Gender " + values.get("gender") + "\n" +
                "Mobile " + values.get("mobile") + "\n" +
                "Date of Birth " + values.get("dateOfBirth").split(" ")[0] + " " + values.get("dateOfBirth").split(" ")[1] + "," + values.get("dateOfBirth").split(" ")[2] + "\n" +
                "Subjects " + values.get("subjects") + "\n" +
                "Hobbies " + values.get("hobbies") + "\n" +
                "Picture" + values.get("picture") + "\n" +
                "Address " + values.get("currentAddress") + "\n" +
                "State and City " + values.get("state") + " " + values.get("city");

        Assertions.assertEquals(expected, actual);
    }
}
