package Day3_OOPS.Polymorphism;

public class ManualCar extends Car {
    @Override
    public void accelerate() {
        System.out.println("Manual Car accelerating, engaging gears for power!");
    }

    @Override
    public void brake() {
        System.out.println("Manual Car braking with standard system.");
    }
}
