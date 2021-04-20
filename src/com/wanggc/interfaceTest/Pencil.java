package com.wanggc.interfaceTest;

import com.wanggc.inheritance.Penguin;

/**
 * @author wanggc
 * @date 2019/06/02 星期日 18:09
 */

/*
接口定义：
interface 接口名{
属性
抽象方法
}

* */
class Pencil {
    String name;
    Pencil(){

    }

    Pencil(String name){
        this.name = name;
    }

    void write(){
        System.out.println("写字");
    }
}

interface Eraser{
    public static final String color = "白色";

    public abstract void clean();

}

class PencilWithEraser extends Pencil implements Eraser{
    PencilWithEraser(){

    }

    PencilWithEraser(String name){
        super(name);
    }

    void write(){
        System.out.println(name + "考试专用");
    }

    public void clean(){
        System.out.println(super.name + "带橡皮的铅笔就是好用");
    }
}

class Dermo {
    public static void main(String[] args) {

        PencilWithEraser pencilWithEraser = new PencilWithEraser("中华2B");
        pencilWithEraser.write();
        pencilWithEraser.clean();
        System.out.println(pencilWithEraser.color);
        System.out.println(PencilWithEraser.color);
    }
}

/*
注意：可以通过javap命令查看.
1.	接口中的所有属性 默认的修饰符是  public static final。
2.	接口中的所有方法 默认的修饰符是  public abstract。
疑惑：干嘛不在PencilWithEraser添加remove功能函数，而要通过接口？

* */

/*
3.2	接口的特点
1.	类实现接口可以通过implements实现，实现接口的时候必须把接口中的所有方法实现,一个类可以实现多个接口。
2.	接口中定义的所有的属性默认是public static final的，即静态常量既然是常量，那么定义的时候必须赋值。
3.	接口中定义的方法不能有方法体。接口中定义的方法默认添加public abstract
4.	有抽象函数的不一定是抽象类，也可以是接口类。
5.	由于接口中的方法默认都是抽象的，所以不能被实例化。
6.	对于接口而言，可以使用子类来实现接口中未被实现的功能函数。
7.	如果实现类中要访问接口中的成员，不能使用super关键字。因为两者之间没有显示的继承关系，况且接口中的成员成员属性是静态的。
可以使用接口名直接访问。
8.	接口没有构造方法。

* */

/*
3.3	接口与类、接口之间的关系
1. 大家之前都知道类与类之间的关系继承，那么接口与类之间又是怎样子的关系呢？接口与类之间是实现关系。
非抽象类实现接口时，必须把接口里面的所有方法实现。类实现接口用关键字implments，
类与接口之间是可以多实现的(即一个类可以实现多个接口)。

接口与接口之间的关系：继承
接口可以多继承接口

* */