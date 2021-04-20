package com.wanggc.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author wanggc
 * @date 2019/06/11 星期二 11:08
 */

/*
1: 实现方式一：
try{ // 可能发生异常的代码 } catch( 异常类的类型 e ){ // 当发生指定异常的时候的处理代码 }catch...
	 		比较适合用于专门的处理异常的代码，不适合释放资源的代码。
		2：实现方式二：
	 		try{  } catch(){} finally{ // 释放资源的代码 }
	 		finally块是程序在正常情况下或异常情况下都会运行的。
   			比较适合用于既要处理异常又有资源释放的代码
		3：实现方式三
			try{  }finally{ // 释放资源 }
	 		比较适合处理的都是运行时异常且有资源释放的代码。
 		4：finally:关键字主要用于释放系统资源。
     			1：在处理异常的时候该语句块只能有一个。
	 		2：无论程序正常还是异常，都执行finally。
		5：finally是否永远都执行？
    		1：只有一种情况，但是如果JVM退出了System.exit(0)，finally就不执行。
			2：return都不能停止finally的执行过程。
		6：案例使用流
			1：使用FileInputStream加载文件。
				导包import java.ioStream.FileInputStream;
			2：FileNotFoundException
				导入包import java.ioStream.FileNotFoundException;
			3：IOException
				import java.ioStream.IOException;

* */
public class FinallyTest {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;

        try{
            System.out.println("创建io流可能出现异常");
            fileInputStream = new FileInputStream("wgc.txt");
        } catch (FileNotFoundException e){
            System.out.println("找不到文件");
            //System.exit(0);
            //return;
        }
        finally {
            if (fileInputStream != null){
                try{
                    fileInputStream.close();
                } catch (IOException e){
                    e.printStackTrace();
                    System.out.println("close异常");
                }
            }
            System.out.println("finally 结束");
        }
        System.out.println("main结束");
    }
}

/*
2：无论程序正常还是异常，都执行finally。 但是遇到System.exit(0); jvm退出。
finally用于必须执行的代码， try{} catch(){}finally{}
try{}finally{}
*/

