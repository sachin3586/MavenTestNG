package annotations;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependsOnMethod {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before method");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("After method");
    }

    @Test()
    public void test() {

        Assert.fail();
        System.out.println("This is test method");
    }

    @Test(dependsOnMethods = "test")
    public void test1() {
        System.out.println("This is test1 method");
    }
}

