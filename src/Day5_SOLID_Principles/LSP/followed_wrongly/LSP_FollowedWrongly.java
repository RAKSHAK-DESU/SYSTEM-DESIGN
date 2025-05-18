package Day5_SOLID_Principles.LSP.followed_wrongly;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
}

class SavingAccount implements Account {
    private double balance = 0;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited in SavingAccount: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn from SavingAccount: " + amount);
        } else {
            System.out.println("Insufficient balance in SavingAccount.");
        }
    }
}

class FixedDepositAccount implements Account {
    private double balance = 1000;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited in FixedDepositAccount: " + amount);
    }

    // LSP violation: withdraw method doesn't behave as expected
    @Override
    public void withdraw(double amount) {
        // Fixed Deposit accounts usually do not allow withdrawal until maturity,
        // so this implementation violates the expectations from the Account interface.
        System.out.println("Withdrawal not allowed in FixedDepositAccount.");
        // Note: It doesn't throw an exception, but it breaks the contract implicitly.
    }
}

 class BankClient {
    public static void main(String[] args) {
        Account saving = new SavingAccount();
        saving.deposit(500);
        saving.withdraw(200);  // Works fine

        Account fixed = new FixedDepositAccount();
        fixed.deposit(1000);
        fixed.withdraw(300);   // LSP violation: does nothing or breaks expected behavior
    }
}