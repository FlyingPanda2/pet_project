package API.poke_api;

import API.spec.Specifications;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PokeApiTest {

    private final static String URL = "https://pokeapi.co/api/v2/pokemon/";

    @Test
    @DisplayName("Проверка 100 первых покемонов на корректное отображение ID и Названия покемона")
    public void shouldHaveCorrectId(){
        Specifications.installSpecification(
                Specifications.requestSpecification(URL),
                Specifications.responseSpecOK200()
        );

        List<String> first100PokemonNames = List.of(
                "bulbasaur", "ivysaur", "venusaur", "charmander", "charmeleon", "charizard", "squirtle", "wartortle", "blastoise",
                "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgey", "pidgeotto", "pidgeot", "rattata",
                "raticate", "spearow", "fearow", "ekans", "arbok", "pikachu", "raichu", "sandshrew", "sandslash", "nidoran-f",
                "nidorina", "nidoqueen", "nidoran-m", "nidorino", "nidoking", "clefairy", "clefable", "vulpix", "ninetales",
                "jigglypuff", "wigglytuff", "zubat", "golbat", "oddish", "gloom", "vileplume", "paras", "parasect", "venonat",
                "venomoth", "diglett", "dugtrio", "meowth", "persian", "psyduck", "golduck", "mankey", "primeape", "growlithe",
                "arcanine", "poliwag", "poliwhirl", "poliwrath", "abra", "kadabra", "alakazam", "machop", "machoke", "machamp",
                "bellsprout", "weepinbell", "victreebel", "tentacool", "tentacruel", "geodude", "graveler", "golem", "ponyta",
                "rapidash", "slowpoke", "slowbro", "magnemite", "magneton", "farfetchd", "doduo", "dodrio", "seel", "dewgong",
                "grimer", "muk", "shellder", "cloyster", "gastly", "haunter", "gengar", "onix", "drowzee", "hypno", "krabby",
                "kingler", "voltorb"
        );

        for(int i = 1; i < 101; i++){
            Pokemon pokemon = given()
                    .pathParam("id", i)
                    .when()
                    .contentType(ContentType.JSON)
                    .get("{id}")
                    .then()
                    .extract().as(Pokemon.class);

            Assertions.assertEquals(i, pokemon.getId());
            Assertions.assertEquals(first100PokemonNames.get(i-1), pokemon.getName());
        }

    }
}
