import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void getKittensWithParam() {
        Assert.assertEquals(3, feline.getKittens(3));
        Mockito.verify(feline, Mockito.times(1)).getKittens(3);
    }

    @Test
    public void getKittensNoParamInvokeGetKittensWith1() {
        feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void eatMeatTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> result = feline.eatMeat();
        //Проверяем что внутренний метод вызвался один раз и с корректным параметром.
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
        //Проверяем что метод отдает корректно полученные значения от стаба.
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
    }

    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        Assert.assertEquals("Неверно указан вид!", "Кошачьи", feline.getFamily());
    }
}
