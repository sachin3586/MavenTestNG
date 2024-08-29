package parameter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserParameter1 {
    public WebDriver driver;
    @Parameters({"browserName"})
    @BeforeMethod

    public void beforeMethod(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://www.powergrid.in/");
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://www.powergrid.in/");
            driver.manage().window().maximize();

        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.get("https://www.powergrid.in/");
            driver.manage().window().maximize();
        }

    }
    @Test
    public void display(){
        System.out.println("Power grid websites up and running");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
