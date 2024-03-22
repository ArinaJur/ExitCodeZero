import org.testng.annotations.Test;

public class BSTest {
    @Test
    public void test() {
        System.out.println("NOTHING THERE");
    }
    @Test( enabled=false )
    public void someTest() {
        //test code
    }
}
