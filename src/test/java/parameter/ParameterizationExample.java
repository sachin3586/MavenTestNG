package parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizationExample {
    public WebDriver driver;
@Parameters({"cityName" })
    @Test
    public void verifyNeedOfParameter(String cityName) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait

        WebElement searchTextbox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchTextbox.sendKeys(cityName);
        Thread.sleep(3000);
        searchTextbox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.close();
    }
}
