package assertion;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample
{
    // In hard assertion if one test case fail next line code will not be executed in test  case and same test case
    // marked as fail

    public WebDriver driver;

    @Test
    public void annotationMethod1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ongcindia.com");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);
       // Assert.assertEquals(title,"Ongc","Expected and actual result should be same ");

        WebElement logo = driver.findElement(By.xpath("//img[@src='/documents/77751/2132071/ongcLogo.jpg']"));
Assert.assertTrue(logo.isDisplayed());

        driver.quit();

    }

}
