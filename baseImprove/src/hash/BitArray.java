package hash;
//位图
public class BitArray {
    private int[] bits;

    public int[] getBits() {
        return bits;
    }

    BitArray(int size){
        bits=new int[size];//4*size(字节)=4*8*size(bit)
    }
    public int  geti(int i){//得到第i位的信息,i从0开始
        int numIndex=i/32;
        int bitindex=i%32;
        return ((bits[numIndex]>>>bitindex) &1);
    }
    //第二个参数为true就设成0，否则设成1
    public void seti(int i,boolean zero){
        int numIndex=i/32;
        int bitIndex=i%32;
        bits[numIndex]=zero ? (bits[numIndex] &   (~(1<<bitIndex))) :(bits[numIndex] | (1<<bitIndex) );
    }

    //把第i位设置成1(i从0开始)
    public void seti(int i){
        int numIndex=i/32;
        int bitIndex=i%32;
        //设置成1
        bits[numIndex]= (bits[numIndex] | (1<<bitIndex) );
    }

    public static void main(String[] args) {
        BitArray bitArray = new BitArray(2);
        bitArray.print(bitArray.getBits()[0]);
        bitArray.print(bitArray.getBits()[1]);
        System.out.println();
        tset(bitArray);
        bitArray.seti(32);
        bitArray.print(bitArray.getBits()[0]);
        bitArray.print(bitArray.getBits()[1]);
        System.out.println();

    }
 public static void tset(BitArray bitArray){
     for (int k = 0; k < 5; k++) {
         bitArray.seti(k);
         bitArray.print(bitArray.getBits()[0]);
         bitArray.print(bitArray.getBits()[1]);
         System.out.println();
         System.out.println("get"+k+"\t"+bitArray.geti(k));
     }
 }
    private static void printBitArray(BitArray bitArray) {
        for (int i = 0; i < 64; i++) {
            System.out.print(bitArray.geti(i));
        }
        System.out.println();
    }
    public static void print(int num){
        for (int i = 31; i >=0; i--) {
            System.out.print(((1<<i)&num)==0 ? "0" : "1");
        }
    }
}
