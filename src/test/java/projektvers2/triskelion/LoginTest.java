package projektvers2.triskelion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.stream.Stream;

public class LoginTest {
    private WebDriver driver;

    @AfterEach
    public void quitDriver(){
        driver.quit();
    }
    /*
        Chrome tests
     */
    @Test
    public void shouldFindWebsiteInChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
    }
    @ParameterizedTest
    @MethodSource("loginParameters")
    public void shouldLoginToUsersiteInChrome(String username, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        WebElement userTextbox = driver.findElement(By.id("username"));
        userTextbox.clear();
        userTextbox.sendKeys(username);
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite", driver.getCurrentUrl());
    }
    @ParameterizedTest
    @MethodSource("falseLoginParameters")
    public void shouldNotLoginToUsersiteInChrome(String username, String password) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/login-error.html", driver.getCurrentUrl());
    }
    /*
        Edge tests
    */
    @Test
    public void shouldFindWebsiteInEdge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
    }
    @ParameterizedTest
    @MethodSource("loginParameters")
    public void shouldLoginToUsersiteInEdge(String username, String password) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        WebElement userTextbox = driver.findElement(By.id("username"));
        userTextbox.clear();
        userTextbox.sendKeys(username);
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite", driver.getCurrentUrl());
    }

    @ParameterizedTest
    @MethodSource("falseLoginParameters")
    public void shouldNotLoginToUsersiteInEdge(String username, String password) {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/login-error.html", driver.getCurrentUrl());
    }
    /*
        Safari tests  CURRENTLY DISABLED
     */
    @Disabled("Disabled on Windows")
    @Test
    public void shouldFindWebsiteInSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
    }
    @Disabled("Disabled on Windows")
    @ParameterizedTest
    @MethodSource("loginParameters")
    public void shouldLoginToUsersiteInSafari(String username, String password) {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        WebElement userTextbox = driver.findElement(By.id("username"));
        userTextbox.clear();
        userTextbox.sendKeys(username);
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite", driver.getCurrentUrl());
    }
    @Disabled("Disabled on Windows")
    @ParameterizedTest
    @MethodSource("falseLoginParameters")
    public void shouldNotLoginToUsersiteInSafari(String username, String password) {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/login-error.html", driver.getCurrentUrl());
    }
    /*
        Firefox tests och varför måste man använda click() istället för sendKeys(keys.ENTER)
    */
    @Test
    public void shouldFindWebsiteInFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
    }
    @ParameterizedTest
    @MethodSource("loginParameters")
    public void shouldLoginToUsersiteInFirefox(String username, String password) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        WebElement userTextbox = driver.findElement(By.id("username"));
        userTextbox.clear();
        userTextbox.sendKeys(username);
        WebElement passwordTextbox = driver.findElement(By.id("password"));
        passwordTextbox.clear();
        passwordTextbox.sendKeys(password);
        driver.findElement(By.id("submit")).click();
        assertEquals("http://localhost:8080/usersite", driver.getCurrentUrl());
    }
    @ParameterizedTest
    @MethodSource("falseLoginParameters")
    public void shouldNotLoginToUsersiteInFirefox(String username, String password) {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        assertEquals("http://localhost:8080/login-error.html", driver.getCurrentUrl());
    }

    private static Stream<Arguments> loginParameters(){
        return Stream.of(
                arguments("Mickethai", "pass")
        );
    }
    private static Stream<Arguments> falseLoginParameters(){
        return Stream.of(
                arguments("user","password"),
                arguments("user", "wrong"),
                arguments("wrong", "password"),
                arguments("wrong", "wrong"),
                arguments("",""),
                arguments("468234u0gjiosdk4390wefjivdskwep9+wepafsd@$$€","11111010101010100101011010101201212910nujhgksdl@//()"),
                arguments("1","1"),
                arguments("mICKETHAI","PASS"),
                arguments("MiCkEtHaI","PaSs"),
                arguments("MICKETHAI","PASS")
        );
    }
}
