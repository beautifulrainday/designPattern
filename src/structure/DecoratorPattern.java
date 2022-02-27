package structure;

/**
 * 装饰器模式
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        OriginObj originObj = new OriginObj();
        originObj.function();
        //
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(originObj);
        concreteDecorator.invoke();
    }
}

/**
 * 源对象抽象
 */
interface OriginObjInterface {

    void function();
}

/**
 * 源对象，实现
 */
class OriginObj implements OriginObjInterface {

    @Override
    public void function() {
        System.out.println("do some thing");
    }
}

class Decorator2 extends OriginObj{

}

/**
 * 装饰对象抽象
 */
class Decorator implements OriginObjInterface {

    public Decorator(OriginObj originObj) {
        this.originObj = originObj;
    }

    /**
     * 成员变量-被装饰对象
     */
    private OriginObj originObj;

    @Override
    public void function() {
        originObj.function();
    }
}

/**
 * 具体被修饰类
 */
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(OriginObj originObj) {
        super(originObj);
    }

    public void invoke() {
        super.function();
        decoratorFuc();
    }

    /**
     * 装饰的内容
     */
    private void decoratorFuc() {
        System.out.println("decorator some thing");
    }
}





