package bruteForceRecursive;

public class Question8 {
    //先手函数，[l-r]上先选
    public static int first(int[] arr,int l,int r){
        if(l==r)return arr[l];//basecase
        //有两种选择选择大的那种
     return   Math.max(arr[l]+second(arr,l+1,r),arr[r]+second(arr,l,r-1));
    }
    public static int second(int[] arr,int l,int r){//后手函数
        if(l==r)return 0;//basecase
        return Math.min(first(arr,l+1,r),first(arr,l,r-1));
    }

    public static void main(String[] args) {
        int[] arr={1,100,2};
        int max = Math.max(first(arr, 0, arr.length - 1), second(arr, 0, arr.length - 1));
        System.out.println(max);
    }
}
