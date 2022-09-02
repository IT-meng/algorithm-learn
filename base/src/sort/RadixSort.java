package sort;

import java.util.Arrays;

public class RadixSort {
    public static void radixSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        int digit=maxbits(arr);
        radixSort(arr,0,arr.length-1,digit);
    }
    //digit为arr中最大的数的十进制位数
    public static void radixSort(int[] arr,int L,int R,int digit){
        final int radix=10;
        //声明一个和原数组等大小的辅助数组
        int[] help =new int[R-L+1];
        for(int d=1;d<=digit;d++){//根据最大的数有几位决定做几次入桶出桶操作
            //count为计数数组，当桶用
            int [] count=new int[radix];
            //遍历arr并得到每个数的第d位,并用count数组计数
            for (int i = 0; i < arr.length; i++) {
                count[getDigit(arr[i],d)]++;
            }
            //将count数组处理成前缀和
            for (int i = 1; i < radix; i++) {
                count[i]=count[i]+count[i-1];

            }
            //从右往左遍历arr，并依次取出其第d位上的数
            //将arr[i]放在help中下标为count[getDigit(arr[i],d)]-1的位置，count[getDigit(arr[i],d)]--
            for (int i = arr.length-1; i >=0 ; i--) {
                help[--count[getDigit(arr[i],d)]]=arr[i];
            }
            //将help数组拷贝回arr，达到一次入桶出桶的效果
            for (int i = 0; i <arr.length ; i++) {
                arr[i]=help[i];
            }
        }

    }
    public static int getDigit(int x,int d){//得到x的第d位上的数
        return ((x/(int)(Math.pow(10,d-1)))%10);
    }
    public static int maxbits(int[] arr){
        //找数组中最大的值有几位
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            max=arr[i]>max?arr[i]:max;
        }
        //统计max有几位
        int cnt=0;
        if(max==0)cnt++;
        while(max!=0){
            max/=10;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        boolean flag=true;
        int maxSize,maxValue;
        maxSize=1000;
        maxValue=100000;
        int testTimes=50000;//测试次数
        System.out.println("测试开始！！");
        for(int t=0;t<testTimes;t++){
            int[] arr1=Generator.getPlusRandomArray(maxSize,maxValue);//生成随机长度，每个元素随机的数组
            int[] arr2=Generator.copyArray(arr1);
            Arrays.sort(arr1);
            radixSort(arr2);
             flag=InsertSort.isEqual(arr1,arr2);
            System.out.println("第"+t+"次测试");
        }

        System.out.println(flag?"经过50000次测试没问题":"有问题arr1和arr2不一致");
    }
}
