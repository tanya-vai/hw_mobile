package guru.qa.helpers;

import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .filter(new AllureRestAssured())
                .log().all()
                .auth().basic("qaguru_B5xciN", "TzFxj7ss7siMKTxUURLy")
                .when()
                .get(url)
                .then()
                .extract().path("automation_session.video_url");

    }
}