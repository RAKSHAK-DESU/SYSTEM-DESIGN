package Day2_OOPS;

import Day2_OOPS.SportsCar;
public class main {
    public static void main(String[] args) {
        SportsCar myCar = new SportsCar("Ford", "Mustang");

        myCar.startEngine();
        myCar.shiftGear(1);
        myCar.accelerate();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();

        System.out.println("Final Speed: " + myCar.getSpeed());
    }
}
