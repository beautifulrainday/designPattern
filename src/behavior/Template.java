package behavior;

/**
 * 模板模式
 * 父类中设计好某算法或者某系列方法的顺序（或者说框架、骨架、模板），而方法的具体实现丢到子类去完成
 */
public class Template {

    public static void main(String[] args) {
        Mybatis mybatis = new Mybatis();
        mybatis.doSQL();
        Struts struts = new Struts();
        struts.doSQL();
    }
}

/**
 * 模板父类
 * 比如：JDBC，我们要做什么：为了方便省去事务
 * 1、读取配置
 * 2、开启连接
 * 3、开启statement
 * 4、处理sql
 * 6、关闭资源
 * 分析：
 * 比如不同的ORM+DAO框架实现方式会不同，可以由其各自去实现
 */
abstract class JDBCTemplate{

    abstract void readConfig();

    abstract void getConnect();

    abstract void getStatement();

    abstract void handlerSQL();

    abstract void closeSource();

    void doSQL(){
        readConfig();
        getConnect();
        getStatement();
        handlerSQL();
        closeSource();
    }

}

/**
 * 比如mybatis框架来封装实现它了
 */
class Mybatis extends JDBCTemplate{

    @Override
    void readConfig() {
        System.out.println("Mybatis readConfig");
    }

    @Override
    void getConnect() {
        System.out.println("Mybatis getConnect");
    }

    @Override
    void getStatement() {
        System.out.println("Mybatis getStatement");
    }

    @Override
    void handlerSQL() {
        System.out.println("Mybatis handlerSQL");
    }

    @Override
    void closeSource() {
        System.out.println("Mybatis closeSource");
    }
}

/**
 * 再比如struts框架来封装实现它了
 */
class Struts extends JDBCTemplate{

    @Override
    void readConfig() {
        System.out.println("Struts readConfig");
    }

    @Override
    void getConnect() {
        System.out.println("Struts getConnect");
    }

    @Override
    void getStatement() {
        System.out.println("Struts getStatement");
    }

    @Override
    void handlerSQL() {
        System.out.println("Struts handlerSQL");
    }

    @Override
    void closeSource() {
        System.out.println("Struts closeSource");
    }
}
