package Day3_OOPS.Inheritance;

public class ElectricCar extends Car {
    private int batteryLevel;

    public ElectricCar(String brand, String model) {
        super(brand, model);
        this.batteryLevel = 100;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(brand + " " + model + " : Battery fully charged.");
    }

    @Override
    public void accelerate() {
        if (isEngineOn && batteryLevel > 0) {
            currentSpeed += 15;
            batteryLevel -= 5;
            System.out.println(brand + " " + model + " : Electric accelerating to " + currentSpeed + " km/h with battery at " + batteryLevel + "%");
        } else {
            System.out.println(brand + " " + model + " : Can't accelerate, battery low or engine off.");
        }
    }
}
