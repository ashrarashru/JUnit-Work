import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Test3 {

    WebDriver driver;
@BeforeAll
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

@Test
@DisplayName("Scrap all data from website")
    public void scrapData() throws IOException {
        driver.get("https://dsebd.org/latest_share_price_scroll_by_value.php");
        FileWriter writer = new FileWriter("./src/test/resources/data.txt");

        WebElement fullTable =  driver.findElement(By.className("floatThead-wrapper"));
        List <WebElement> rowGroup = fullTable.findElements(By.tagName("tr"));

        for(WebElement row : rowGroup){
            List<WebElement> cells = row.findElements(By.tagName("td"));
                for(WebElement cellValue : cells){
                    System.out.print(cellValue.getText() + "  ");
                    writer.write(cellValue.getText() + "  ");
            }
            System.out.println();
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }
}
