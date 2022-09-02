package bit;

public class TwopowerAndFourPower {

    public static boolean isTwoPower1(int num){
        //2的幂只有一个位置上是1其余位置是0
        if(getMostRightOne(num)==num){
            return true;
        }else{

            return false;
        }
    }

    public static boolean isTwoPower2(int num){
        if((num&(num-1))==0){
            return true;
        }else {
            return false;
        }
    }

    public static boolean isFourPower(int num){
        if(isTwoPower1(num)&&(num & 0x55555555)!=0){
            return true;
        }else {

            return false;
        }
    }

    //得到一个数最右侧的1
    public static int getMostRightOne(int pos){
        return pos&(~pos+1);
    }

    public static void main(String[] args) {
        int[] arr = {2,4,6,8,16};
        for (int i = 0; i < arr.length; i++) {
            System.out.println(isTwoPower1(arr[i]));
            System.out.println(isTwoPower2(arr[i]));
        }
        System.out.println(0x55555555);
    }
}
