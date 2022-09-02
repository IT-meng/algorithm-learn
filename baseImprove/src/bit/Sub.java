package bit;

public class Sub {

    public static int sub(int a,int b){
        //减法
        //a-b=a+(-b)
        return Add.add(a,negNum(b));
    }


    //返回x的相反数
    public static int negNum(int x){
        return Add.add(~x,1);
    }

    public static void main(String[] args) {
        System.out.println(sub(100,4));
    }
}
