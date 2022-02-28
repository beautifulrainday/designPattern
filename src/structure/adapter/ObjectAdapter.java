package structure.adapter;

public class ObjectAdapter {
    public static void main(String[] args) {

        Macbook macbook = new Macbook();
        macbook.connect();

        DockingStation dockingStation = new DockingStation(macbook);
        dockingStation.connectTypec();
        dockingStation.connectUsb();
    }
}

/**
 * 原对象 比如macbookpro（19阉割版），只能适配typec。。。
 */
class Macbook {

    void connect() {
        //只有typec
        System.out.println("I only can connect to typec");
    }

}

/**
 * 适配器接口
 */
interface ClassAdapterInterface {

    /**
     * 要兼容macbook的
     */
    void connectTypec();

    /**
     * 对于macbook扩展的
     */
    void connectUsb();
}

/**
 * 具体的适配器类-比如给macbook扩展功能的拓展坞
 */
class DockingStation implements ClassAdapterInterface {

    /**
     * 需要被拓展的对象
     */
    private Macbook macbook;

    /**
     * 构造方法注入一下吧
     *
     * @param macbook
     */
    public DockingStation(Macbook macbook) {
        this.macbook = macbook;
    }

    @Override
    public void connectTypec() {
        macbook.connect();
    }

    @Override
    public void connectUsb() {
        System.out.println("docking station also can connect to usb");
    }
}

