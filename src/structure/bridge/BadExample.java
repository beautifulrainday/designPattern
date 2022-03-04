package structure.bridge;

/**
 * 手机有不同品牌和价位
 * 这种继承再继承的方式，每次增加一种新的手机品牌，
 * 需要复制整块代码，且继承级数多了，类数会指数级增加
 * 而且不一定每种手机都会有类似的分类，所以这种不合理。
 */
public class BadExample {

    public static void main(String[] args) {
        new CheapApplePhone().info();
        new ExpensiveApplePhone().info();
        new CheapHuaweiPhone().info();
        new ExpensiveHuaweiPhone().info();
    }
}

interface Phone1 {
    void info();
}

class HuaweiPhone1 implements Phone1 {

    @Override
    public void info() {
        System.out.println("I'm HuaweiPhone");
    }
}

class ApplePhone1 implements Phone1 {

    @Override
    public void info() {
        System.out.println("I'm ApplePhone");
    }
}

//如果不同品牌手机下面有不同的分类呢
//ex:贵和便宜
class CheapHuaweiPhone extends HuaweiPhone1 {

    @Override
    public void info() {
        System.out.println("I'm cheapHuaweiPhone");
    }

}

class ExpensiveHuaweiPhone extends HuaweiPhone1 {

    @Override
    public void info() {
        System.out.println("I'm expensiveHuaweiPhone");
    }
}

class CheapApplePhone extends ApplePhone1 {

    @Override
    public void info() {
        System.out.println("I'm cheapApplePhone");
    }

}

class ExpensiveApplePhone extends ApplePhone1 {

    @Override
    public void info() {
        System.out.println("I'm expensiveApplePhone");
    }
}
