# UML: Sequence Diagram

                       ==================
                      | Sequence Diagram |
                       ==================
      A ------------------> B
        <------------------

Sequence Diagram shows **interaction/communication between objects** over time.  
It focuses on **"who interacts with whom"** and **"in what order."**

---

## 📌 Key Concepts

### 1. **Class Representation**
Objects or classes involved in the sequence are often represented using symbols like:

---

### 2. **Lifeline**
- The **vertical dashed line** below each object.
- Shows **how long an object exists** during the interaction.

---

### 3. **Activation Bar**
- A **thin vertical rectangle** on the lifeline.
- Indicates the **active period** of the object.
- When active: ✅ Can send/receive messages
- When inactive: ❌ Cannot interact

---

### 4. **Messages**

#### 🧭 Types of Messages:

| Type            | Description                                | Notation                             |
|-----------------|--------------------------------------------|--------------------------------------|
| **Synchronous** | Waits for a response                       | Solid line with filled arrow `▷`     |
| **Response**    | The reply to a synchronous call            | Dotted line with filled arrow `▷`    |
| **Asynchronous**| Doesn't wait for a response                | Solid line with open arrow `>`       |
| **Create**      | A new object is created                    | `new` keyword message                |
| **Destroy**     | An object is removed                       | ❌ usually shown with X at end       |
| **Lost**        | Sent but destination unknown               | Dashed to nowhere                    |
| **Found**       | Received from an unknown source            | Dashed from nowhere                  |

#### 🔁 Message Diagram Example

```text
        🄰               🄱
        |               |
        |─────────────▷ |   sync message
        |               |
        |•••••••••••••▷ |   response message
        |               |
        |─────────────> |   async message
        |               |

💳 Example: ATM Transaction Flow
Use Case: Withdraw Money

    User → ATM: Inputs Account, Amount

    ATM → Transaction System: Initiates withdrawal

    Transaction → Account & CashDispenser: Verifies & dispenses

🧩 Steps to Draw a Sequence Diagram
✅ 1. Identify the Use Case

    E.g., ATM withdrawal

✅ 2. Identify the Objects Involved

    ATM, User, Transaction, Account, Cash Dispenser

✅ 3. Draw Sequence with Timelines & Messages
    User        ATM         Transaction       Account       CashDispenser
 |           |               |               |                |
 |──────────▷|               |               |                |  // Step 1: User inputs acc + amount
 |           |─────────────▷|               |                |  // Step 2: ATM sends to Transaction
 |           |               |────────────▷ |                |  // Step 3: Transaction verifies account
 |           |               |               |────────────▷  |  // Step 4: Account tells CashDispenser
 |           |               |               |                |  // Step 5: Cash is dispensed
 |           |               |◁──────────────|                |  // Step 6: Response to Transaction
 |           |◁─────────────|               |                |  // Step 7: Transaction responds to ATM
 |◁──────────|               |               |                |  // Step 8: ATM shows message to User


Special Control Blocks
| Keyword  | Meaning              |
| -------- | -------------------- |
| `alt`    | if-else block        |
| `option` | single optional path |
| `loop`   | repeated interaction |
