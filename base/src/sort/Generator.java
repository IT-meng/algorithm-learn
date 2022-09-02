package sort;

public class Generator {
    public static int[] getRandomArray(int maxSize,int maxValue){
        int [] arr=new int[(int)(Math.random()*(maxSize+1))];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)((Math.random()*(maxValue+1))-(Math.random()*maxValue));
        }
        return arr;
    }
    public static int[] getPlusRandomArray(int maxSize,int maxValue){
        int [] arr=new int[(int)(Math.random()*(maxSize+1))];
        for(int i=0;i<arr.length;i++){
            arr[i]=(int)(Math.random()*(maxValue+1));
        }
        return arr;
    }
    public static int[] copyArray(int[] arr1){
        int[] arr2=new int[arr1.length];
        for(int i=0;i<arr1.length;i++){
            arr2[i]=arr1[i];
        }
        return arr2;
    }
}
