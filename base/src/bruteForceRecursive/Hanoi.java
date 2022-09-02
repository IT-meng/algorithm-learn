package bruteForceRecursive;

public class Hanoi {

    public static void main(String[] args) {
        hanoi(3,'A','C','B');
    }

    //将n个圆盘从from-->to,借助help
    public static void hanoi(int n, char from, char to,char help){
        if(n==1){
            System.out.println(from+" --> "+to);
            return;
        }else{
            //先把上面的n-个从from-->help
            hanoi(n-1,from,help,to);
            //将第n个从from-->to
            hanoi(1,from,to,help);
            //将前n-1个从help-->to
            hanoi(n-1,help,to,from);
        }
    }
}
