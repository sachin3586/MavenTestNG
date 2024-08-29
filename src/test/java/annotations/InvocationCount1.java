package annotations;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvocationCount1 {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //WebDriverManager.chromedriver().setup();
       // WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("https://ntpc.co.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       /* WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element))

        */
    }
    @AfterMethod
    public void teardown(){
        driver.close();

    }
    @Test(invocationCount = 2,invocationTimeOut = 5)
    public void homePage(){
        System.out.println("HomePage display successfully");
    }
}
