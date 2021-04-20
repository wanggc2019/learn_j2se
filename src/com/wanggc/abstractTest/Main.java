package com.wanggc.abstractTest;

/**
 * @author wanggc
 * @date 2019/06/02 星期日 9:36
 */
public class Main {
    public static void main(String[] args) {
        Dog2 dog2 = new Dog2("旺财");
        Bird bird =new Bird("富贵");

        dog2.shout();
        bird.shout();
/*        Animal2 animal2 = new Animal2() {
            @Override
            void shout() {
                System.out.println(name + "是我的字类");
            }
        };*/
    }
}
