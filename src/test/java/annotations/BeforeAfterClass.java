package annotations;

import org.testng.annotations.*;

public class BeforeAfterClass {

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before class method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After class method");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After method");
    }
    @Test
    public void test(){
        System.out.println("This is test method");
    }
}
