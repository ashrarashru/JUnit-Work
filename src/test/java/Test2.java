import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Test2 {

    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    @DisplayName("User Registration Form")
    public void userRegistration() throws InterruptedException {
        driver.get("https://demo.wpeverest.com/user-registration/guest-registration-form");
        List <WebElement> inputFields =  driver.findElements(By.className("ur-frontend-field"));
        inputFields.get(0).sendKeys("Ashrar"); //First Name
        inputFields.get(3).sendKeys("Hasan"); //Last Name
        inputFields.get(1).sendKeys("aabbcd@yahoo.com"); //User Email
        inputFields.get(4).click(); //Select Gender Male
        inputFields.get(2).sendKeys("G7#bW2@pL9"); //Set Password

        List <WebElement> date = driver.findElements(By.className("flatpickr-input"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '1998-12-09')", date.get(0)); //set DOB

        inputFields.get(10).sendKeys("Bangladeshi"); //Nationality
        inputFields.get(8).sendKeys("01679253707"); //Phone Number
        inputFields.get(11).sendKeys("Bangladesh"); //Country

        Utils.scroll(driver,200);

        inputFields.get(9).sendKeys("0169253707"); //Emergency Contact

        js.executeScript("arguments[0].setAttribute('value', '2025-05-13')", date.get(1)); //Set Date

        Utils.scroll(driver,200);

        inputFields.get(13).sendKeys("2"); //Country
        inputFields.get(14).sendKeys("504"); //Country

        Utils.scroll(driver,200);

        inputFields.get(15).sendKeys("Recent Graduate from Dhaka City College"); //Info

        Utils.scroll(driver,200);
        inputFields.get(17).click(); //Parking
        inputFields.get(18).click(); //room

        Utils.scroll(driver,200);
        inputFields.get(21).click(); //Food

        inputFields.get(27).click(); // Options
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER).perform();
        Utils.scroll(driver,200);

        inputFields.get(28).click(); // Terms and Conditions
        driver.findElement(By.className("ur-submit-button")).click(); //Submit Button
        Thread.sleep(4000);
        Utils.scroll(driver,200);

        List <WebElement> messages = driver.findElements(By.cssSelector("ul"));
        String getMessage = messages.get(9).getText();
        String expMessage = "User successfully registered.";
        Assertions.assertTrue(getMessage.contains(expMessage));
        System.out.println("\n" + getMessage + "\n");
    }
}
