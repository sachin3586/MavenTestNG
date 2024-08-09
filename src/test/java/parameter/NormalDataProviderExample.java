package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NormalDataProviderExample {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {

        return new Object[][] {
                { "AUDI" },
                { "TATA" },
                { "FORD" },
                {"HYUNDAI"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void myTest(String data) {
        System.out.println("Data is: " + data);
    }
}




