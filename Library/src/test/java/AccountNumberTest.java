import com.step.bank.AccountNumber;
import com.step.bank.InvalidAccountNumberException;
import org.junit.Test;

public class AccountNumberTest {
    @Test(expected = InvalidAccountNumberException.class)
    public void throwsErrorWhenAccountNumContainsOnlyNumbers() throws InvalidAccountNumberException {
        AccountNumber.createAccountNumber("1234");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void throwsErrorIfAccountNumberContainsAlphabetsOnly() throws InvalidAccountNumberException {
        AccountNumber.createAccountNumber("abcd");
    }

    @Test(expected = InvalidAccountNumberException.class)
    public void throwsErrorWhenAccNumIsShort() throws  InvalidAccountNumberException {
        AccountNumber.createAccountNumber("1234-123");
    }
}