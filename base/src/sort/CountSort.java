package sort;

public class CountSort {
    //arr中不能有负数
    public  static void countSort(int[] arr){
        int max=Integer.MIN_VALUE;//让max取一个很小的数
        //遍历数组找出数组中的最大值
        for(int i=0;i<arr.length;i++){
            max=arr[i]>max?arr[i]:max;
        }
        //bucket的下标：0~max,bucket[j]表示arr[?]==j在arr中出现的次数
        int[] bucket=new int[max+1];
        //遍历arr统计各个值出现的次数,并将其记录在bucket中
        for(int i=0;i<arr.length;i++){
            bucket[arr[i]]++;
        }
        int j=0,i=0;
        //根据bucket[j]的值控制填几个j到arr中

        for ( j = 0; j < bucket.length ; j++) {
            while(bucket[j]-->0){
                arr[i++]=j;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr=InsertSort.generateArry(5,10);
        InsertSort.printArry(arr,0,arr.length-1);
        System.out.println("========================================");
        countSort(arr);
        InsertSort.printArry(arr,0,arr.length-1);
    }
}
