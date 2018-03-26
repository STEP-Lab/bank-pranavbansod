import com.step.bank.Account;
import com.step.bank.AccountNumber;
import com.step.bank.InvalidAccountNumberException;
import com.step.bank.MinimumBalanceException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTest {

    private Account account1;
    private AccountNumber number;

    @Before
    public void setUp() throws Exception, MinimumBalanceException, InvalidAccountNumberException {
        number =  AccountNumber.createAccountNumber("1234-1234");
        account1 =  Account.createAccount(number, 1000);
    }

    @Test
    public void checkBalance() {
        assertThat(account1.getBalance(),is(1000.0));
    }

    @Test
    public void checkAccountNumber(){
        assertThat(account1.getAccountNumber(),is("1234-1234"));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkMinimumBalance() throws MinimumBalanceException, InvalidAccountNumberException {
        AccountNumber number =  AccountNumber.createAccountNumber("1234-1234");
        Account.createAccount(number, 200);
    }

    @Test
    public void withdraw() throws MinimumBalanceException, InvalidAccountNumberException {
        AccountNumber number =  AccountNumber.createAccountNumber("1234-1234");
        Account account = Account.createAccount(number, 5000);
        account.withdraw(1000);
        assertThat(account.getBalance(),is(4000.0));
    }

    @Test(expected = MinimumBalanceException.class)
    public void checkBalanceForWithdrawal() throws MinimumBalanceException {
        account1.withdraw(500);
        assertThat(account1.getBalance(),is(1000.0));
    }
}
