package sprint3.provider;

import org.testng.annotations.DataProvider;

public class CounterDataProvider {

    public static final String data = "Это мой Текст из русских слов и слова dot";

    @DataProvider(name = "negativeTestData")
    public Object[][] negativeTestData() {
        return new Object[][] {
                {null, -1},
                {"", 0}
        };
    }
}
