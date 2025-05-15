package Day3_OOPS.Polymorphism;

public class ElectricCar extends Car {
    @Override
    public void accelerate() {
        System.out.println("Electric Car accelerating with instant torque, silent!");
    }

    @Override
    public void brake() {
        System.out.println("Electric Car using regenerative braking.");
    }
}
