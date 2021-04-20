package com.wanggc.singleInstrance;

    /**
     * @author wanggc
     * @date 2019/05/28 星期二 9:59
     */

// 3.懒汉式 线程不安全，不可用
    public class Single2 {
        // 1.再类中创建一个私有的本类对象
        private static Single2 instance;

        // 2.私有化构造方法
        private Single2() {

        }

        //3.对外提供公有方法获取该对象，该方法通过用类名调用
        //
        public static Single2 getInstance() {
            if (instance == null) {
                instance = new Single2();
            }
            return instance;
        }
    }
        /*
         *1.优点：这种写法起到了Lazy Loading的效果，但是只能在单线程下使用。
         * 2.缺点：如果在多线程下，一个线程进入了if (singleton == null)判断语句块，
         * 还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式。
         * */






