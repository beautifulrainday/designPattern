package structure;

/**
 * 装饰器模式
 * 思考：和代理模式的区别在哪？
 * 从代码结构来看差别不大
 * 个人认为主要区别是使用者的主观动机：
 * 代理：你要对这个被代理的对象之外加强什么功能
 * 装饰：你要对这个被装饰的对象本身改变什么
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        OriginObj originObj = new OriginObj();
        originObj.cookMeat();
        System.out.println("==========");
        //加上装饰1
        ConcreteDecorator concreteDecorator = new ConcreteDecorator(originObj);
        concreteDecorator.invoke();
        System.out.println("==========");
        //加上装饰2
        ConcreteDecorator2 concreteDecorator2 = new ConcreteDecorator2(originObj);
        concreteDecorator2.invoke();
        System.out.println("==========");
    }
}

/**
 * 源对象抽象
 */
interface OriginObjInterface {

    void function();

    //比如：我要做一道菜，红烧肉
    void cookMeat();
}

/**
 * 源对象，实现
 */
class OriginObj implements OriginObjInterface {

    @Override
    public void function() {
        System.out.println("do some thing");
    }

    @Override
    public void cookMeat() {
        System.out.println("cook meat");
    }


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

    @Override
    public void cookMeat() {
        originObj.cookMeat();
    }
}

/**
 * 具体被修饰类-1
 */
class ConcreteDecorator extends Decorator {

    public ConcreteDecorator(OriginObj originObj) {
        super(originObj);
    }

    public void invoke() {
        //super.function();
        //decoratorFuc();
        super.cookMeat();
        addSalt();
    }

    /**
     * 装饰的内容
     */
    private void decoratorFuc() {
        System.out.println("decorator1 for do some thing");
    }

    //加点盐
    private void addSalt() {
        System.out.println("add some salt");
    }
}

/**
 * 具体被修饰类-2
 */
class ConcreteDecorator2 extends Decorator {

    public ConcreteDecorator2(OriginObj originObj) {
        super(originObj);
    }

    public void invoke() {
        //super.function();
        //decoratorFuc();
        super.cookMeat();
        addOil();
    }

    /**
     * 装饰的内容
     */
    private void decoratorFuc() {
        System.out.println("decorator2 for do some thing");
    }

    //加点油
    private void addOil() {
        System.out.println("add some oil");
    }
}





