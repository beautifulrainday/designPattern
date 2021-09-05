package create;

import java.util.concurrent.CountDownLatch;

/**
 * 单例
 */
public class Singleton {

    public static void main(String[] args) throws InterruptedException {

        //Semaphore semaphore = new Semaphore(1);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        Runnable r = () -> {
            try {
                System.out.println("线程：" + Thread.currentThread().getName() + "进来的，阻塞了");
                countDownLatch.await();
                System.out.println("线程：" + Thread.currentThread().getName() + "释放咯");
                //饿汉
                //System.out.println(hungrySingleton.getInstance());
                //懒汉
                //System.out.println(lazySingleton.getInstance());
                //懒汉-双检索
                //System.out.println(lazySingletonDoubleCheck.getInstance());
                //静态内部类
                //System.out.println(staticInnerSingleton.getInstance());
                //枚举
                System.out.println(EnumSingleton.instance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        Thread t4 = new Thread(r);
        Thread t5 = new Thread(r);
        Thread t6 = new Thread(r);
        Thread t7 = new Thread(r);
        Thread t8 = new Thread(r);
        Thread t9 = new Thread(r);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        //Thread.sleep(1000L);
        countDownLatch.countDown();
    }
}

//懒汉模式
class lazySingleton {

    private static Singleton instance = null;

    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

//懒汉之双检锁
class lazySingletonDoubleCheck {

    private volatile static Singleton instance = null;

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (lazySingletonDoubleCheck.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


//饿汉模式
class hungrySingleton {

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}

//静态内部类 Effective Java 推荐！
class staticInnerSingleton {

    private static class staticInner {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return staticInner.instance;
    }
}

enum EnumSingleton {

    instance;

    public void getInstance() {

    }

}