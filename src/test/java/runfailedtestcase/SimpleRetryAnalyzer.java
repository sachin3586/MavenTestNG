package runfailedtestcase;

import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class SimpleRetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int MAX_RETRIES = 5; // Set the maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (count < MAX_RETRIES && result.getStatus() == ITestResult.FAILURE) {
            count++;
            return true; // Retry the test
        }
        return false; // Don't retry
    }

    @Test(retryAnalyzer = SimpleRetryAnalyzer.class)
    public void myTest() {
        Assert.fail();

    }

}
