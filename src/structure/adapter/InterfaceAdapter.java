package structure.adapter;

/**
 * 接口适配器
 */
public class InterfaceAdapter {

    public static void main(String[] args) {
        DetailClass detailClass = new DetailClass();
    }


}

interface InterfaceAdapterInterface{

    void fun1();

    void fun2();

    void fun3();

}

abstract class AbstractClass implements InterfaceAdapterInterface{

    //此处我实现掉了某一个。
    public void fun1(){
        System.out.println("fun1");
    }

}

/**
 * 那么在此类中只需要实现fun2、3即可，在许多框架中有应用
 */
class DetailClass extends AbstractClass{

    @Override
    public void fun2() {

    }

    @Override
    public void fun3() {

    }
}

