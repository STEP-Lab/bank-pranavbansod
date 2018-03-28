import com.step.bank.CreditTransaction;
import com.step.bank.DebitTransaction;
import com.step.bank.Transaction;
import com.step.bank.Transactions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.io.PrintWriter;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class TransactionsTest {
    private Transactions transactions;
    @Before
    public void setUp() throws Exception {
        transactions = new Transactions();
    }

    @Test
    public void mustRecordDebitTransaction() {
        transactions.debit(1000,"Patel");
        Transaction debitTrans = new DebitTransaction(1000, "Patel", new Date());
        assertThat(transactions.getList(),hasItem(debitTrans));
    }

    @Test
    public void mustRecordCreditTransaction() {
        transactions.credit(1000,"Patel");
        Transaction creditTrans = new CreditTransaction(1000, "Patel", new Date());
        assertThat(transactions.getList(),hasItem(creditTrans));
    }


    @Test
    public void filterTransactionByAmount() {
        transactions.credit(2000,"1234-6567");
        transactions.credit(5000,"1234-6567");
        transactions.credit(6000,"1234-6567");
        Transactions filterTransaction = transactions.filterByAmountGreaterThan(2500);
        assertThat(filterTransaction.getList(),hasItems(new CreditTransaction(5000,"1234-6567")));
    }

    @Test
    public void filterTransactionByDate() {
        Date date = new Date(2018,3,28);
        transactions.credit(1000,"Patel",date);
        transactions.debit(400,"Patel",date);
        Date olderDate = new Date(2018,3,27);
        Transactions expected = this.transactions.filterByDateAfter(olderDate);
        assertThat(expected.getList(),hasItem(new CreditTransaction(1000,"Patel",date)));
        assertThat(expected.getList(),hasItem(new DebitTransaction(400,"Patel",date)));
    }

    @Test
    public void getAllCreditTransaction() {
        transactions.debit(1000,"Patel");
        transactions.credit(400,"Patel");
        transactions.debit(1400,"Patel");
        Transactions credits = this.transactions.getAllCredit();
        assertThat(credits.getList(),hasItem(new CreditTransaction(400,"Patel")));
    }

    @Test
    public void getAllDebitTransactions() {
        transactions.debit(1000,"Patel");
        transactions.credit(400,"Patel");
        transactions.debit(1400,"Patel");
        Transactions credits = this.transactions.getAllDebit();
        assertThat(credits.getList(),hasItem(new DebitTransaction(1000,"Patel")));
        assertThat(credits.getList(),hasItem(new DebitTransaction(1400,"Patel")));
    }

    //    @Test
//    public void printTransaction() {
//        PrintWriter writer = new PrintWriter("the-file-name.txt", "UTF-8");
//        transactions.print(printWriter);
//    }

}
