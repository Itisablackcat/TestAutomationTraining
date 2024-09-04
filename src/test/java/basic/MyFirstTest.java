package basic;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest {
    @Test
    public void myFirstTest() {
        System.out.println("This is my first java test");
    }

    @Test
    public void failedTest() {
        Assert.assertTrue(false, "Expected true, got false");

    }
}
