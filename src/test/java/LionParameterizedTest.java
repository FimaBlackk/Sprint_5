import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParameterizedTest {

    // Параметризованный тест с JUnit 5
    @ParameterizedTest
    @CsvSource({
            "Самец, true",  // Для самца ожидается наличие гривы
            "Самка, false"  // Для самки ожидается отсутствие гривы
    })
    public void testDoesHaveMane(String sex, boolean expectedHasMane) throws Exception {
        // Создаем экземпляр класса Lion с заданным полом
        Lion lion = new Lion(sex, new Feline());

        // Проверяем соответствует ли результат ожиданиям
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}


