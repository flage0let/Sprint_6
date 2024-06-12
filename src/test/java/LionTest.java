import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;


public class LionTest {

    @Mock
    private Feline feline;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void constructorExceptionTest() {
        try {
            Lion lion = new Lion("Тест", new Feline());
            Assert.fail("Исключение не выброшено!");
        } catch (Exception e) {
            Assert.assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
        }
    }

    @Test
    public void getKittensTest() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);
        int result = lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
        Assert.assertEquals(1, result);
    }

    @Test
    public void getFoodTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion("Самец", feline);
        List<String> result = lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result);

        //Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }
}
