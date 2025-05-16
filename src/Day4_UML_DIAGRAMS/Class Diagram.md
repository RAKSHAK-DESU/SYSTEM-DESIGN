# UML Diagrams in Java

You have an idea to make an application.  
To express how we can make an application by two approaches:
1. **Paragraphs**
2. **Diagram**

---

## UML Diagrams  
                    UML Diagrams
                   /            \
           Structural         Behavioural
           (Static)           (Dynamic)
          /         \         /         \
Class Diagram   ...   Sequence Diagram ...


> Structural & Behavioural each have 7 diagram types,  
> but the most commonly used are:
- **Class Diagram** (Structural)
- **Sequence Diagram** (Behavioural)

---

## 🎯 1. Class Structure

                     <<abstract>>
                    ----------------
                   |      Car       |
                   -----------------
                   | brand : String |
                   | model : String |
                   | engineCC : int |
                   -----------------
                   | +startEngine() |
                   | +stopEngine()  |
                   | +accelerate()  |
                   | +brake()       |
                   -----------------


### Java Code:
```java
abstract class Car {
    protected String brand;
    protected String model;
    protected int engineCC;

    public void startEngine() {
        // Start engine
    }

    public void stopEngine() {
        // Stop engine
    }

    public void accelerate() {
        // Accelerate
    }

    public void brake() {
        // Brake
    }
}

Access Modifiers
                            
| Modifier  | Within Class | Child Class | Outside Class | Symbol |
| --------- | ------------ | ----------- | ------------- | ------ |
| public    | ✔            | ✔           | ✔             | `+`    |
| protected | ✔            | ✔           | ✘             | `#`    |
| private   | ✔            | ✘           | ✘             | `-`    |

                    
Association / Connection
                    
                    
                             Association
                             /         \
              Class Association      Object Association
                         ||               |
                         \/         ---------------------
                     Inheritance   | Simple | Aggregation | Composition |


Inheritance — is-a Relation (--▷)

class Animal {
    void speak() {
        System.out.println("Animal speaking");
    }
}

class Cow extends Animal {
    void moo() {
        System.out.println("Cow says Moo");
    }
}

public class Main {
    public static void main(String[] args) {
        Cow cow = new Cow();
        cow.speak(); // inherited method
        cow.moo();   // own method
    }
}


Simple Association — ->

    "Arjun lives in a House"
    Arjun → House

class House {
    String address;

    House(String address) {
        this.address = address;
    }
}

class Person {
    String name;
    House house;

    Person(String name, House house) {
        this.name = name;
        this.house = house;
    }

    void showAddress() {
        System.out.println(name + " lives at " + house.address);
    }
}


Aggregation — -◇

    Sofa, Bed, Chair are part of a Room but can exist independently

class Sofa {}
class Bed {}
class ChairItem {}

class Room {
    Sofa sofa;
    Bed bed;
    ChairItem chair;

    Room(Sofa sofa, Bed bed, ChairItem chair) {
        this.sofa = sofa;
        this.bed = bed;
        this.chair = chair;
    }

    void showItems() {
        System.out.println("Room has Sofa, Bed, and Chair (Aggregation).");
    }
}

Composition — -◆

    Chair is composed of wheels, arms, and seat (tightly bound)
    
class Wheels {}
class Arms {}
class Seat {}

class Chair {
    private Wheels wheels;
    private Arms arms;
    private Seat seat;

    Chair() {
        wheels = new Wheels();
        arms = new Arms();
        seat = new Seat();
    }

    void info() {
        System.out.println("Chair is composed of wheels, arms, and seat (Composition).");
    }
}

Full Demo Code (Combine All)

public class Demo {
    public static void main(String[] args) {
        // Inheritance
        Cow cow = new Cow();
        cow.speak();
        cow.moo();

        // Simple Association
        House house = new House("Tokyo Street");
        Person arjun = new Person("Arjun", house);
        arjun.showAddress();

        // Aggregation
        Room room = new Room(new Sofa(), new Bed(), new ChairItem());
        room.showItems();

        // Composition
        Chair chair = new Chair();
        chair.info();
    }
}

