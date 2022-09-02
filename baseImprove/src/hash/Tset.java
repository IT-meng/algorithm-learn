package hash;

public class Tset {
    public static void main(String[] args) {

        int[][] matrix=new int[3][4];
        System.out.println(matrix.length);

    }
    public static void print(int num){
        for (int i = 31; i >=0; i--) {
            System.out.print(((1<<i)&num)==0 ? "0" : "1");
        }
        System.out.println();
    }
}
