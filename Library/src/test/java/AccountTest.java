import com.step.bank.Account;
import com.step.bank.InvalidAccountNumberException;
import com.step.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {

    private Account account1;

    @Before
    public void setUp() throws Exception, MinimumBalanceException, InvalidAccountNumberException {
        account1 = new Account("1234-1234", 1000);
    }

    @Test
    public void checkBalance(){
        assertThat(account1.getBalance(),is(1000.0));
    }

    @Test
    public void checkAccountNumber(){
        assertThat(account1.getAccountNumber(),is("1234-1234"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        new Account("1234-7823", 200);
    }

    @Test
    public void withdraw() throws MinimumBalanceException, InvalidAccountNumberException {
        Account account = new Account("1237-8678", 5000);
        account.withdraw(1000);
        assertThat(account.getBalance(),is(4000.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkBalanceForWithdrawal() throws MinimumBalanceException {
        account1.withdraw(500);
        assertThat(account1.getBalance(),is(1000.0));
    }
}
