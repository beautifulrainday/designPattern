package structure.bridge;

/**
 * 你看看这河里吗，这不河里。
 * 机型和价格类型直接耦合啦。
 * 你要加别的分类咋办呢。
 */
public class BadExample2 {

    public static void main(String[] args) {
        new HuaweiPhone2().cheapInfo();
        new HuaweiPhone2().expensiveInfo();
        new ApplePhone2().cheapInfo();
        new ApplePhone2().expensiveInfo();
    }
}

interface Phone2 {

    void cheapInfo();

    void expensiveInfo();
}

class HuaweiPhone2 implements Phone2 {

    @Override
    public void cheapInfo() {
        System.out.println("I'm cheapHuaweiPhone");
    }

    @Override
    public void expensiveInfo() {
        System.out.println("I'm expensiveHuaweiPhone");
    }
}

class ApplePhone2 implements Phone2 {

    @Override
    public void cheapInfo() {
        System.out.println("I'm cheapApplePhone");
    }

    @Override
    public void expensiveInfo() {
        System.out.println("I'm expensiveApplePhone");
    }
}


