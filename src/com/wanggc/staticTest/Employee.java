package com.wanggc.staticTest;

/**
 * @author wanggc
 * @date 2019/05/24 星期五  15:04
 */
class Employee {
    private String name;
    private String id;
    private String gender;

    public void work(){
        System.out.println(id+":"+name+":"+gender+" 努力学习中");
    }

//    提供公有的get ，set方法
    public String getName(){
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getId(){
        return id;
    }

    public void setId(String i){
        id = i;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gen){
        if ("男".equals(gen) || "女".equals(gen)) {
            gender = gen;
        } else {
            System.out.println("清输入\"男\"或者\"女\"");
        }

    }
}
