package Day3_OOPS.Polymorphism;

public class Utility {
    public void print(int i) {
        System.out.println("Printing integer: " + i);
    }

    public void print(double d) {
        System.out.println("Printing double: " + d);
    }

    public void print(String s) {
        System.out.println("Printing string: " + s);
    }

    public int add(int a, int b) {
        System.out.print("Sum of two integers: ");
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.print("Sum of three integers: ");
        return a + b + c;
    }
}
