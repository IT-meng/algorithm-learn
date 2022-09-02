package greedyAndTrie;

public class NQueens {
    //n皇后问题(在n*n的棋盘上摆n个皇后要求所有皇后不同行，不同列，不共斜线)，有几种摆法
    public static int num1(int n){
        int[] record=new int[n];
        //record[i]的值表示第i行的皇后摆在了第几列
        return process1(record,0,n);
    }
    //当前在第i行上摆皇后，record中0-(i-1)位置已经摆好了皇后
    public static int process1(int [] record,int i,int n){
        //n个皇后摆在0-(n-1)行，i==n说明找到了一种摆法
        if(i==n){
            return 1;
        }
        int res=0;
        for (int j=0;j<n;j++){
            if(isValid(record,i,j)){
                record[i]=j;
                res+=process1(record,i+1,n);
            }
        }
        return res;
    }
    //  检查第i行的第j列能不能放皇后
    public static boolean isValid(int[] record, int i, int j) {
        //遍历record的0-(i-1)位置看是否与第i行第j列冲突
        for (int k = 0; k < i; k++) {
            //共列或者共斜线返回false
            if(record[k]==j||Math.abs(i-k)==Math.abs(j-record[k])){
                //行差的绝对值等于列差的绝对值说明斜率45度共斜线
                return false;
            }
        }
        return true;
    }


    //改用位运算优化常数时间
    //n的类型为int所以n不要超过32
    public static int num2(int n){
        if(n<=0||n>32){
            return  0;
        }
        //得到低n位全是1，高位是0的数(注意：计算机内部是用补码表示数据的)
        int limit=n==32?-1:(1<<n)-1;
        return process2(limit,0,0,0);
    }

    public static int process2(int limit, int collim, int leftlim, int rightlim) {
        if(collim==limit){//列限制等于limit说明已经摆了n个皇后
            return 1;
        }
        int res=0;
        int position= (collim|leftlim|rightlim);//此时position为1的位置不能摆,为0的位置可以
        position=limit&(~position);
        int rightOne=getMostRightOne(position);
        while (rightOne!=0){
            //相当于在当前行摆上皇后
            position-=rightOne;
            //更新限制
//            collim=collim|rightOne;
//            leftlim=(leftlim|rightOne)<<1;
//            rightlim=(rightOne|rightlim)>>1;
//            res+=process2(limit,collim,leftlim,rightlim);
            //不能在本层里把它们改了，因为回到本层的时候这些参数还要用到
            res+=process2(limit,collim|rightOne,(leftlim|rightOne)<<1,(rightlim|rightOne)>>1);
            rightOne=getMostRightOne(position);

        }
        return res;
    }

    public static int getMostRightOne(int pos){
        return pos&(~pos+1);
    }

    public static void main(String[] args) {
        System.out.println(num2(15));
        System.out.println("------------------");
        System.out.println(num1(15));
    }
}
