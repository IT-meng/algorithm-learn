package bit;

public class Div {

    public static int div(int a, int b){
        //a/b:a-(b<<i)
        //a减去b左移i位>0
        //a减去b左移i+1位<0
        //说明商中从左到右第i+1位为1
        int cnt=0;
        if(a<0) {
            a = Sub.negNum(a);
            cnt=Add.add(cnt,1);
        }
        if(b<0){
            b= Sub.negNum(b);
            cnt=Add.add(cnt,1);
        }
        int res = 0;
        while(a>=b){
            for (int i = 31; i >= 0; i--) {
                if((a>>i)>=b){
                    res += (1<<i);
                    a=a-(b<<i);
                    break;
                }
            }
        }
        if(cnt==0||cnt==2)
        return res;
        else
            return Sub.negNum(res);
    }


    public static void main(String[] args) {
        System.out.println(div(33,11));
    }
}
