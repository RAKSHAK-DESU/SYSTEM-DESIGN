# Liskov Substitution Principle (LSP)

## Definition
Subclasses should be substitutable for their base classes. This means that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

---

## Concept Overview

- If class `B` is a subclass of class `A`, then we should be able to replace `A` with `B` without altering the desirable properties of the program (correctness, task performed, etc.).
- In other words, **a child class must be able to stand in for its parent class without causing errors or unexpected behavior.**

Example method call on a base class pointer:
```cpp
randomMethod(A* a) {
    a->m1();
    a->m2();
    a->m3();
}

Example Scenario (Bank Account)
Initial Problem

    We have a Client that processes different types of accounts (Account, SavingAccount, CurrentAccount, FixedDepositAccount).

    The parent class Account defines:

        deposit()

        withdraw()

    The child class FixedDepositAccount overrides the withdraw() method but cannot perform withdrawal (throws exception).

    The client code tightly couples and checks for fixedDepositAcc explicitly, violating Open/Closed Principle (OCP).

for (acc : accounts) {
    if (acc->fixedDepositAcc)
        deposit();
    else {
        deposit();
        withdraw();
    }
}

This is a bad approach because:

    Client is tightly coupled with all other classes.

    Violates OCP.

    Client should only depend on the abstract/interface class.

Corrected Design with Two-Level Hierarchy

We solve the problem by creating a 2-level hierarchy using abstract classes:

    One abstract class for common behavior (like deposit()).

    Another abstract class for extended behavior (like withdraw()).

                        <<abstract>>
              NonWithdrawableAccount
                     deposit();

  Client ------------->*         1-------------> withdrawableAccount (abstract)
                     deposit();                        withdraw();

        fixedDepositAcc                    savingAccount        currentAccount
          deposit()                         deposit()            deposit()
                                           withdraw()           withdraw()


| Principle                     | Description                                                                               |
| ----------------------------- | ----------------------------------------------------------------------------------------- |
| Liskov Substitution Principle | Subtypes must be substitutable for their base types without altering program correctness. |
