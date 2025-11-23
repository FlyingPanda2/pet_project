package UI.properties;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;

abstract public class BaseTest {

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-plugins");
        options.addArguments("--mute-audio");

        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        Configuration.browserCapabilities = options;
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.headless = false;
    }

    @BeforeEach
    public void init(){
        setUp();
    }

    @AfterEach
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
