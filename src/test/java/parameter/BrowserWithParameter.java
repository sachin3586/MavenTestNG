package parameter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BrowserWithParameter {
    public WebDriver driver;
    @Parameters({"browserName"})
    @BeforeMethod
    public void beforeMethod(String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\ChromeDriver\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver","C:\\Users\\lenovo\\Desktop\\Testing\\Driver\\edgedriver\\msedgedriver.exe");

            driver=new EdgeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
        }

    }
    @Test
    public void display(){
        System.out.println("TC run successfully");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();

    }
}
