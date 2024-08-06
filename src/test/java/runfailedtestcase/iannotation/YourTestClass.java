package runfailedtestcase.iannotation;

import org.testng.annotations.Test;

public class YourTestClass {
    @Test
    public void testMethod() {
        // Your test code here
        System.out.println("This is testMethod");
       // assert false : "This test will fail to demonstrate retry.";
    }

    @Test
    public void testShow() {
        // Your test code here
        System.out.println("This is testShow");
        assert false : "This test will fail to demonstrate retry.";
    }
}
