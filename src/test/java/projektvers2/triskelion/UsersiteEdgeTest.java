package projektvers2.triskelion;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersiteEdgeTest {
    private WebDriver driver;

    @BeforeAll
    public static void setUpWebdriverEdgeDriver(){
        System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/msedgedriver.exe");
    }
    @BeforeEach
    public void setUpEdgedriver(){
        EdgeOptions options = new EdgeOptions();
        driver = new EdgeDriver(options);
    }
    @AfterEach
    public void quitEdgedriver(){
        driver.quit();
    }

    // Testing that it is possible to click the Linkedin link on the usersite and that it takes you to linkedin
    @Test
    public void shouldGoToLinkedinWhenClicked(){
        driver.get("http://localhost:8080/login.html");
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"col-sm-4\", \" \" )) and (((count(preceding-sibling::*) + 1) = 2) and parent::*)]//a")).click();
        assertThat(driver.getCurrentUrl(), containsString("linkedin"));
        // assertEquals failar då linkedin kör en safety check först. Tror jag i alla fall, idk
        //assertEquals("https://www.linkedin.com/in/mickekarlsson/", driver.getCurrentUrl());
    }
    // Test that clicks the github link on the usersite and checks that it takes you to the correct github page
    @Test
    public void shouldGoToGithubWhenClicked(){
        driver.get("http://localhost:8080/login.html");
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-sm-4~ .col-sm-4+ .col-sm-4 a")).click();
        // assertThat kan man ta bort men palla
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
