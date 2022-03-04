package structure.bridge;

/**
 * 桥接模式-正确版
 * 如果有手机有机型和价格两个分类
 */
public class Bridge {

    public static void main(String[] args) {
        new ApplePhone().info(new CheapPrice());
        new ApplePhone().info(new ExpensivePrice());
        new HuaweiPhone().info(new CheapPrice());
        new HuaweiPhone().info(new ExpensivePrice());
    }
}

/**
 * 手机接口
 */
interface Phone {

    void info(Price price);
}

/**
 * 具体的手机
 */
class HuaweiPhone implements Phone {

    @Override
    public void info(Price price) {
        System.out.println("I'm ".concat(price.priceInfo()).concat("HuaweiPhone"));
    }
}

class ApplePhone implements Phone {

    @Override
    public void info(Price price) {
        System.out.println("I'm ".concat(price.priceInfo()).concat("ApplePhone"));
    }
}

/**
 * 价位接口
 */
interface Price {

    String priceInfo();

}

/**
 * 具体的价位
 */
class CheapPrice implements Price {

    @Override
    public String priceInfo() {
        return "cheap";
    }
}

class ExpensivePrice implements Price {

    @Override
    public String priceInfo() {
        return "expensive";
    }
}