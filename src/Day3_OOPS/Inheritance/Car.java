package Day3_OOPS.Inheritance;

public class Car {
    protected String brand;
    protected String model;
    protected boolean isEngineOn;
    protected int currentSpeed;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.isEngineOn = false;
        this.currentSpeed = 0;
    }

    public void startEngine() {
        isEngineOn = true;
        System.out.println(brand + " " + model + " : Engine started.");
    }

    public void stopEngine() {
        isEngineOn = false;
        System.out.println(brand + " " + model + " : Engine turned off.");
    }

    public void accelerate() {
        if (isEngineOn) {
            currentSpeed += 10;
            System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
        } else {
            System.out.println(brand + " " + model + " : Can't accelerate, engine is off.");
        }
    }

    public void brake() {
        if (currentSpeed > 0) {
            currentSpeed -= 10;
            System.out.println(brand + " " + model + " : Slowing down to " + currentSpeed + " km/h");
        } else {
            System.out.println(brand + " " + model + " : Car is stopped.");
        }
    }
}