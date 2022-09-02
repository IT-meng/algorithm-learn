package sort;

import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] arr, int begin, int end) {
        if(begin==end||end==-1)return;
        //从begin到end位置找出最小的数放begin位置
        //从begin+1到end位置找最小的数放begin+1位置
        for (int i = begin; i <= end; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= end; j++) {
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }

            }
            if(minIndex!=i){
                swap(arr,i,minIndex);
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
    public static void printArry(int [] arr,int begin,int end){
        for(int i=begin;i<=end;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
//        int[] arr1=new int[10];
//        for(int i=0;i<10;i++){
//            arr1[i]=(int)(Math.random()*101);
//        }
//        System.out.println("排序前：");
//        printArry(arr1,0,arr1.length-1);
//        System.out.println("排序后：");
//       selectSort(arr1,0,arr1.length-1);
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
            selectSort(arr2,0,arr2.length-1);
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
}