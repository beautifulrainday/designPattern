package behavior.strategy;

/**
 * 策略模式
 * 当一个功能的实现可以使用多种算法或者方式的时候
 * 如果选择在业务代码if等分支语句下硬编码，在类似场景多次出现的时候如果修改会改很多处地方，违反开闭原则
 * 基于开闭，这时会想到将这些'策略'方法进行统一管理，使用的时候直接new这个管理类，调用对应的方法即可
 * 而为了将各个策略方法统一管理（如增加一些日志的打印等操作），抽象一个上下文类context对其进行统一管理
 */
public class StrategyPattern {

    public static void main(String[] args) {
        Context context = new Context();
        Strategy addStrategy = new AddStrategy();
        context.setStrategy(addStrategy);
        context.invoke(1, 2);

        Strategy minusStrategy = new MinusStrategy();
        context.setStrategy(minusStrategy);
        context.invoke(4, 2);
    }

}

interface Strategy {
    void doStrategy(int a, int b);
}

//具体策略1
class AddStrategy implements Strategy {

    @Override
    public void doStrategy(int a, int b) {
        System.out.println(a + b);
    }
}

//具体策略2
class MinusStrategy implements Strategy {

    @Override
    public void doStrategy(int a, int b) {
        System.out.println(a - b);
    }
}

//上下文类，管理策略对象以及一些额外的通用逻辑
class Context {

    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void invoke(int a, int b) {
        System.out.println("Context invoke start");
        strategy.doStrategy(a, b);
        System.out.println("Context invoke done");
    }
}
