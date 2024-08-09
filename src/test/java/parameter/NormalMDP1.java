package parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NormalMDP1 {
    @DataProvider(name = "data-provider")
    public Object[][] dpMethod1(){
        return new  Object [][]{
                {"Hyundai",1},
                {"TATA",2},
                {"MARURI",3}

        };
    }
    @Test(dataProvider = "data-provider")
    public void didplay1(String data ,int number){
        System.out.println("Data is " + data + " number is " + number);
    }
}
