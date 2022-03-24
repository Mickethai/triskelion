package projektvers2.triskelion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersiteChromeTest {
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
    public void shouldGoToLinkedinWhenClicked(){
        driver.get("http://localhost:8080/login.html");
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"col-sm-4\", \" \" )) and (((count(preceding-sibling::*) + 1) = 2) and parent::*)]//a")).click();
        assertThat(driver.getCurrentUrl(), containsString("linkedin"));
        // assertEquals failar då linkedin kör en safety check först. auth nånting tror jag den hette
        //assertEquals("https://www.linkedin.com/in/mickekarlsson/", driver.getCurrentUrl());
    }
    @Test
    public void shouldGoToGithubWhenClicked(){
        driver.get("http://localhost:8080/login.html");
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-sm-4~ .col-sm-4+ .col-sm-4 a")).click();
        assertThat(driver.getCurrentUrl(),containsString("github"));
        assertEquals("https://github.com/Mickethai", driver.getCurrentUrl());
    }
    @Test
    public void shouldGoToTeknikhogskolanWhenClicked(){
        driver.get("http://localhost:8080/login.html");
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".bg-4 a")).click();
        assertEquals("https://teknikhogskolan.se/", driver.getCurrentUrl());
    }
}
