package create;

import java.io.*;

/**
 * 原型
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String str = "this is str";

    private Clazz clazz = new Clazz();

    //默认的，不完善的拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    //序列化，保证深拷贝
    protected Object deepClone() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);

        return objectInputStream.readObject();
    }


    public static void main(String[] args) throws Exception {
        Prototype prototypeOld = new Prototype();
        /*Prototype prototypeNew = (Prototype) prototypeOld.clone();

        //不是同一个地址了，说明是开辟了新的空间
        System.out.println(prototypeOld == prototypeNew);

        System.out.println(prototypeOld.str + "====== " + prototypeNew.str);
        //改变str、基本类型
        prototypeOld.str = "this is str new";
        //old改变了，new没改变，说明str、基本类型实现了深拷贝。
        System.out.println(prototypeOld.str + "====== " + prototypeNew.str);

        //改变引用类型 对象等
        System.out.println(prototypeOld.clazz == prototypeNew.clazz);
        System.out.println(prototypeOld.clazz.getStr() == prototypeNew.clazz.getStr());

        prototypeOld.clazz.setStr("this is clazzStr new");
        //改了一个另一个随之改变，说明引用类型 对象不是深拷贝
        System.out.println(prototypeOld.clazz == prototypeNew.clazz);
        System.out.println(prototypeOld.clazz.getStr() + "====== " + prototypeNew.clazz.getStr());*/


        //--------------------
        //深拷贝 用引用类型做例子。
        Prototype prototypeDeep = (Prototype) prototypeOld.deepClone();

        //不是同一个地址了，说明是开辟了新的空间
        System.out.println(prototypeOld == prototypeDeep);//false

        System.out.println(prototypeOld.str + "====== " + prototypeDeep.str);//相同
        //改变str、基本类型
        prototypeOld.str = "this is str new";
        //old改变了，new没改变，说明str、基本类型实现了深拷贝。
        System.out.println(prototypeOld.str + "====== " + prototypeDeep.str);//不同

        //改变引用类型 对象等
        System.out.println(prototypeOld.clazz == prototypeDeep.clazz);//不同
        System.out.println(prototypeOld.clazz.getStr() + "====== " + prototypeDeep.clazz.getStr());//相同

        prototypeOld.clazz.setStr("this is clazzStr new");
        //改了一个另一个随之改变，说明引用类型 对象不是深拷贝
        System.out.println(prototypeOld.clazz == prototypeDeep.clazz);//不同
        System.out.println(prototypeOld.clazz.getStr() + "====== " + prototypeDeep.clazz.getStr());//不同

    }
}

class Clazz implements Serializable {

    private static final long serialVersionUID = -758641582531065223L;

    public String str;

    Clazz() {
        str = "this is clazzStr";
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}