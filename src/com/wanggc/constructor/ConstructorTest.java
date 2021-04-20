package com.wanggc.constructor;

import com.wanggc.abstractTest.Bird;

/**
 * @author wanggc
 * @date 2019/05/25 星期六 13:46
 */

//构造方法：对对象初始化
public class ConstructorTest {
    public static void main(String[] args) {
      Boy boy = new Boy();
      Boy boy2 = new Boy("王国昌",1,"男");
      Boy boy3 = new Boy("王国昌",2,"男");


/*
        //测试构造代码块
        Person2 ps2 = new Person2();
        ps2.setName("王国昌");
        ps2.setId(1);
        ps2.setAge(18);

        System.out.println("姓名："+ps2.getName()+"\n"+"工号："+ps2.getId()+"\n"+"年龄："+ps2.getAge());
*/

/*
        //根据参数自动选择构造方法
        Person ps = new Person("王国昌",18,"男",300);
        System.out.println("姓名："+ ps.name +"\n" +"年龄："+ps.age+"\n"+"性别："+ps.gender+"\n"
        + "工资："+ ps.salary);
*/

        //Person ps = new Person("wgc",18);
        //    根据创建对象的参数，jvm自动寻找合适的构造方法
        //System.out.println("姓名："+ ps.name +"\n" +"年龄："+ps.age);
        //    这个对象创建出来时就有了自己的值
    }
}

/*
* 3.2	构造函数与普通的函数的区别
1.	一般函数是用于定义对象应该具备的功能。而构造函数定义的是，对象在调用功能之前，在建立时，应该具备的一些内容。也就是对象的初始化内容。
2.	构造函数是在对象建立时由jvm调用, 给对象初始化。一般函数是对象建立后，当对象调用该功能时才会执行。
3.	普通函数可以使用对象多次调用，构造函数就在创建对象时调用。
4.	构造函数的函数名要与类名一样，而普通的函数只要符合标识符的命名规则即可。
5.	构造函数没有返回值类型。
*
* 1. 当类中没有定义构造函数时，系统会指定给该类加上一个空参数的构造函数。这个是类中默认的构造函数。当类中如果自定义了构造函数，这时默认的构造函数就没有了。
	备注：可以通过javap命令验证。
2.在一个类中可以定义多个构造函数，以进行不同的初始化。多个构造函数存在于类中，是以重载的形式体现的。因为构造函数的名称都相同。

* */