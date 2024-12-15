import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("12345", 1000.0);
    }

    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), "Баланс повинен бути 1500.0 після поповнення на 500.0");
    }

    @Test
    void testWithdrawSuccess() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), "Баланс повинен бути 700.0 після зняття 300.0");
    }

    @Test
    void testWithdrawFail() {
        account.withdraw(1200.0);
        assertEquals(1000.0, account.getBalance(), "Баланс повинен залишитись 1000.0 після невдалої спроби зняття");
    }

    @Test
    void testTransferSuccess() {
        account.transfer(500.0, "67890");
        assertEquals(500.0, account.getBalance(), "Баланс повинен бути 500.0 після переказу 500.0");
    }

    @Test
    void testTransferFail() {
        account.transfer(1500.0, "67890");
        assertEquals(1000.0, account.getBalance(), "Баланс повинен залишитись 1000.0 після невдалої спроби переказу");
    }

    @Test
    void testAccountCreation() {
        assertEquals("12345", account.getAccountNumber(), "Номер рахунку повинен відповідати заданому");
        assertEquals(1000.0, account.getBalance(), "Баланс повинен відповідати початковому значенню");
    }
}
