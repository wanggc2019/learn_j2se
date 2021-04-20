package com.wanggc.exception;

/**
 * @author wanggc
 * @date 2019/06/11 星期二 9:43
 */

/*
问题：现实中会出现新的病，就需要新的描述。
	分析： java的面向对象思想将程序中出现的特有问题进行封装。
	案例:  定义功能模拟凌波登录。(例如：lb(String ip))需要接收ip地址
1.	当没有ip地址时，需要进行异常处理。
1. 当ip地址为null是需要throw new Exception("无法获取ip");
               	2. 但Exception是个上层父类，这里应该抛出更具体的子类。
				3. 可以自定义异常
2.	自定义描述没有IP地址的异常（NoIpException）。
1. 和sun的异常体系产生关系。继承Exception类，自定义异常类名也要规范，结尾加上Exception,便于阅读

* */

////  1 子类覆盖父类方法父类方法抛出异常，子类的覆盖方法可以不抛出异常
class Father2{
    // 运行时异常
    void test() throws ClassNotFoundException{
        System.out.println("父类");
        throw new ClassNotFoundException();// 非运行时异常
    }
}

class Son2 extends Father2{
    @Override
    void test() {
        System.out.println("子类"); //父类方法有异常，子类没有
    }
}

class NoIpException extends Exception {
    NoIpException(){

    }

    NoIpException(String msg){
        super(msg);
    }
}

class ExceptionDemo2{
    public static void main(String[] args) throws ClassNotFoundException{

/*
        String ip = "134.64.14.130";
        ip = null;
        try{
            login(ip);
        } catch (NoIpException e){
            e.printStackTrace();
        }
*/
        //div(2,0);

        Father2 father2 = new Son2();
        father2.test();
    }

    public static void login(String ip) throws NoIpException{
        if (ip == null){
           throw new NoIpException("可能没插网线");
        }
        System.out.println("开始上课");
    }

    //RunTimeException 运行时异常
    //IllegalMonitorStateException是运行时异常没有声明。
    public static void div(int x,int y){
        if (y == 0){
            throw new ArithmeticException();
        }
        System.out.println(x/y);
    }
}
/*
RunntimeException的子类：
				ClassCastException
					多态中，可以使用Instanceof 判断，进行规避
				ArithmeticException
					进行if判断，如果除数为0，进行return
				NullPointerException
					进行if判断，是否为null
				ArrayIndexOutOfBoundsException
					使用数组length属性，避免越界
				这些异常时可以通过程序员的良好编程习惯进行避免的
1：遇到运行时异常无需进行处理，直接找到出现问题的代码，进行规避。
					2：就像人上火一样牙疼一样，找到原因，自行解决即可
					3：该种异常编译器不会检查程序员是否处理该异常
					4：如果是运行时异常，那么没有必要在函数上进行声明。
				6：案例
					1：除法运算功能（div(int x,int y)）
					2：if判断如果除数为0，throw new ArithmeticException();
					3：函数声明throws ArithmeticException
					4：main方法调用div,不进行处理
					5：编译通过，运行正常
					6：如果除数为0，报异常，程序停止。
					7：如果是运行时异常，那么没有必要在函数上进行声明。
1：Object类中的wait()方法，内部throw了2个异常 IllegalMonitorStateException InterruptedException
1：只声明了一个(throws) IllegalMonitorStateException是运行是异常没有声明。

* */


/*
3：总结
				1：子类覆盖父类方法是，父类方法抛出异常，子类的覆盖方法可以不抛
出异常，或者抛出父类方法的异常，或者该父类方法异常的子类。
				2：父类方法抛出了多个异常，子类覆盖方法时，只能抛出父类异常的子
集
				3：父类没有抛出异常子类不可抛出异常
					1：子类发生非运行时异常，需要进行try{}catch的(){}处理，不能
抛出。
				4：子类不能比父类抛出更多的异常

* */