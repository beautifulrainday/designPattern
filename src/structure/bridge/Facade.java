package structure.bridge;

/**
 * 外观模式
 * <p>
 * 通过外观模式去操作其下的子模式
 */
public class Facade {
    public static void main(String[] args) {
        Car car = new Car(new Handbrake(), new Gear(), new SeatBelt());
        car.drive();
    }
}

/**
 * 比如总事件：我要开车
 */
class Car {
    private Handbrake handbrake;
    private Gear gear;
    private SeatBelt seatBelt;

    public Car(Handbrake handbrake, Gear gear, SeatBelt seatBelt) {
        this.handbrake = handbrake;
        this.gear = gear;
        this.seatBelt = seatBelt;
    }

    void drive() {
        seatBelt.fasten();
        gear.put();
        handbrake.putDown();

    }
}

/**
 * 开车需要：
 * 1、系安全带
 * 2、放下手刹
 * 3、挂档
 */
class Handbrake {
    void putDown() {
        System.out.println("放下手刹");
    }
}

class Gear {
    void put() {
        System.out.println("挂档");
    }
}

class SeatBelt {
    void fasten() {
        System.out.println("系好了安全带");
    }
}

