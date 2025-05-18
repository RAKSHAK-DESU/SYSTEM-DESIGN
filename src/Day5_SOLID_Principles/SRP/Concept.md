# 🔄 Single Responsibility Principle (SRP)

## 🎯 What is SRP?

> A class should have **only one reason to change**.  
This means that a class should focus on **only one responsibility or functionality**.

---

## 🧠 Real-World Analogy

### 🏠 Electric Wiring Example

Imagine a house where **all electrical wires are tangled and connected in one place**.  
If there's a problem with one wire:
- It's hard to identify the issue.
- It's difficult to fix or replace the specific wire.

This is similar to software where **a single class is doing too many things** — it becomes hard to debug, maintain, and extend.

---

## 🚨 Problems When SRP (and SOLID) Are Not Followed

1. ❌ **Maintainability**
    - Hard to integrate new features without touching old code.
    - Changes may introduce bugs in unrelated functionalities.

2. ❌ **Readability**
    - Code becomes long and confusing.
    - Hard to understand what each class or method is doing.

3. ❌ **Higher Bug Rate**
    - More responsibilities in one class = more chances for errors.

---

## ✅ Benefits of SRP

- Easier to understand
- Easier to maintain and debug
- Promotes modular and testable code
- Enables clean separation of concerns

---

## 📚 SOLID Design Principles Overview

| Principle | Meaning |
|----------|---------|
| **S** | Single Responsibility Principle (SRP) |
| **O** | Open/Closed Principle (OCP) |
| **L** | Liskov Substitution Principle (LSP) |
| **I** | Interface Segregation Principle (ISP) |
| **D** | Dependency Inversion Principle (DIP) |

---

## 📌 SRP in Practice: "Ek Class, Ek Kaam"

**Bad Design (Violates SRP)**  
A `ShoppingCart` class is doing:
- Calculating price
- Printing invoice
- Saving to database

+------------------------------+
|        ShoppingCart         |
+------------------------------+
| - calcTotalPrice()          |
| - printInvoice()            |
| - saveToDB()                |
+------------------------------+

(🔴 Handles too many things — calculation, printing, and saving)


---

**Good Design (Follows SRP using Composition)**  
Split into multiple classes:
- `ShoppingCart` → Only calculates total price
- `CartPrintInvoice` → Only handles printing
- `CartDBStorage` → Only handles DB save

+--------------------------+        +------------------------+         +----------------------+
|      ShoppingCart        |        |    CartPrintInvoice     |         |    CartDBStorage      |
+--------------------------+        +------------------------+         +----------------------+
| - calcTotalPrice()       |        | - printInvoice()        |         | - saveToDB()          |
+--------------------------+        | - shoppingCart reference|         | - shoppingCart reference|
+------------------------+         +----------------------+

(✅ Each class handles only one responsibility)


---

## ❓ Common Confusion

> Can a class have multiple methods?

✅ Yes — **as long as all methods relate to a single responsibility**.

📌 **Main Rule**: All attributes and methods in a class must be for **one specific reason to change**, i.e., a single responsibility.

---

## 🧭 Summary

**SRP = "One Class, One Purpose"**  
Focus each class on doing **one thing well**.

---


Composition View

+--------------------------+
|      ShoppingCart        |
+--------------------------+
| - calcTotalPrice()       |
+--------------------------+
^          ^
|          |
|          |
+----------------+  +------------------+
| CartDBStorage  |  | CartPrintInvoice |
| - saveToDB()   |  | - printInvoice() |
+----------------+  +------------------+

Each class uses ShoppingCart via composition
