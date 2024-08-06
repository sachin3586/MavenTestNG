package assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
    public WebDriver driver;
    @Test
    public void annotationMethod1() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://ongcindia.com");
        driver.manage().window().maximize();

        String title = driver.getTitle();
        System.out.println(title);

        SoftAssert softAssert = new SoftAssert();
        //Assert.fail();
        softAssert.assertEquals(title,"Ongc","Expected and actual result should be same ");


        WebElement logo = driver.findElement(By.xpath("//img[@src='/documents/77751/2132071/ongcLogo.jpg']"));
        softAssert.assertTrue(logo.isDisplayed());
        softAssert.assertAll();

        driver.quit();
    }
}
