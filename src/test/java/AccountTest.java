import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final boolean expected;
    public AccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][]{
                {"И Ё", true},
                {"Александра Смирнова", true},
                {"ИЁ", false},
                {"Александра Смирновых", false},
                {"Александра О Коннор", false},
                {"ИЁ ", false},
                {" АлександраСмирнова", false},
                {"", false},
                {null, false}
        };
    }

        @Test
        @DisplayName("Check name length and spaces")
        @Description("Checking that name has length and spaces according to requirements")
        public void checkNameLengthAndSpaces () {
            Account account = new Account(name);
            boolean actual = account.checkNameToEmboss();
            assertEquals("Фактический результат отличается от ожидаемого", expected, actual);
        }
    }



