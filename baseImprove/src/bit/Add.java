package bit;

public class Add {


    public static int add(int a,int b){
        //sum = a^b
        //carry = (a&b)<<1
        int sum = a^b;
        int carry = (a&b)<<1;
        if(carry!=0){
            return add(sum,carry);
        }else {
            return sum;
        }
    }

    public static int add1(int a,int b){
        int sum =a;
        while (b!=0){
            sum= a^b;
            b=(a&b)<<1;
            a=sum;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(add(888,777));
        System.out.println(add1(888,777));
    }
}
