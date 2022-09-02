package sort;
//大根堆
public class Heap {
    private int[] arr;
    private int heapSize;

    Heap() {

    }

    public Heap(int maxSize) {
        arr = new int[maxSize];
        heapSize = 0;

    }

    public void HeapInsert(int element) {//从下往上比较，每插入一个元素，比较它和它的父亲结点，它大就交换
        if (heapSize == arr.length) {
            System.out.println("数组越界。");
            return;

        }
        int index=heapSize;
        arr[heapSize++]=element;

        while(index>=0&&arr[(index-1)/2]>arr[index]){
            InsertSort.swap(arr,index,(index-1)/2);
            index=(index-1)/2;

        }
    }
    public static void heapIfy(int[] arr,int heapSize){

    }
}