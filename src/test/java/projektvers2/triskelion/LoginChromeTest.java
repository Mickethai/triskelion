package projektvers2.triskelion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LoginChromeTest {
    private WebDriver driver;
    @BeforeAll
    public static void setUpWebdriverChromeDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
    }
    @BeforeEach
    public void setUpChromedriver(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    @AfterEach
    public void quitChromedriver(){
        driver.quit();
    }
    @Test
    public void shouldFindWebsiteInChrome(){
        driver.get("http://localhost:8080/login");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
    }
    @ParameterizedTest
    @MethodSource("loginParameters")
    public void shouldLoginToUsersiteInEdge(String username, String password) {
        driver.get("http://localhost:8080/login");
        // clean clean it upcd wslsödkfäsödkföäsdkäösdkföäsdf
        WebElement userTextbox = driver.findElement(By.id("username"));
        userTextbox.clear();
        userTextbox.sendKeys(username);
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite", driver.getCurrentUrl());
    }
    private static Stream<Arguments> loginParameters(){
        return Stream.of(
                arguments("Mickethai", "pass")
                //något valid username och password här arguments("Hackerman","hackz")
        );
    }
    @ParameterizedTest
    @MethodSource("falseLoginParameters")
    public void shouldNotLoginToUsersiteInEdge(String username, String password) {
        driver.get("http://localhost:8080/login");
        // Try make this look a bit more clean
        WebElement userTextbox = driver.findElement(By.id("username"));
        userTextbox.clear();
        userTextbox.sendKeys(username);
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/login-error.html", driver.getCurrentUrl());
    }
    private static Stream<Arguments> falseLoginParameters(){
        return Stream.of(
                arguments("user","password"),
                arguments("user", "wrong"),
                arguments("wrong", "password"),
                arguments("wrong", "wrong"),
                arguments("",""),
                arguments("468234u0gjiosdk4390wefjivdskwep9+wepafsd@$$€","11111010101010100101011010101201212910nujhgksdl@//()"),
                arguments("1","1")
        );
    }
}
