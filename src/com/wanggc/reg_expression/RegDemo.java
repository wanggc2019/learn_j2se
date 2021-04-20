package com.wanggc.reg_expression;

/**
 * @author wanggc
 * @date 2019/06/27 星期四 22:17
 */
//正则表达式
public class RegDemo {
    public static void main(String[] args) {
        RegDemo.checkqq();
        RegDemo.checkTel();
        RegDemo.spiltStr();
    }

    //    检查QQ号的，首位不可为0，号码在5-15位之间
    public static void checkqq() {
        String qq = "3368149413";
        String reg = "[1-9][0-9]{4,14}";
        boolean result = qq.matches(reg);
        System.out.println("qq号码检测是否匹配（否false，是true）:" + result);
    }

    //匹配是否为一个合法的手机号码
    public static void checkTel() {
        String tel = "3368149413";
        String reg2 = "1[3589]\\d{9}]";//在字符串中，定义正则出现\ 要一对出现
        boolean result2 = tel.matches(reg2);
        System.out.println(tel+"is a tel num:" + result2);
    }
//    切割
    public static void spiltStr(){
        String str = "-1 99 4 23";
        String[] arr = str.split(" +");
        for (String s:arr){
            System.out.println(s);
        }
    }

}