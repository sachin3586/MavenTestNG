package annotations;

import org.testng.annotations.Test;

public class PriorityInTestNG

    // Priority may be prositive ,negative, char also
{
    @Test(priority = 1)
    public void test(){

        System.out.println("This is  1 method");
    }
    @Test (priority = 'B')
    public void test1(){
        System.out.println("This is 2 method");
    }
    @Test (priority = -1)
    public void test2(){
        System.out.println("This is 3 method");
    }
}
