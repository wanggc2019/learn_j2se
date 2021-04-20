package com.wanggc.string;

/**
 * @author wanggc
 * @date 2019/06/14 星期五 8:48
 */
/*
String类描述的是文本字符串序列。  留言   QQ   写日志。
创建String类的对象的两种方式：
1.	""直接赋值法
2.	new关键字法

* */

//去除字符串2边得空格
public class StringSpace {
//    定义一个去除字符串得2边得空格得函数
    public static String trim(String str){
    //    定义求字符串需要得起始索引变量
        int start = 0;
        int end = str.length() -1;
    //    for 循环遍历字符串对象得每一个字符串
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                start++;
            } else {
                break;
            }
        }
        System.out.println(start);

        for (;end < str.length() && end >= 0;){
            if (str.charAt(end) == ' '){
                end --;
            } else {
                break;
            }
        }
        System.out.println(end);

    //    求字串
        if (start < end){
            return str.substring(start,end);
        } else {
            return "_";
        }
    }

}

class TrimTest{
    public static void main(String[] args) {
        System.out.println(StringSpace.trim(" This is my wife "));
    }
}
