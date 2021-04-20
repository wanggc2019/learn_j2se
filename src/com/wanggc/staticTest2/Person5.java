package com.wanggc.staticTest2;

/**
 * @author wanggc
 * @date 2019/05/27 星期一 10:17
 */

class Person5 {
    String name;
    int age;
    String gender;
    int salary;
    //定义静态变量
    static String country = "中国";

    //    全参构造方法
    Person5(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //    无参的构造方法
    Person5() {
    }

    Person5(String name,int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    Person5(String name,int age, String gender,int salary){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    // 非静态方法
    void check(){
        // 非静态方法可以访问静态成员
        System.out.println(country);
        System.out.println("姓名:"+name+"\n"+"年龄:"+age+"\n"+"性别:"+gender+"\n"
                +"薪资:"+salary+"\n"+"国籍:"+country);
    }
//    jvm根据创建对象的参数来选择使用哪个构造方法


    //静态方法
    static void check2(){
        // 静态方法只能访问静态成员变量。
        System.out.println(country);
        // 静态函数中不能访问非静态成员变量;静态方法访问非静态成员变量，编译报错
        //System.out.println("姓名:"+name+"\n"+"年龄:"+age+"\n"+"性别:"+gender+"\n"+"薪资:"+salary+"\n"+"国籍:"+country);
        // 静态方法中不可以出现this,编译报错
        //this.check();
    }
}

/*
    * 2：成员方法
	可以使用类名直接调用
	1：静态函数：
		1：静态函数中不能访问非静态成员变量，只能访问静态变量。
		2：静态方法不可以定义this,super关键字.
		3：因为静态优先于对象存在.静态方法中更不可以出现this
			 2：非静态函数：非静态函数中可以访问静态成员变量
	    2：细节：
		1：静态函数中不能使用非静态变量
		2：非静态函数可以访问静态变量
		*
3：为什么静态函数中不能访问非静态成员
		1：static修饰的成员在共享区中。优先于对象存在
		2：验证
			1：使用静态代码块验证
				1：静态代码块
					static{
						静态代码块执行语句;
					}
				 1：静态代码块特点
随着类的加载而加载。只执行一次，优先于主函数。用于给类进行初始化。
*
4：static特点
        1 随着类的加载而加载，静态会随着类的加载而加载，随着类的消失而消失。说明它的生命周期很长。
      	2 优先于对象存在。-->静态是先存在，对象是后存在。
     	3 被所有实例(对象)所共享。
      	4 可以直接被类名调用
5：静态变量（类变量）和实例变量的区别:
    	1存放位置
        	1：类变量随着类的加载而加载存在于方法区中.
         	2：实例变量随着对象的建立而存在于堆内存中.
    	2生命周期
         	1：类变量生命周期最长,随着类的消失而消失.
         	2：实例变量生命周期随着对象的消失而消失.
6：静态优缺点
  1： 优点:对对象的共享数据进行单独空间的存储,节省空间 例如Person 都有
  国籍。该数据可以共享可以被类名调
  2：缺点：生命周期过长
          	访问出现局限性。（静态只能访问静态）
7: 什么时候定义静态变量
		1:静态变量（类变量）当对象中出现共享数据
		  例如：学生的学校名称。学校名称可以共享
		        对象的数据要定义为非静态的存放在对内存中（学生的姓名，学生的年龄）
8：什么时候定义静态函数
如果功能内部没有访问到非静态数据（对象的特有数据。那么该功能就可以定义为静态）
9：静态的应用
		自定义数组工具类


*/
