import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Parameter
    public String sex;

    @Parameter(1)
    public boolean expected;

    @Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void constructorAndDoesHaveManeTest() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expected, lion.doesHaveMane());
    }
}
