import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LionTest {

    private Feline feline;
    private Lion lion;

    @BeforeEach
    public void setUp() throws Exception {
        // Создали мок объект Feline
        feline = Mockito.mock(Feline.class);
        // Создали экземпляра Lion с мок объектом Feline
        lion = new Lion("Самец", feline);
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        // Проверка что у самца есть грива
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testGetKittens() {
        // Мок объекта: когда вызывается метод getKittens(), возвращать 2
        Mockito.when(feline.getKittens()).thenReturn(2);

        // Проверяем что метод getKittens() класса Lion возвращает 2
        assertEquals(2, lion.getKittens());
    }

    @Test
    public void testGetFood() throws Exception {
        // Мок объекта: когда вызывается метод getFood("Хищник"), возвращать список с "Мясо"
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));

        // Получаем результат работы метода getFood() класса Lion, проверяем его
        List<String> food = lion.getFood();
        assertEquals(List.of("Мясо"), food);
    }

    @Test
    public void shouldThrowExceptionForInvalidSex() {
        // Проверка что при некорректном поле выбрасывается исключение
        Feline feline = new Feline();
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Неизвестно", feline);
        });

        // Можно также проверить сообщение исключения, если необходимо
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}

