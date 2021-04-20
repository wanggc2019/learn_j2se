package com.wanggc.innerClass;

/**
 * @author wanggc
 * @date 2019/06/09 星期日 22:29
 */
class Outer {
    int num = 10;

    // 内部类
    //class Inner{
    //私有的内部类只能在当前的类可见
    //private class Inner

    static class Inner{
        int count = 20;
        // 静态的成员只能定义在静态的内部类中
        static int i = 30;

        //    内部类函数
        public void print(){
            // 内部类可以直接访问外部类
            System.out.println("内部类直接访问外部类成员:"+i);
        }
    }

    public void show(){
        // 外部类需要访问内部类的成员属性时需要创建内部类的对象。
        /*
        1.	在外部类的成员函数中创建内部类的对象，通过内部类对象对象直接访问内部类的成员。
        2.	在其他类中直接创建内部类的对象。
          Outer.Inner inner = new Outer().new Inner();
        * */
        System.out.println("外部内成员函数访问内部类成员："+new Inner().count);
    }
}

class InnerTest{
    public static void main(String[] args) {
        // 其他类访问内部类成员，需要先创建内部类对象
        //私有的成员内部类不能在其他类中直接创建内部类对象来访问。
        //Outer.Inner inner = new Outer().new Inner();
        //内部类使用statix修饰时，创建内部类对象的形式，注意，与上面时不同得
        Outer.Inner inner = new Outer.Inner();
        inner.print();
        new Outer().show();

    }
}

/*
* 如果内部类中包含有静态成员，那么java规定内部类必须声明为静态的访问静态内部类的形式：Outer.Inner in = new Outer.Inner();
 * */

/*
总结：成员内部类(成员属性、成员方法)特点:
1.	私有的成员内部类
		     特点：不能在其他类中直接创建内部类对象来访问
2.	 静态的成员内部类
		     特点：如果内部类中包含有静态成员，那么java规定内部类必须声明为静的
			 访问静态内部类的形式：
			 Outer.Inner in = new Outer.Inner();

* */