package com.wanggc.moudelDesign;

/**
 * @author wanggc
 * @date 2019/06/13 星期四 15:20
 */
abstract class Cook {
    // 1.形成完成这项功能的模块代码，将模块代码声明为final，避免子类重写
    public final void doCook(){
    //    做饭
        System.out.println("买"+ food());
        System.out.println("洗"+ food());
        System.out.println("切"+ food());
        System.out.println("煮"+ food());
        System.out.println("吃"+ food());
        System.out.println("洗碗");
    }
    //将模板代码中可变得数据抽取为一个函数并修饰为抽象得
    public abstract String food();

}

//编写子类实现父类得未实现得功能
class MyCook extends Cook{
    @Override
    public String food() {
        return "鱼";
    }
}

class CookTest{
    public static void main(String[] args) {
        MyCook myCook = new MyCook();
        myCook.doCook();
    }
}
