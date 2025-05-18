package Day5_SOLID_Principles.LSP.Followed;

import java.util.List;

interface DepositOnlyAccount {
    void deposit(double amount);
}

interface WithdrawableAccount extends DepositOnlyAccount {
    void withdraw(double amount);
}

class SavingAccount implements WithdrawableAccount {
    private double balance = 0;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }
}

class CurrentAccount implements WithdrawableAccount {
    private double balance = 0;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }
}

class FixedTermAccount implements DepositOnlyAccount {
    private double balance = 0;

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}

class BankClient {
    private List<WithdrawableAccount> withdrawableAccounts;
    private List<DepositOnlyAccount> depositOnlyAccounts;

    public BankClient(List<WithdrawableAccount> withdrawableAccounts, List<DepositOnlyAccount> depositOnlyAccounts) {
        this.withdrawableAccounts = withdrawableAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions() {
        for (WithdrawableAccount acc : withdrawableAccounts) {
            acc.deposit(1000);
            acc.withdraw(500);
        }
        for (DepositOnlyAccount acc : depositOnlyAccounts) {
            acc.deposit(5000);
        }
    }
}

class Main {
    public static void main(String[] args) {
        List<WithdrawableAccount> withdrawableAccounts = List.of(
                new SavingAccount(),
                new CurrentAccount()
        );

        List<DepositOnlyAccount> depositOnlyAccounts = List.of(
                new FixedTermAccount()
        );

        BankClient client = new BankClient(withdrawableAccounts, depositOnlyAccounts);
        client.processTransactions();
    }
}