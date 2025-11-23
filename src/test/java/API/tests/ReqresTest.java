package API.tests;

import API.login.Login;
import API.login.SuccessLogin;
import API.login.UnSuccessLogin;
import API.register.Register;
import API.register.SuccessReg;
import API.register.UnSuccessReg;
import API.spec.Specifications;
import API.user.UserData;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ReqresTest {

    private final static String URL = "https://reqres.in/";

    @Test
    public void checkAvatar() {

        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecOK200()
        );

        List<UserData> users = given()
                .header("x-api-key", "reqres-free-v1") // Прокидываем бесплатный api ключ на сервер
                .when()
                .contentType(ContentType.JSON)
                .get("api/users?page=1")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);
        users.forEach(data ->
                Assertions.assertTrue(data.getAvatar().contains(data.getId().toString()))
        );
        Assertions.assertTrue(users.stream().allMatch(data -> data.getEmail().endsWith("@reqres.in")));

        List<String> avatars = users.stream().map(UserData::getAvatar).toList();
        List<String> ids = users.stream().map(data -> data.getId().toString()).toList();

        for (int i = 0; i < avatars.size(); i++) {
            Assertions.assertTrue(avatars.get(i).contains(ids.get(i)));
        }
    }

    @Test
    public void checkUsersFirstAndLastNames(){
        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecOK200()
        );

        List<String> usersFirstNames = List.of("Michael", "Lindsay", "Tobias", "Byron", "George", "Rachel");
        List<String> usersLastNames = List.of("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell");

        List<UserData> users = given()
                .header("x-api-key", "reqres-free-v1") // Прокидываем бесплатный api ключ на сервер
                .when()
                .contentType(ContentType.JSON)
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", UserData.class);

        for(int i = 0; i < users.size(); i++){
            Assertions.assertEquals(users.get(i).getFirst_name(), usersFirstNames.get(i));
            Assertions.assertEquals(users.get(i).getLast_name(), usersLastNames.get(i));
        }
    }

    @Test
    public void successReg(){
        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecOK200()
        );

        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";

        Register user = new Register("eve.holt@reqres.in", "pistol");
        SuccessReg successReg = given()
                .body(user)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .post("api/register")
                .then().log().all()
                .extract().as(SuccessReg.class);

        Assertions.assertNotNull(successReg.getId());
        Assertions.assertNotNull(successReg.getToken());
        Assertions.assertEquals(id, successReg.getId());
        Assertions.assertEquals(token, successReg.getToken());
    }

    @Test
    public void unSuccessReg(){
        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecERROR400()
        );

        Register userForRegister = new Register("sydney@fife", "");
        UnSuccessReg unSuccessReg = given()
                .body(userForRegister)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .post("api/register")
                .then().log().all()
                .extract().as(UnSuccessReg.class);

        Assertions.assertEquals("Missing password", unSuccessReg.getError());
    }

    @Test
    public void successLogin(){
        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecOK200()
        );

        String token = "QpwL5tke4Pnpja7X4";

        Login userForLogin = new Login("eve.holt@reqres.in", "cityslicka");
        SuccessLogin successLogin = given()
                .body(userForLogin)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .post("api/login")
                .then().log().all()
                .extract().as(SuccessLogin.class);

        Assertions.assertEquals(token, successLogin.getToken());
    }

    @Test
    public void unSuccessLogin(){
        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecERROR400()
        );

        Login userForLogin = new Login("peter@klaven", "");
        UnSuccessLogin unSuccessLogin = given()
                .body(userForLogin)
                .when()
                .header("x-api-key", "reqres-free-v1")
                .post("api/login")
                .then().log().all()
                .extract().as(UnSuccessLogin.class);

        Assertions.assertEquals("Missing password", unSuccessLogin.getError());
    }
}
