package bit;

public class Multi {


    public static int multi(int a, int b){
        int res = 0;
        while(b!=0){
            if((b&1)==1){
                res=Add.add(a,res);
            }
            a<<=1;
            b>>>=1;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(multi(7,9));
    }
}
