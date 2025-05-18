package Day5_SOLID_Principles.LSP.Violated;

interface Account {
    void deposit(double amount);
    void withdraw(double amount);
}

class SavingAccount implements Account {
    private double balance = 0;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited in SavingAccount: " + amount);
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn from SavingAccount: " + amount);
    }
}

class FixedDepositAccount implements Account {
    private double balance = 1000;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited in FixedDepositAccount: " + amount);
    }

    // ❌ This violates LSP because this account type cannot allow withdrawal,
    // but it's forced to implement withdraw() due to the interface.
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Withdrawals not allowed in FixedDepositAccount.");
    }
}

class BankClient {
    public static void main(String[] args) {
        Account saving = new SavingAccount();
        saving.deposit(500);
        saving.withdraw(200);

        Account fixed = new FixedDepositAccount();
        fixed.deposit(1000);

        // ❌ This will crash at runtime - violating LSP
        fixed.withdraw(300);
    }
}
