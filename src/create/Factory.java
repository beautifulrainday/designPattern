package create;

/**
 * 工厂模式
 */
public class Factory {

    public static void main(String[] args) {
        //simple
        /*SimpleFactory.produce("headset");
        SimpleFactory.produce("charge");*/

        //abstract
        new HeadSetFactory().produce();
        new ChargeFactory().produce();
    }
}

interface Product{

}

class Headset implements Product{

    private String headSetName;

    public String getHeadSetName() {
        return headSetName;
    }

    public void setHeadSetName(String headSetName) {
        this.headSetName = headSetName;
    }
}

class Charge implements Product{

    private String chargeName;

    public String getChargeName() {
        return chargeName;
    }

    public void setChargeName(String chargeName) {
        this.chargeName = chargeName;
    }
}

//简单工厂
class SimpleFactory{

    public static Product produce(String type){
        if(("headset").equalsIgnoreCase(type)){
            System.out.println("create a headset");
            return new Headset();
        }else if("charge".equalsIgnoreCase(type)){
            System.out.println("create a charge");
            return new Charge();
        }else {
            return null;
        }
    }
}


//抽象工厂
interface PhoneFactory{

    Product produce();
}

class HeadSetFactory implements PhoneFactory{

    @Override
    public Product produce() {
        System.out.println("you get a Headset");
        return new Headset();
    }
}

class ChargeFactory implements PhoneFactory{

    @Override
    public Product produce() {
        System.out.println("you get a Charge");
        return new Charge();
    }
}