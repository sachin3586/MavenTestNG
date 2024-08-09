package parameter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizationExample1 extends BrowserWithParameter {
    public  WebDriver driver;
    WebDriverWait wait;
    @Parameters({"carName"})
    @Test
    public void parameterExample2(String carName) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement searchTextbox = driver.findElement(By.xpath("//textarea[@name='q']"));
        searchTextbox.sendKeys(carName);
        searchTextbox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.quit();
        // driver.close();
    }

}
