import com.step.bank.CreditTransaction;
import com.step.bank.DebitTransaction;
import com.step.bank.Transactions;
import org.junit.Test;

import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class TransactionsTest {
    @Test
    public void mustRecordDebitTransaction() {
        Transactions transactions = new Transactions();
        transactions.debit(1000,"Patel");
        assertThat(transactions.list,hasItem(new DebitTransaction(new Date(),1000,"Patel")));
    }

    @Test
    public void mustRecordCreditTransaction() {
        Transactions transactions = new Transactions();
        transactions.credit(1000,"Patel");
        assertThat(transactions.list,hasItem(new CreditTransaction(new Date(),1000,"Patel")));
    }
}
