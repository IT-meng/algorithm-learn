package preprocessing;

public class ColorLeftRight {

    //输入:颜色序列RGRGRGRG
    //输出:将RGRGRGRG变成RRRRGGGG(R的左边不能有G)最少需要变化的次数

    /*
    * 思路：
    * 假设左区域的长度为L(0-s.length),右区域的长度为s.length-L
    * 将左区域全变成R，右区域全变成G
    * 统计需要变化的最小次数找出最佳方案
    * */
//    public int minPaintTest(String str){
//        char[] s = str.toCharArray();
//        for (int L = 0; L <= s.length; L++) {
//            if(L==0){
//                统计 s[0..s.length-1]有多少个R,全染成G
//            }else if(L==s.length){
//                统计 s[0..s.length-1]有多少个G,全染成R
//            }else {
//                统计 s[0..L-1]上有多少个G,全染成R
//                统计 s[L..s.length-1]上有多少个R,全染成G
//            }
//        }
//        统计L为多少时,需要染色的次数最少,并返回
//    }

    /*
    * 先预处理一下:得到两个数组
    * left[i]:0..i上有多少个G
    * right[i]:i..s.length-1上有多少个R
    * */

    public static int[] getLeft(char[] arr){
        //预处理得到left
        int[] left = new int[arr.length];
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            if(i==0){
                left[i]=arr[i]=='G'?1:0;
            }else {
                if(arr[i]=='G'){
                    left[i]=left[i-1]+1;
                }else {
                    left[i]=left[i-1];
                }
            }
        }
        return left;
    }

    public static int[] getRight(int[] left){
        int N = left.length;
        //得到right
        // right[i] = (N-i)-(left[N-1]-left[i-1])
        // right[0] = (N-i)-left[N-1]
        int[] right = new int[N];
        for (int i = 0; i < N; i++) {
            if(i==0){
                right[i]=N-i-left[N-1];
            }else {
                right[i] = N-i-(left[N-1]-left[i-1]);
            }
        }
        return right;
    }
    public static int minPaint(String str){
        char[] arr = str.toCharArray();
        int[] left = getLeft(arr);
        int[] right = getRight(left);
        int min = Integer.MAX_VALUE;
     for (int L=0;L<=arr.length;L++){
         if(L==0){
           if(right[0]< min){
               min = right[0];
           }
         }else if(L==arr.length){
             if(min>left[arr.length-1]){
                 min = left[arr.length-1];
             }
         }else {
             if ((left[L-1]+right[L])<min){
                 min = left[L-1]+right[L];
             }
         }
     }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minPaint("RGRGRGG"));
    }
}
