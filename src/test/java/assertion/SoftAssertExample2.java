package assertion;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample2 {


    @Test
    public void display1(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.fail();
        System.out.println("Display 1");

        softAssert.assertAll();
    }
    @Test
    public void display2(){
        System.out.println("Display 2");
    }
    @Test
    public void display3(){
        System.out.println("Display 3");
    }
    @Test
    public void display4(){
        System.out.println("Display 4");
    }
}
