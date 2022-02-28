package structure.adapter;

/**
 * 类适配器模式
 */
public class ClassAdapter {

    public static void main(String[] args) {
        OriginImpl origin = new OriginImpl();
        origin.func1();

        AdapterImpl adapter = new AdapterImpl();
        adapter.func1();
        adapter.func2();
    }

}

/**
 * 需要被加强的
 */
interface Origin {

    void func1();

}

/**
 * 需要被加强的实现类
 */
class OriginImpl implements Origin {

    @Override
    public void func1() {
        System.out.println("func1");
    }
}

/**
 * 适配器接口
 */
interface AdapterInterface extends Origin {

    void func2();
}

/**
 * 适配器实现
 */
class AdapterImpl implements AdapterInterface {

    @Override
    public void func1() {
        System.out.println("func1");
    }

    @Override
    public void func2() {
        System.out.println("func2");
    }
}

