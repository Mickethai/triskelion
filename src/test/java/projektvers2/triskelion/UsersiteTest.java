package projektvers2.triskelion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsersiteTest {
    private WebDriver driver;

    @AfterEach
    public void quitDriver(){
        driver.quit();
    }
    /*
        Chrome tests
    */
    @Test
    public void shouldGoToLinkedinWhenClickedInChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
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
    public void shouldGoToGithubWhenClickedInChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-sm-4~ .col-sm-4+ .col-sm-4 a")).click();
        assertThat(driver.getCurrentUrl(),containsString("github"));
        assertEquals("https://github.com/Mickethai", driver.getCurrentUrl());
    }
    @Test
    public void shouldGoToTeknikhogskolanWhenClickedInChrome(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".bg-4 a")).click();
        assertEquals("https://teknikhogskolan.se/", driver.getCurrentUrl());
    }
    /*
        Edge tests
    */
    @Test
    public void shouldGoToLinkedinWhenClickedInEdge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
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
    public void shouldGoToGithubWhenClickedInEdge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
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
    public void shouldGoToTeknikhogskolanWhenClickedInEdge(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".bg-4 a")).click();
        assertEquals("https://teknikhogskolan.se/", driver.getCurrentUrl());
    }
    /*
        Safari tests CURRENTLY DISABLED
    */
    @Disabled
    @Test
    public void shouldGoToLinkedinWhenClickedInSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"col-sm-4\", \" \" )) and (((count(preceding-sibling::*) + 1) = 2) and parent::*)]//a")).click();
        assertThat(driver.getCurrentUrl(), containsString("linkedin"));
        // assertEquals failar då linkedin kör en safety check först. Tror jag i alla fall, idk
        //assertEquals("https://www.linkedin.com/in/mickekarlsson/", driver.getCurrentUrl());
    }
    @Disabled
    @Test
    public void shouldGoToGithubWhenClickedInSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();;
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-sm-4~ .col-sm-4+ .col-sm-4 a")).click();
        // assertThat kan man ta bort men palla
        assertThat(driver.getCurrentUrl(),containsString("github"));
        assertEquals("https://github.com/Mickethai", driver.getCurrentUrl());
    }
    @Disabled
    @Test
    public void shouldGoToTeknikhogskolanWhenClickedInSafari(){
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".bg-4 a")).click();
        assertEquals("https://teknikhogskolan.se/", driver.getCurrentUrl());
    }
    /*
        Firefox tests
    */
    @Test
    public void shouldGoToLinkedinWhenClickedInFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).click();
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[contains(concat( \" \", @class, \" \" ), concat( \" \", \"col-sm-4\", \" \" )) and (((count(preceding-sibling::*) + 1) = 2) and parent::*)]//a")).click();
        assertThat(driver.getCurrentUrl(), containsString("linkedin"));
        // assertEquals failar då linkedin kör en safety check först. Tror jag i alla fall, idk
        //assertEquals("https://www.linkedin.com/in/mickekarlsson/", driver.getCurrentUrl());
    }
    @Test
    public void shouldGoToGithubWhenClickedInFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).click();
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".col-sm-4~ .col-sm-4+ .col-sm-4 a")).click();
        // assertThat kan man ta bort men palla
        assertThat(driver.getCurrentUrl(),containsString("github"));
        assertEquals("https://github.com/Mickethai", driver.getCurrentUrl());
    }
    @Test
    public void shouldGoToTeknikhogskolanWhenClickedInFirefox(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("http://localhost:8080/login.html");
        assertEquals("http://localhost:8080/login.html", driver.getCurrentUrl());
        driver.findElement(By.id("username")).sendKeys("Mickethai");
        driver.findElement(By.id("password")).sendKeys("pass");
        driver.findElement(By.id("submit")).click();
        assertEquals("http://localhost:8080/usersite",driver.getCurrentUrl());
        driver.findElement(By.cssSelector(".bg-4 a")).click();
        assertEquals("https://teknikhogskolan.se/", driver.getCurrentUrl());
    }
}
