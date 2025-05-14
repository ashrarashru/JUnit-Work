import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Test1 {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void webForm() throws InterruptedException {
        driver.get("https://www.digitalunite.com/practice-webform-learners");
        List <WebElement> input = driver.findElements(By.className("form-control"));
        input.get(0).sendKeys("dd"); // Full Name
        input.get(1).sendKeys("011111"); // Number
        input.get(2).sendKeys("12/12/2011"); // Date
        Thread.sleep(1000);
        WebElement cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        cookies.click();

        input.get(3).sendKeys("aa@gmail.com"); // Email
        input.get(4).sendKeys("Hi, myself aa"); // About Yourself

        Utils.scroll(driver,300);
        String path = new File("./src/test/resources/dp.jpg").getAbsolutePath();
        driver.findElement(By.cssSelector("[type=file]")).sendKeys(path);

        Thread.sleep(1000);
        Utils.scroll(driver,300);

        driver.findElements(By.cssSelector("[type=checkbox]")).get(0).click();
        driver.findElement(By.id("edit-submit")).click();
        Thread.sleep(2000);
        //After Submission

        ArrayList<String> arrayList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(arrayList.get(0));
        String expTest = "Thank you for your submission!";
        String actText =  driver.findElement(By.cssSelector("h1")).getText();
        Assertions.assertTrue(expTest.contains(actText));
        System.out.println("\n" + actText + "\n");
        driver.switchTo().window(arrayList.get(0));

    }
}
