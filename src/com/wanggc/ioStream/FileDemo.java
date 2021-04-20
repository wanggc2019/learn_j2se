package com.wanggc.ioStream;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wanggc
 * @date 2019/06/28 星期五 23:14
 */

public class FileDemo {
    public static void main(String[] args) {
        FileDemo.listAllFileAndDirs("E:\\娱乐");

        String path = "E:"+File.separatorChar+"娱乐";
        File file = new File(path);
        listJavaFile(file,"java");
    }

    public static void listAllFileAndDirs(String path){
    //创建File对象，表示这个目录
        File dir = new File(path);
    //    通过listFiles方法得到所包含的所有子目录与子文件名称
        File[] name = dir.listFiles();
    //    显示这些名称
/*        for (int i = 0;i < name.length;i++){
            File file = name[i];
            if (file.isFile()){
                System.out.println("子文件：");
                System.out.println("\t"+file.getName());
            } else if (file.isDirectory()){
                System.out.println("子目录：");
                System.out.println("\t"+file.getName());
            }
        }*/
        //3,得到所有的文件名集合，与所有的文件夹名集合
        List<File> fileList = new ArrayList<>();
        List<File> dirList = new ArrayList<>();
        for (int i = 0;i < name.length;i++){
            File file = name[i];
            if (file.isFile()){
                fileList.add(file);
            } else if (file.isDirectory()){
                dirList.add(file);
            }
        }
        //4，分别显示文件名与文件夹名
        System.out.println("********子文件********");
        for (int i = 0;i < fileList.size();i++){
            System.out.println("\t"+fileList.get(i).getName());
        }
        System.out.println();

        System.out.println("*******子目录*******");
        for (int i =0;i < dirList.size();i++){
            System.out.println("\t"+ dirList.get(i).getName());
        }
        System.out.println();
    }

    //    找出指定目录中所有扩展名为.java的文件
    public static void listJavaFile(File dir,String extension){
        //    1.获取所有的子文件和目录
        //File[] files = dir.listFiles();
        String[] files = dir.list(new DirFilter("java"));
        //    2.从中找出后缀式java的文件
        System.out.println("*******java文件*******");
        for (int i = 0;i < files.length;i++){
            System.out.println("\t"+files[i]);
        }
/*        for (int i =0;i < files.length;i++){
            File file = files[i];
            if (file.getName().endsWith(extension)){
                System.out.println(file.getName());
            }
        }
*/
    }
}

//DirFilter 就是实现了accept 方法.提供给File类的list方法使用.
class DirFilter implements FilenameFilter{
    private String extension;

    public DirFilter(){

    }

    public DirFilter(String extension){
        this.extension = extension;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }
}
