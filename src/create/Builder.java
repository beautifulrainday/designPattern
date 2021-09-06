package create;

/**
 * 建造者模式
 */
public class Builder {

    public static void main(String[] args) {
        Director.create(new CarBuilder());
        Director.create(new BicycleBuilder());
    }
}

interface Goods {
}

class Car implements Goods {

    public String carName;
    public String carPrice;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }
}

class Bicycle implements Goods {

    public String bicycleName;
    public String bicyclePrice;
    public String place;

    public String getBicycleName() {
        return bicycleName;
    }

    public void setBicycleName(String bicycleName) {
        this.bicycleName = bicycleName;
    }

    public String getBicyclePrice() {
        return bicyclePrice;
    }

    public void setBicyclePrice(String bicyclePrice) {
        this.bicyclePrice = bicyclePrice;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}

interface BuilderInterface {

    void buildPre(String prName, String prPrice);

    Goods build(String place);
}

class CarBuilder implements BuilderInterface {

    Car car = new Car();

    @Override
    public void buildPre(String prName, String prPrice) {
        car.setCarName(prName);
        car.setCarPrice(prPrice);
        System.out.println("car build");
    }

    @Override
    public Goods build(String place) {
        car.setCarPrice(place);
        System.out.println("car place");
        return car;
    }
}

class BicycleBuilder implements BuilderInterface {

    Bicycle bicycle = new Bicycle();

    @Override
    public void buildPre(String prName, String prPrice) {
        bicycle.setBicycleName(prName);
        bicycle.setBicyclePrice(prPrice);
        System.out.println("bicycle build");
    }

    @Override
    public Goods build(String place) {
        bicycle.setPlace(place);
        System.out.println("bicycle place");
        return bicycle;
    }
}


//调用者
class Director {

    public static Goods create(BuilderInterface builder) {
        builder.buildPre("name", "price");
        return builder.build("place");
    }

}