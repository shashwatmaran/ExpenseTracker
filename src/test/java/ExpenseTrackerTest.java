import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpenseTrackerTest {

    ExpenseTracker service = new ExpenseTracker();

    @Test
    void testRegisterUser() {
        String result = service.registerUser("john", "1234");
        assertEquals("User registered successfully", result);

        // Duplicate case
        String duplicate = service.registerUser("john", "1234");
        assertEquals("User already exists", duplicate);
    }

    @Test
    void testAddexpense() {
        String result = service.addExpense("Laptop", 50000);
        assertEquals("Expense added", result);
    }

    @Test
    void testFindExpense() {
        service.addExpense("Phone", 20000);

        ExpenseTracker.Expense expense = service.findExpenseByName("Phone");
        assertNotNull(expense);
        assertEquals(20000, expense.getPrice());
    }

    @Test
    void testUpdateExpensePrice() {
        service.addExpense("Tablet", 15000);

        String result = service.updateExpensePrice("Tablet", 18000);
        assertEquals("Price updated", result);

        ExpenseTracker.Expense updated = service.findExpenseByName("Tablet");
        assertEquals(18000, updated.getPrice());
    }
}