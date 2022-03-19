package structure.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 * 利用"缓存"复用来达到对一些细颗粒度对象进行管理，由于对象创建和销毁都需要消耗资源，避免重复大量创建对象，可以理解为工厂模式的升级版
 * 组成：
 * 调用者-main方法或其他
 * 抽象工厂
 * 具体工厂对象-用于提供方法，被调用后去内部"缓存"寻找享元对象，有就返回，无则生成
 * 享元对象-可以被抽象的，第一次被创建后将被缓存到具体工厂中
 * 非享元对象-其中不能被复用抽象的对象（或属性），通过参数形式传到享元对象中
 * 优点：
 * 对于大量重复对象的创建节省了内存空间
 * 缺点：
 * 分了内部状态和外部状态，增加了系统复杂度
 * ===========================================
 * 举例：围棋
 * 思考："棋子"对象的作用是什么？
 * 用于在棋盘上输出：什么'颜色'的棋子落在了什么'坐标'。
 * 这个棋子对象的生命周期很短而且随着进程会*多次*创建销毁，很没必要并且会浪费多余的资源，将其享元化。
 * 其中落下的'经纬度坐标'是非享元的属性，作为外部属性传入
 */
public class FlyWeight {

    public static void main(String[] args) {
        Chess whiteChess = Factory.getChess(Factory.WHITE);
        Chess blackChess = Factory.getChess(Factory.BLACK);
        Chess whiteChess1 = Factory.getChess(Factory.WHITE);
        Chess blackChess1 = Factory.getChess(Factory.BLACK);
        System.out.println("whiteChess" + whiteChess.toString());
        System.out.println("blackChess" + blackChess.toString());
        System.out.println("whiteChess1" + whiteChess1.toString());
        System.out.println("blackChess1" + blackChess1.toString());
        whiteChess.downChess(11, 22);
        whiteChess.downChess(22, 33);

        blackChess.downChess(111, 222);
        blackChess.downChess(222, 333);

        int i1 = 127;
        Integer i2 = 127;
        Integer i21 = 127;
        Integer i3 = new Integer(127);
        Integer i31 = new Integer(127);

        int i4 = 128;
        Integer i5 = 128;
        Integer i51 = 128;
        Integer i6 = new Integer(128);
        //
        System.out.println("Integer i2 = 127;");
        System.out.println("Integer i21 = 127;");
        System.out.println("=====》" + (i2 == i21));
        System.out.println("");
        System.out.println("Integer i5 = 128;");
        System.out.println("Integer i51 = 128;");
        System.out.println("=====》" + (i5 == i51));
        System.out.println("");

        System.out.println("Integer i2 = 127;");
        System.out.println("Integer i3 = new Integer(127);");
        System.out.println("=====》" + (i2 == i3));
        System.out.println("");
        System.out.println("Integer i5 = 128;");
        System.out.println("Integer i6 = new Integer(128);");
        System.out.println("=====》" + (i5 == i6));
        System.out.println("");

        //
        System.out.println("int i1 = 127;");
        System.out.println("Integer i2 = 127;");
        System.out.println("=====》" + (i1 == i2));
        System.out.println("");
        System.out.println("int i1 = 127;");
        System.out.println("Integer i3 = new Integer(127);");
        System.out.println("=====》" + (i1 == i3));
        System.out.println("");

        System.out.println("int i4 = 128;");
        System.out.println("Integer i5 = 128;");
        System.out.println("=====》" + (i4 == i5));
        System.out.println("");
        System.out.println("int i4 = 128;");
        System.out.println("Integer i6 = new Integer(128);");
        System.out.println("=====》" + (i4 == i6));
        System.out.println("");

        //
        System.out.println("Integer i3 = new Integer(127);");
        System.out.println("Integer i31 = new Integer(127);");
        System.out.println("=====》" + (i3 == i31));
        System.out.println("");
    }
}

//抽象棋子对象
abstract class Chess {

    abstract void downChess(int longitude, int latitude);

}

//具体棋子对象
class WhiteChess extends Chess {

    //下子。其中经纬度是非享元的
    @Override
    void downChess(int longitude, int latitude) {
        System.out.println("WhiteChess down in ".concat(String.valueOf(longitude).concat(",").concat(String.valueOf(latitude))));
    }
}

class BlackChess extends Chess {

    @Override
    void downChess(int longitude, int latitude) {
        System.out.println("BlackChess down in ".concat(String.valueOf(longitude).concat(",").concat(String.valueOf(latitude))));
    }
}

//工厂类
class Factory {

    public static final Integer WHITE = 0;

    public static final Integer BLACK = 1;

    //用于存放创建了的棋子对象
    private static final Map<Integer, Chess> stringChessMap = new HashMap<>();

    //获得棋子 type:0黑1白
    public static Chess getChess(int type) {
        Chess chess = stringChessMap.get(type);
        if (chess == null) {
            Chess tmpChess = type == WHITE ? new WhiteChess() : new BlackChess();
            stringChessMap.put(type, tmpChess);
        }
        return stringChessMap.get(type);
    }
}



