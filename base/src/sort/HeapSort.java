package sort;
import java.util.Arrays;

public class HeapSort {
public static void heapSort(int[] arr){
    if(arr==null||arr.length==1){
        return;
    }
    for(int i=arr.length-1;i>=0;i--){
        heapify(arr,i,arr.length);
    }//从最后一个位置开始往前依次每个位置做heapify操作使整个数组满足堆结构
    int heapSize=arr.length;//heapSize表示当前数组中满足堆结构的部分的长度
    while(heapSize>0){
        InsertSort.swap(arr,0,--heapSize);
        heapify(arr,0,heapSize);
    }
}
public static void heapInsert(int[] arr,int index){
    while(arr[(index-1)/2]<arr[index]){//当前节点结点比父结点大时交换他俩
        InsertSort.swap(arr,index,(index-1)/2);
        index=(index-1)/2;//更新当前节点
    }
}
//将第一个位置的数拿走后，放另一个数在第一个位置，其它位置仍然满足堆结构
public static void heapify(int[] arr,int index,int heapSize){
    int left=2*index+1;//左孩子
    while(left<heapSize){//当左孩子存在时
        int largest=(left+1)<heapSize&&arr[left+1]>arr[left]?left+1:left;//找出左右孩子中的最大值下标
        largest=arr[index]>arr[largest]?index:largest;//找出左右孩子和父亲中最大值下标
        if(largest==index){
            break;
        }//最大值不是当前位置，交换
        InsertSort.swap(arr,index,largest);
        index=largest;//更新当前位置
        left=2*index+1;//更新左孩子
    }
}

    public static void main(String[] args) {
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
        heapSort(arr2);
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
