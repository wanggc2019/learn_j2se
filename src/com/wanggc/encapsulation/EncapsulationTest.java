package com.wanggc.encapsulation;

/**
 * @author wanggc
 * @date 2019/05/25 星期六 11:13
 */
public class EncapsulationTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        cal.init(45,'%',2);
        cal.calculate();
        System.out.println("计算完毕，再来一次");
    }
}
