import java.util.*;

public class ExpenseTracker {

    private Map<String, String> users = new HashMap<>();
    private List<Expense> expenses = new ArrayList<>();

    public String registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return "User already exists";
        }
        users.put(username, password);
        return "User registered successfully";
    }

    // 2️⃣ Save expense (name + price)
    public String addExpense(String name, double price) {
        expenses.add(new Expense(name, price));
        return "Expense added";
    }

    // 3️⃣ Generic search function (can be reused for anything)
    public Expense findExpenseByName(String name) {
        for (Expense p : expenses) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // 4️⃣ Generic update function (can be reshaped easily)
    public String updateExpensePrice(String name, double newPrice) {
        for (Expense p : expenses) {
            if (p.getName().equalsIgnoreCase(name)) {
                p.setPrice(newPrice);
                return "Price updated";
            }
        }
        return "expense not found";
    }

    // Inner expense class
    static class Expense {
        private String name;
        private double price;

        public Expense(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}