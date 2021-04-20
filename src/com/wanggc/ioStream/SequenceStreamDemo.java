package com.wanggc.ioStream;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.*;

/**
 * @author wanggc
 * @date 2019/07/01 星期一 22:28
 */

// SequenceInputStream序列流
//    将map3歌曲文件进行切割拷贝,并合并
public class SequenceStreamDemo {
    public static void main(String[] args) throws IOException{
        System.out.println("*******开始切割********");
        spilt(new File("E:\\娱乐\\Dream It Possible.mp3"),10,new File("E:\\娱乐\\"));
        System.out.println("*******切割完毕********");
        System.out.println();
/*
        System.out.println("********开始合并********");
        LinkedHashSet<InputStream> linkedHashSet = new LinkedHashSet<InputStream>();
        linkedHashSet.add(new FileInputStream(new File("E:"+File.separatorChar+"娱乐"+File.separatorChar+"part.1.mp3")));
        linkedHashSet.add(new FileInputStream(new File("E:"+File.separatorChar+"娱乐"+File.separatorChar+"part.2.mp3")));
        linkedHashSet.add(new FileInputStream(new File("E:"+File.separatorChar+"娱乐"+File.separatorChar+"part.3.mp3")));
        linkedHashSet.add(new FileInputStream(new File("E:"+File.separatorChar+"娱乐"+File.separatorChar+"part.4.mp3")));
        merger(linkedHashSet,new File("E:"+File.separatorChar+"娱乐"+File.separatorChar+"Dream It Possible_merge.mp3"));
        System.out.println("********合并完毕*********");
        */
    }

    private static void merger(LinkedHashSet<InputStream> hashSet, File dest) throws IOException {
        final Iterator<InputStream> it = hashSet.iterator();
        FileOutputStream fos = new FileOutputStream(dest);
        SequenceInputStream sis = new SequenceInputStream(new Enumeration<InputStream>() {
            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override
            public InputStream nextElement() {
                return it.next();
            }
        });

        byte[] bytes = new byte[1024*1024];
        int len = 0;
        while ((len = sis.read(bytes)) != -1){
            fos.write(bytes,0,len);
        }
        sis.close();
        fos.close();
    }
    // 1. 切割文件
    /*
     * 切割文件,切割份数, 切割后保存路径
     */
    private static void spilt(File src,int count,File dir) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = null;
        byte[] bytes = new byte[1024*1024];
        int len = 0;
        for (int i = 1;i <= count;i++){
            len = fis.read(bytes);
            if (len != -1){
                fos = new FileOutputStream(dir + "part."+ i + ".mp3");
                fos.write(bytes,0,len);
            }
            //fos.close();
        }
        fis.close();
    }

}
