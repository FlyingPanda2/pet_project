package UI.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.util.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    private SelenideElement firstName = $x("//input[@placeholder='First Name']");
    private SelenideElement lastName = $x("//input[@placeholder='Last Name']");
    private SelenideElement email = $x("//input[@placeholder='name@example.com']");
    private SelenideElement genderMale = $x("//label[@for='gender-radio-1']");
    private SelenideElement genderFemale = $x("//label[@for='gender-radio-2']");
    private SelenideElement genderOther = $x("//label[@for='gender-radio-3']");
    private SelenideElement mobile = $x("//input[@placeholder='Mobile Number']");
    private SelenideElement sportHobby = $x("//label[@for='hobbies-checkbox-1']");
    private SelenideElement readingHobby = $x("//label[@for='hobbies-checkbox-2']");
    private SelenideElement musicHobby = $x("//label[@for='hobbies-checkbox-3']");
    private SelenideElement currentAddress = $x("//textarea[@placeholder='Current Address']");
    private SelenideElement state = $("#state");
    private SelenideElement city = $("#city");
    private SelenideElement submitButton = $x("//button[@id='submit']");

    public RegisterPage(String url){
        open(url);
    }

    public void fillFirstName(String firstNameExample){
        firstName.setValue(firstNameExample);
    }

    public void fillLastName(String lastNameExample){
        lastName.setValue(lastNameExample);
    }

    public void fillEmail(String emailExample){
        email.setValue(emailExample);
    }

    public void selectGender(String gender){
        switch (gender){
            case "Male" -> {
                genderMale.click();
            }
            case "Female" -> {
                genderFemale.click();
            }
            case "Other" -> {
                genderOther.click();
            }
        }
    }

    public void fillMobileNum(String mobileNum){
        mobile.setValue(mobileNum);
    }

    public void fillDateOfBirth(String birthday){
        List<String> birthSplited = List.of(birthday.split(" "));

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthSplited.get(1));
        $(".react-datepicker__year-select").selectOption(birthSplited.get(2));
        $$(".react-datepicker__day").find(Condition.text(birthSplited.get(0))).click();

    }

    public void fillSubjects(String subject){
        $("#subjectsInput").setValue(subject).pressEnter();
    }

    public void selectHobbies(String hobbies){
        List<String> hobbiesList = List.of(hobbies.replaceAll(" ", "").split(","));
        if(hobbiesList.contains("Sports")){
            sportHobby.click();
        }
        if(hobbiesList.contains("Reading")){
            readingHobby.click();
        }
        if(hobbiesList.contains("Music")){
            musicHobby.click();
        }
    }

    public void fillCurrentAddress(String address){
        currentAddress.setValue(address);
    }

    public void fillState(String stateExample){
        state.click();
        $(byText(stateExample)).click();

    }

    public void fillCity(String cityExample){
        city.shouldBe(visible);
        city.click();
        $(byText(cityExample)).shouldBe(visible).click();
    }

    public void submitClick(){
        submitButton.click();
    }

    public String getResult(){
        $(".table").shouldBe(visible);
        return $(".table-responsive").getText();
    }
}
