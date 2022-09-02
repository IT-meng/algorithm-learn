package sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int L, int R) {
        //使arr在L-R范围内有序
        if (L == R||R==-1) return;
        int mid = L + ((R - L) >> 1);
        //使arr在L-mid上有序
        mergeSort(arr, L, mid);
        //使arr在mid+1~R上有序
        mergeSort(arr, mid + 1, R);
        //合并两个有序的部分，并将结果拷贝回原数组
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0, j = mid + 1,k=L;
        //将arr中两个有序的部分合并到help数组，使help数组仍然有序
        while (k<= mid && j <= R) {
            help[i++] = arr[k] <= arr[j] ? arr[k++] : arr[j++];
        }
        while(k<=mid){
            help[i++]=arr[k++];
        }
        while(j<=R){
            help[i++]=arr[j++];
        }

        //将help数组中的值拷回arr
        for(int m=L;m<=R;m++){
            arr[m]=help[m-L];
        }
    }

    public static void main(String[] args) {
//        int[] arr=InsertSort.generateArry(1000,2000);
//        System.out.println("排序前：");
//        InsertSort.printArry(arr,0,arr.length-1);
//        mergeSort(arr,0,arr.length-1);
//        System.out.println("排序后：");
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
            mergeSort(arr2,0,arr2.length-1);
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