package annotations.dependsongroup;

import org.testng.annotations.Test;

public class DependsOnGroupExample {
    @Test(groups = {"smoke"})

    public void test1() {

        System.out.println("This is test 1 method");
    }

    @Test(dependsOnGroups = {"smoke"})
    public void test2() {
        System.out.println("This is test 2 method");
    }

    @Test
    public void test3() {

        System.out.println("This is test 3 method");
    }

    @Test
    public void test4() {

        System.out.println("This is test 4 method");
    }
}
