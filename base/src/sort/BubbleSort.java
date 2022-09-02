package sort;

import java.util.Arrays;

public class BubbleSort {
 public static void bubbleSort(int[] arr,int begin,int end){
     if(begin==end||end==-1)return;
     //遍历数组如果左边的数比右边大就交换他俩
     for(int i=end;i>=0;i--){
         for(int j=begin;j<i;j++){
             if(arr[j]>arr[j+1]){
                 InsertSort.swap(arr,j,j+1);
             }
         }
     }
 }

    public static void main(String[] args) {
//        int[] arr=InsertSort.generateArry(1000,2000);
//        System.out.println("排序前：");
//        InsertSort.printArry(arr,0,arr.length-1);
//        System.out.println("排序后：");
//        bubbleSort(arr,0,arr.length-1);
//        InsertSort.printArry(arr,0,arr.length-1);

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
           bubbleSort(arr2,0,arr2.length-1);
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
