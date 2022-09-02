package str;

//Manacher算法用于求最长回文子串
public class Manacher {
    //返回回文半径数组
    public static int[] manacher_my(String str){
        int R=-1;//最大回文右边界
        int C=-1;//回文右边界的中心
        char[] res = process(str);
        int[] pArr=new int[res.length];
        for (int i=0;i<res.length;i++){
            //判断当前来到的位置是否在R之内
            if(i<=R){
                //求i位置关于C对称的j位置
                int j=2*C-i;
                //分三种情况
                //1、j位置的回文区域在L-R范围之内(L为R关于C的对称点)
                if(pArr[j]-1<(j-2*C+R)){
                    pArr[i]=pArr[j];
                }else if(pArr[j]-1>(j-2*C+R)){
                    //2、j位置的回文区域有部分在L-R范围之外
                    pArr[i]=R-i+1;
                }else{
                    //3、j位置的回文区域左边界和L重合
                    pArr[i]=R-i+1;
                    //再往外硬扩
                    int l=i-pArr[i];
                    int r=i+pArr[i];
                    while(l>-1 && r< res.length && res[l]==res[r]){
                        l--;
                        r++;
                        pArr[i]++;
                    }
                    if(i+pArr[i]-1>R){
                        R=i+pArr[i]-1;
                        C=i;
                    }
                }
            }else{
                //不在R之内,硬扩
                int l=i-1;
                int r=i+1;
                pArr[i]=1;
                while(l>-1&&r<res.length&&res[l]==res[r]){
                    l--;
                    r++;
                    pArr[i]++;
                }
                //更新R,C
                if(i+pArr[i]-1>R){
                    R=i+pArr[i]-1;
                    C=i;
                }
            }
        }
        return pArr;
    }
    public static int manacher_zuo(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // "12132" -> "#1#2#1#3#2#"
        char[] str = process(s);
        // 回文半径的大小
        int[] pArr = new int[str.length];
        int C = -1;
        // 讲述中：R代表最右的扩成功的位置
        // coding：最右的扩成功位置的，再下一个位置
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length; i++) { // 0 1 2
            // R第一个违规的位置，i>= R
            // i位置扩出来的答案，i位置扩的区域，至少是多大。
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length && i - pArr[i] > -1) {
                if (str[i + pArr[i]] == str[i - pArr[i]])
                    pArr[i]++;
                else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
    public static char[] process(String str){
        char[] strs = str.toCharArray();
        char[] res=new char[2*strs.length+1];
        int index=0;
        for (int i = 0; i < res.length; i++) {
            if(i%2==0)res[i]='#';
            else res[i]=strs[index++];
        }
        return res;
    }

    public static void main(String[] args) {
       String str= "aabtctstctbaa";
        System.out.println(process(str));
        int[] manacher = manacher_my(str);

//        for (int i: manacher){
//            System.out.print(i);
//        }
//        System.out.println();
        int max=Integer.MIN_VALUE;
        for (int i:
             manacher) {
            if(max<i)max=i;
        }
        System.out.println(max-1);
        System.out.println(manacher_zuo(str));
    }

}
