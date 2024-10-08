package annotations;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EnabledFalse {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

    @Test(invocationCount =3)
    public void test() {
       // Assert.fail();
        System.out.println("This is test method");
    }

    @Test(enabled = false)
    public void test1() {
        System.out.println("This is test1 method");
    }
}
