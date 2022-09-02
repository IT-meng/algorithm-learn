package sort;

import java.util.Arrays;

public class InsertSort {
    //对arr中在下标为begin-end的数排序
    public static void  insertSort(int[] arr,int begin,int end){
        if(begin==end||end==-1)return;
        for(int i=begin+1;i<=end;i++){
            //begin到i-1位置已有序，使begin到i位置有序
            int j=i-1;
            //比较i位置上的数和它前面的数，i位置的数小，就把它往前移
            while(j>=begin&&arr[j]>arr[j+1]){
                swap( arr,j,j+1);
                j--;
            }
        }
    }
    //i和j必须不同才能如此交换
    public static void swap(int[] arr,int i,int j){
        if(i==j)return;
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void printArry(int [] arr,int begin,int end){
        for(int i=begin;i<=end;i++){
            System.out.println(arr[i]);
        }
    }

    public static int[] generateArry(int size,int maxValue){
        int[] arr=new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*(maxValue+1));

        }
        return arr;
    }
    public static void main(String[] args) {
//        int[] arr1=new int[10];
//        for(int i=0;i<10;i++){
//            arr1[i]=(int)(Math.random()*101);
//        }
//        System.out.println("排序前：");
//        printArry(arr1,0,arr1.length-1);
//        System.out.println("排序后：");
//        insertSort(arr1,0,arr1.length-1);
//        printArry(arr1,0,arr1.length-1);
        int maxSize,maxValue;
        maxSize=1000;
        maxValue=100000;
        int testTimes=50000;//测试次数
        boolean flag=false;
        System.out.println("测试开始！！");
        for(int t=0;t<testTimes;t++){
            int[] arr1=Generator.getRandomArray(maxSize,maxValue);//生成随机长度，每个元素随机的数组
            int[] arr2=Generator.copyArray(arr1);
            Arrays.sort(arr1);
            insertSort(arr2,0,arr2.length-1);
            for(int i=0;i<arr1.length;i++){
                if(arr1[i]!=arr2[i]){
                    flag=true;
                    break;
                }
            }
            if (flag==true){
                break;
            }
            System.out.println("第"+t+"次测试");
        }

        System.out.println(flag?"有问题arr1和arr2不一致":"经过50000次测试没问题");
    }

    public static boolean isEqual(int [] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
