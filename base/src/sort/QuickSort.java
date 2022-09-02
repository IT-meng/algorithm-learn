package sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int L, int R) {
       if(L==R||R==-1)return;
       int[] part=partition(arr,L,R);
       quickSort(arr,L,part[0]);
       quickSort(arr,part[1],R);

    }
    public static int[] partition(int[] arr,int L,int R){
        //从L~R随机选一个数做划分，让它和最后一个数做交换
        //使<arr[rdm]的数放左边>arr[rdm]的数放右边，==arr[rdm]的数放中间
        int rdm = (int) ((Math.random() * (R - L + 1)) + L);
        if (rdm != R) {
            InsertSort.swap(arr,rdm,R);
        }


        int small=L-1;//小于区右边界
        int large=R;//大于区左边界
        for(int i=L;i<R&&i<large;){
            //arr[i]比划分值小，让它和小于区的下一个数做交换，向右扩展小于区，i++
            if(arr[i]<arr[R]){
                InsertSort.swap(arr,small+1,i);
                small++;
                i++;
            }
            else if(arr[i]==arr[R]){//相等，i++
                i++;
            }else{//arr[i]>arr[R],让它和大于区前一个做交换，向左扩展大于区，i不变
                InsertSort.swap(arr,large-1,i);
                large--;
            }
        }
        //让划分值和大于区的第一个做交换
        InsertSort.swap(arr,large,R);
        int[] part=new int[2];
        if(small==L-1)small++;
        part[0]=small;//等于区左边界
        if(large!=R)large++;
        part[1]=large;//等于区右边界
        return part;
    }

    public static void main(String[] args) {
//        int[] arr=InsertSort.generateArry(1000,2000);
//        System.out.println("排序前：");
//        InsertSort.printArry(arr,0,arr.length-1);
//        System.out.println("快排后：");
//        quickSort(arr,0,arr.length-1);
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
            quickSort(arr2,0,arr2.length-1);
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