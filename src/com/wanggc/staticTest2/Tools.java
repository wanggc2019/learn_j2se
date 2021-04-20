package com.wanggc.staticTest2;

/**
 * @author wanggc
 * @date 2019/05/27 星期一 16:12
 */

/*
* /*
	定义数组工具类
	1:定义一个遍历数组的函数
	2:定义一个求数组和的功能函数  1. 遍历  2. 两两相加
	3:定义一个获取数组最大值的功能函数
	4:定义一个获取数组最大值角标的功能函数
	5:定义一个返回指定数在指定数组中包含的角标的功能函数
	6:定义一个可以用于排序int数组的函数
		1:冒泡
		2:选择

	定义自己的工具类

* */
public class Tools {
    private Tools(){

    }
    //1:定义一个遍历数组的函数
    public static void print(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            if (i != (arr.length-1)) {
                System.out.print(arr[i]+",");
            }
            else {
                System.out.println(arr[i]);
            }
        }
    }

//    2:定义一个求数组和的功能函数
    public static int sum_arrs(int[] arr){
        int sum = 0;
        for (int i = 0; i <arr.length ; i++) {
            sum += arr[i];
        }
        return sum;
    }

//    3.功能函数：求数组的最大值
    public static int max_arrs(int[] arr){
        int max = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }
        return arr[max];
    }

//    4:定义一个获取数组最大值角标的功能函数
    public static int max_index(int[] arr){
        int max = 0;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[max] == arr[i]) {
                max = i;
            }
        }
        return max;
    }

//    5:定义一个返回 指定数在指定数组中包含的角标的功能函数
    public static int getIndex(int[] arr,int src){
        int index = -1;
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i] == src) {
                index = i;
            }
        }
        return index;
        }

    //    bubble sort
    public static void beuuleSort(int[] arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            if (arr[i] > arr[i+1]) {
                int tmp = arr[i+1];
                arr[i+1] = arr[i];
                arr[i] = tmp;
            }
        }
    }
    // 选择排序
    public static void selectSort(int[] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int y = 0; y < arr.length; y++) {
                if (arr[i] > arr[y]){
                    int tmp = arr[y];
                    arr[y] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }

    // 7：定义一个可以将整数数组进行反序的功能函数。
    public static void reverseSort(int[] arr){
        int start = 0;
        int end = arr.length-1;
        for (int i = 0; i < arr.length ; i++) {
            if (start < end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;
            }

            start++;
            end--;
        }
    }

//    8.折半查找
    public static int halfSearch(int key, int[] arr){
        int min = 0;
        int max = arr.length-1;
        int mid = 0;

        while (min < max){
            mid = (min + max) / 2;
            if (key >arr[mid]){
                min = mid +1;
            }
            else if (key < arr[mid]){
                max = mid -1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

}



