package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NormalDP1 {
    @DataProvider(name="dataprovider")
    public Object[][] dpMethod(){
        return new Object[][]{
                {"TCS"},
                {"ACCENTURE"},
                {"HCL"},
                {"Infy"},

        };
    }
    @Test(dataProvider = "dataprovider")
    public void test(String data){
        System.out.println(data);

    }
}
