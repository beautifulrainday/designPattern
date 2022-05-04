package behavior.strategy;

public class StrategyV1 {

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        calculate.add(1, 2);
        calculate.minus(4, 2);
    }

}

class Calculate {

    void add(int a, int b) {
        System.out.println(a + b);
    }

    void minus(int a, int b) {
        System.out.println(a - b);
    }
}
