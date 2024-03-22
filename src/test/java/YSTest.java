import org.testng.annotations.Test;

public class YSTest {

    @Test
    public void test()
    {
        System.out.println("Hi!");
    }

    @Test(enabled = false)
    public void someTest() {
        // test code
    }
}
