package bit;

public class Compare {
    //不用任何判断，得到两个数中的较大者
    public static void main(String[] args) {

        System.out.println(getMax1(5,10));
        System.out.println(getMax2(10,40));
    }

    //保证传入的n不是0，就是1
    //0-->1
    //1-->0
    public static int flip(int n){
        return (n^1);
    }

    //x<0返回0否则返回1
    public static int sign(int x){
         return flip((x>>31)&1);
    }

    //如果a-b溢出则判断结果错误
    public static int getMax1(int a, int b){
        int c = a-b;
        int A = sign(c);//a-b<0 A=0,a-b>0,A=1
        int B = flip(A);
        return a*A+b*B;//互斥条件相加代替if else判断
    }

    public static int getMax2(int a, int b){
        int c  = a-b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difab = sa^sb;//a b符号不同时为1
        int samab = flip(difab);
        int returnA = samab*sc+difab*sa;//返回a的条件：1、a b符号相同c>0
        //a b符号不同，a>0
        int returnB = flip(returnA);
        return a*returnA+b*returnB;//互斥条件相加实现if-else判断
    }
}
