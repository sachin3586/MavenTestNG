package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NormalMultipleDataProviderExample {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod() {
        return new Object[][] {
                { "Splendoor" ,1},
                { "Shine" ,2},
                { "Royal Enfield" , 3 }
        };
    }

    @Test(dataProvider = "data-provider")
    public void display(String data , int number) {
        System.out.println("Data is: " + data + " "+number);
    }
}
