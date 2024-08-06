package annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BeforeAfterMethod {
    public WebDriver driver;

    @BeforeMethod
    public void setup(){

        System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.nmdc.co.in");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
      //  wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    @AfterMethod
    public void close(){
        driver.close();
    }

    @Test
    public void login(){
        System.out.println("login successfully");
    }
    @Test
    public void homePage(){
        System.out.println("Homepage displayed");
    }
}
