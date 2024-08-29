package parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParameterizationExample1 {
    public WebDriver driver;
    @Parameters({"mobileName"})
    @Test
    public void show(String mobileName) throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver=new EdgeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        WebElement searchElement = driver.findElement(By.xpath("//textarea[@title='Search']"));
        searchElement.sendKeys(mobileName);
        Thread.sleep(3000);
        searchElement.sendKeys(Keys.ENTER);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        driver.quit();
    }

}
