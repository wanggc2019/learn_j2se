package com.wanggc.ioStream;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;

/**
 * @author wanggc
 * @date 2019/06/29 星期六 22:12
 */

/*
IO流技术
* */
// 读取文件内容
public class IOStreamDemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String srcpath = "E:" + File.separatorChar + "娱乐" + File.separatorChar + "test.java";
        String despath = "E:" + File.separatorChar + "娱乐" + File.separatorChar + "test2.java";
        readFile2(despath);
        //copyFile6(srcpath, despath);
        //String path = "E:"+File.separatorChar+"娱乐"+File.separatorChar+"test.java";
        //writeFile2(path);
        //writeFile3(path);
        //wirteFile();
        //readFile();
        //showContent("E:"+File.separatorChar+"娱乐"+File.separatorChar+"test2.java");
        //showContent2("E:"+File.separatorChar+"娱乐"+File.separatorChar+"test2.java");
        //showContent3("E:"+File.separatorChar+"娱乐"+File.separatorChar+"test2.java");


    }

    //写入字节
    public static void writeFile() throws IOException {
        //创建文件对象
        File file = new File("E:" + File.separatorChar + "娱乐" + File.separatorChar + "test.java");
        //    创建文件输出流
        FileOutputStream fos = new FileOutputStream(file);
        System.out.println("*******写入字节********");
        fos.write('H');
        fos.write('e');
        fos.write('l');
        fos.write('l');
        fos.write('o');
        fos.close();
        System.out.println();
    }

    //高效写入，数组
    public static void writeFile2(String path) throws IOException {

        //1：打开文件输出流，流的目的地是指定的文件
        FileOutputStream fos = new FileOutputStream(path);
        //2：通过流向文件写数据
        byte[] bytes = "java".getBytes();
        fos.write(bytes);
        System.out.println("*******写入字节********");
        fos.close();
        System.out.println();
    }

    //追加写入
    public static void writeFile3(String path) throws IOException {

        //1：打开文件输出流，流的目的地是指定的文件
        FileOutputStream fos = new FileOutputStream(path, true);
        //2：通过流向文件写数据
        byte[] bytes = "java_append".getBytes();
        fos.write(bytes);
        System.out.println("*******写入字节********");
        fos.close();
        System.out.println();
    }

    //读取字节
    public static void readFile() throws FileNotFoundException, IOException {
        //    创建文件对象
        File file = new File("E:" + File.separatorChar + "娱乐" + File.separatorChar + "test.java");
        //    创建文件输入流
        FileInputStream fis = new FileInputStream(file);
        //    读取字节
        System.out.println("********读取字节********");
        for (int i = 0; i < file.length(); i++) {
            System.out.println((char) fis.read());
        }
        fis.close();
        System.out.println();
    }

    //    字节流
    public static void showContent(String path) throws IOException {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            byte[] bytes = new byte[1024];
            int len = fileInputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }


/*    //    打开流
        FileInputStream fis = new FileInputStream(path);
        //通过流读取内容
        byte[] bytes = new byte[1024];
        int len = fis.read(bytes);
        for (int i = 0;i < len;i++){
            System.out.println((char) bytes[i]);
        }*/

/*        int length;
        System.out.println("********读取字节流*******");
        while ((length = fis.read()) != -1){
            System.out.println((char) length);
        }

        fis.close();
 */

    }

    //    字节流
    public static void showContent2(String path) throws IOException {
        //    打开流
        FileInputStream fis = new FileInputStream(path);

        //通过流读取内容
        byte[] bytes = new byte[1024];
        //从什么地方开始存读到的数据
        int start = 5;
        //希望最多读多少个(如果是流的末尾，流中没有足够数据)
        int maxLen = 6;

        int len = fis.read(bytes);
        for (int i = 0; i < start + maxLen; i++) {
            System.out.println((char) bytes[i]);
        }
        fis.close();
    }

    //    缓存提高读取速度
    public static void showContent3(String path) throws IOException {
        //    打开流
        FileInputStream fis = new FileInputStream(path);

        //通过流读取内容
        byte[] bytes = new byte[1024];
        int len = 0;
        System.out.println("*****读取内容******");
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        fis.close();
    }

    //    拷贝文件
    public static void copyFile(String srcpath, String despath) throws IOException {
        // 打开输入输出流
        FileInputStream fis = new FileInputStream(srcpath);
        FileOutputStream fos = new FileOutputStream(despath);
        //    读取和写入
        int len = 0;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }
        //关闭流
        fis.close();
        fos.close();
    }

    //    字节流拷贝文件
    public static void copyFile2(String srcpath, String despath) throws IOException {
/*    // 打开输入输出流
    FileInputStream fis = new FileInputStream(srcpath);
    FileOutputStream fos = new FileOutputStream(despath);
    //    读取和写入
    int len = 0;
    byte[] bytes = new byte[1024];
    while ((len = fis.read(bytes)) != -1){
        fos.write(bytes);
    }
    //关闭流
    fis.close();
    fos.close();
}*/

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(srcpath);
            fos = new FileOutputStream(despath);

            byte[] bytes = new byte[1024 * 1024];
            int len = 0;

            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }

        }

    }

    //字节缓冲流
    public static void copyFile3(String srcpath, String despath) throws IOException {
        //打开输入输出流
        FileInputStream fis = new FileInputStream(srcpath);
        FileOutputStream fos = new FileOutputStream(despath);

        //    使用缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //   读取 写入
        int len = 0;
        while ((len = bis.read()) != -1) {
            bos.write(len);
        }

        //    关闭流
        bis.close();
        bos.close();

    }

    //    字符流拷贝文件
    public static void copyFile4(String srcpath, String despath) throws IOException {
        //打开输入输出流
        Reader reader = new FileReader(srcpath);
        Writer writer = new FileWriter(despath);

        //   读取 写入
        int ch = -1;
        char[] arr = new char[1024];
        while ((ch = reader.read(arr)) != -1) {
            writer.write(arr, 0, ch);
        }

        //    关闭流
        reader.close();
        writer.close();
/*
* 字节流可以拷贝视频和音频等文件，那么字符流可以拷贝这些吗？
经过验证拷贝图片是不行的。发现丢失了信息，为什么呢？
计算机中的所有信息都是以二进制形式进行的存储（1010）图片中的也都是二进制
在读取文件的时候字符流自动对这些二进制按照码表进行了编码处理，但是图片本来就是二进制文件，不需要进行编码。
有一些巧合在码表中有对应，就可以处理，并不是所有的二进制都可以找到对应的。信息就会丢失。所以字符流只能拷贝以字符为单位的文本文件
（以ASCII码为例是127个，并不是所有的二进制都可以找到对应的ASCII，有些对不上的，就会丢失信息。）

* */
    }

    //字节流的异常处理
    public static void copyFile5(String srcpath, String despath) throws IOException {
        //打开输入输出流
        Reader reader = null;
        Writer writer = null;

        try {
            reader = new FileReader(srcpath);
            writer = new FileWriter(despath);

            int ch = -1;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null){
                    reader.close();
                }
            } catch (Exception e){
                throw new RuntimeException(e);
            } finally {
                try {
                    if (writer != null){
                        writer.close();
                    }
                } catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }

//    字符流缓冲
public static void copyFile6(String srcpath, String despath) throws IOException {
    //创建字符输入 输出流
    Reader fr = new FileReader(srcpath);
    Writer wr = new FileWriter(despath);

//    字符缓冲流
    BufferedReader br = new BufferedReader(fr);
    BufferedWriter bw = new BufferedWriter(wr);

    String line = null;
//    一次读取一行
    while ((line = br.readLine()) != null){
    //    一次写一行
        bw.write(line);
    //    刷新
        bw.flush();
    //    进行换行,由于readLine方法默认没有换行.需要手动换行
        bw.newLine();
    }

    br.close();
    bw.close();
}

//装饰器模式
    public static void readFile2(String path) throws IOException{
        Reader reader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(reader);
        BufferedReader br = new MyQutoBufferedReader(bufferedReader);
        br = new MyLineBufferedReader(br);

        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
    }

}

class MyQutoBufferedReader extends BufferedReader{
    private BufferedReader bufferedReader;
    public MyQutoBufferedReader(BufferedReader bufferedReader){
        super(bufferedReader);
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line != null){
            return "\"" + line + "\"";
        } else {
            return null;
        }
    }
}
/*
装饰器模式：
	使用分层对象来动态透明的向单个对象中添加责任（功能）。
	装饰器指定包装在最初的对象周围的所有对象都具有相同的基本接口。
	某些对象是可装饰的，可以通过将其他类包装在这个可装饰对象的四周，来将功能分层。
	装饰器必须具有和他所装饰的对象相同的接口。

* */
class MyLineBufferedReader extends BufferedReader{
    private BufferedReader bufferedReader;
    public MyLineBufferedReader(BufferedReader bufferedReader){
        super(bufferedReader);
        this.bufferedReader = bufferedReader;
    }

    int count = 0;

    @Override
    public String readLine() throws IOException {
        String line = super.readLine();
        if (line != null){
            count++;
            return count + ":"+line;
        } else {
            return null;
        }
    }
}