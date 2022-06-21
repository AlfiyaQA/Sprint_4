import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.Account;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @Test
    @DisplayName("Check name has 3 symbols with single space")
    @Description("Positive test where there is 3 symbols and only single space in name")
    public void checkNameHas3SymbolsWithSingleSpace() {
        Account account = new Account("И Ё");
        boolean result = account.checkNameToEmboss();
        assertTrue(result);
    }

    @Test
    @DisplayName("Check name has 19 symbols with single space")
    @Description("Positive test where there is 19 symbols and only single space in name")
    public void checkNameHas19SymbolsWithSingleSpace() {
        Account account = new Account("Александра Смирнова");
        boolean result = account.checkNameToEmboss();
        assertTrue(result);
    }

    @Test
    @DisplayName("Check name cannot have 2 symbols")
    @Description("Negative test where there is 2 symbols without any space in name")
    public void checkNameCannotHave2Symbols() {
        Account account = new Account("ИЁ");
        boolean result = account.checkNameToEmboss();
        assertFalse(result);
    }

    @Test
    @DisplayName("Check name cannot have 20 symbols")
    @Description("Negative test where there is 20 symbols in name including single space")
    public void checkNameCannotHave20Symbols() {
        Account account = new Account("Александра Смирновых");
        boolean result = account.checkNameToEmboss();
        assertFalse(result);
    }

    @Test
    @DisplayName("Check name cannot have several spaces")
    @Description("Negative test where there are several spaces in name which consists of 19 symbols")
    public void checkNameCannotHaveSeveralSpaces() {
        Account account = new Account("Александра О Коннор");
        boolean result = account.checkNameToEmboss();
        assertFalse(result);
    }

    @Test
    @DisplayName("Check name cannot end with space")
    @Description("Negative test where name ends with space")
    public void checkNameCannotEndWithSpace() {
        Account account = new Account("ИЁ ");
        boolean result = account.checkNameToEmboss();
        assertFalse(result);
    }

    @Test
    @DisplayName("Check name cannot start with space")
    @Description("Negative test where name starts with space")
    public void checkNameCannotStartWithSpace() {
        Account account = new Account(" АлександраСмирнова");
        boolean result = account.checkNameToEmboss();
        assertFalse(result);
    }
}
