package parameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserWithParameter1 {
    public WebDriver driver;
    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.get("https://www.hcltech.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            /* WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));

            wait.until(ExpectedConditions.visibilityOfElementLocated(ele));

             */

        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\edgedriver.exe");

            driver=new EdgeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

           /* WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(ele));

            */
        }
        else if (browserName.equalsIgnoreCase("gecko")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\geckodriver.exe");
            driver=new FirefoxDriver();
            driver.get("https://www.onlinesbi.sbi/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            /* WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeSelected(element));

             */
        }

    }
    @Test
    public void showData(){
        System.out.println("Browsers with parameters run successfully");
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
