package TTTest;

public class TestArray {
    public static void main(String[] args) {
//        int[] record=new int[4];
//        for (int i = 0; i < record.length; i++) {
//            if(record[i]==0) System.out.println(true);
//            else System.out.println(false);
//        }

        System.out.println(func(100));
    }

   static int func(int n){
       if(n==0)return 0;
       n-=1;
       return func(n)+1;
    }
}
