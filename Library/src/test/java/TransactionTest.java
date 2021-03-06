import com.step.bank.CreditTransaction;
import com.step.bank.DebitTransaction;
import com.step.bank.Transaction;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransactionTest {
    @Test
    public void mustCreateDebitTransaction() {
        Date date = new Date();
        Transaction transaction = new DebitTransaction(1000, "AnotherAccount", date);
        assertThat(transaction.getDate(), is(date));
    }

    @Test
    public void mustCreateCreditTransaction() {
        Date date = new Date();
        Transaction transaction = new CreditTransaction(1000, "AnotherAccount", date);
        assertThat(transaction.getDate(), is(date));
    }

}