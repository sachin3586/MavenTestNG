package wipro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class Solution {

    private WebDriver driver;
    private WebDriverWait wait;

    public Solution(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyLoginPageTitle() {

        String title = driver.getTitle();
        assertEquals("Expected Title", title); // Replace "Expected Title" with the actual title you expect
    }

    @Test
    public void testQueryInputAndSubmitButtonPresence() {

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input")));
        Assert.assertNotNull(searchInput, "Search input field is not present on the screen");


        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        Assert.assertNotNull(searchButton, "Search button is not present on the screen");
    }

    @Test
    public void testSearchWithEmptyQuery() {

        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        searchButton.click();

        WebElement errorEmptyQuery = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-empty-query")));
        Assert.assertNotNull(errorEmptyQuery, "Error message for empty query is not displayed");
    }

    @Test
    public void testSearchResultsForQueryIsla() {

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input")));
        searchInput.sendKeys("isla");


        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        searchButton.click();


        List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul.search-results > li")));
        Assert.assertTrue(results.size() > 0, "No search results found for the query 'isla'");
    }

    @Test
    public void testNoResultsFeedback() {

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input")));
        searchInput.sendKeys("castle");


        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        searchButton.click();


        WebElement errorNoResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error-no-results")));
        Assert.assertNotNull(errorNoResults, "No results feedback message is not displayed when there are no matching results");
    }

    @Test
    public void testResultsMatchQuery() {

        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-input")));
        searchInput.sendKeys("Port Royal");


        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-button")));
        searchButton.click();


        List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("ul.search-results > li")));

        Assert.assertTrue(results.size() > 0, "No search results found for the query 'Port Royal'");


        for (WebElement result : results) {
            String resultText = result.getText().toLowerCase();
            Assert.assertTrue(resultText.contains("port royal"), "Search result does not match the query 'Port Royal'");
        }
    }
}
