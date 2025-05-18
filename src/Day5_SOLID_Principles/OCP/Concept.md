# 🛡️ Open-Closed Principle (OCP) in Java

## 📘 Definition

> A class should be **open for extension** but **closed for modification**.  
This means you should be able to add new functionality **without changing** the existing code.

---

## ❌ Bad Design: Violates OCP

+----------------+       +-------------------+
| ShoppingCart   |-----> | CartDBStorage     |
| calcTotal()    |       | saveToDB()        |
+----------------+       | saveToMongo() ❌  |
| saveToFile()  ❌  |
+-------------------+

Adding new save methods modifies existing class => Breaks OCP


In this design, every time we need to support a new storage option (like Mongo or file), we **change the existing CartDBStorage class**.  
This **violates the OCP** because we're modifying existing working code.

---

## ✅ Good Design: Follows OCP

+----------------+       +------------------------+
| ShoppingCart   |-----> | <<abstract>>           |
| calcTotal()    |       | DBPersistence          |
+----------------+       | save()                 |
+-----------+------------+
|
+-------------+-----------+-----------+
|             |                       |
+--------------+ +-------------+      +----------------+
| SaveToDB     | | SaveToFile |      | SaveToMongo     |
| save()       | | save()     |      | save()          |
+--------------+ +-------------+      +----------------+

Each new save method is a new class => No changes to existing code



In this version, we define an abstract class `DBPersistence` with a `save()` method.  
New behavior is added by creating new **child classes** like `SaveToFile`, `SaveToMongo`, etc.  
This follows the **OCP** perfectly.

---

## 🧠 Key Concepts

- **Open for extension:** You can add new features by adding new classes.
- **Closed for modification:** You never touch or alter existing working classes.

---

## 💡 Why OCP Matters

- ✅ Makes code **stable** and **less prone to bugs**
- ✅ Encourages **modular**, **scalable** architecture
- ✅ Easier to maintain and extend in large systems

---

## 🛠️ How to Achieve OCP

- Use **Abstraction** (abstract classes or interfaces)
- Use **Inheritance** to extend behaviors
- Use **Polymorphism** to allow interchangeable implementations

---

