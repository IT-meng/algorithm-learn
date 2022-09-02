package bruteForceRecursive;

public class Question6 {
    //当前来到i位置，从i往后有多少种决定
    //0~i-1位置已经决定
    public static int process(char[] str,int i){
        if(i==str.length){//i来到最后一个位置，找到一种有效决定
            return 1;
        }
        if(str[i]=='0')return 0;
        if(str[i]=='1'){
            int res=process(str,i+1);//i单独作为一个数字
            if(i+1<str.length){
                res+=process(str,i+2);//i和i+1作为一个数字
            }

            return res;
        }
        if(str[i]=='2'){
            int res=process(str,i+1);//单独
            if(i+1< str.length && str[i+1]>='0'&&str[i+1]<='6'){
                res+=process(str,i+2);//i和i+1作为一个数字
            }
            return res;
        }
        return process(str,i+1);
    }

    public static void main(String[] args) {
        char[] str={'1','2','1','1','1'};
        System.out.println(process(str,0));
    }
}
