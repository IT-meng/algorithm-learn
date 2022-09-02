package dp;

public class FirstSecondGame {

    //给定一个数组{1，3，50，100，5}
    //两个人每次可以从数组中取一个数(每次只能从最左边和最右边取)，最终得分高的人获胜
    //先手取的人会获胜还是后手取的人会获胜，返回获胜者的得分

    public  static int getWinnerScore(int[] arr){
        return Math.max(f(0,arr.length-1,arr),s(0,arr.length-1,arr));
    }

    //先手函数：返回先手在L-R上取能获得的最大得分
    public static int f(int L ,int R,int[] arr){
        if(L==R){
            return arr[L];
        }
        //选择最终得分高的那个
        return Math.max( arr[L]+s(L+1,R,arr),
                arr[R]+s(L,R-1,arr)
        );
    }
    //后手函数：返回在L-R上后手取所能获得的最大得分
    public static int s(int L,int R ,int[] arr){
        if(L==R){//只有一个数，后手能获得的最大得分为0
            return 0;
        }
        return Math.min(f(L+1,R,arr),
                f(L,R-1,arr));
    }


    //改严格表的动态规划
    public static int getWinnerScore2(int[] arr){
        int[][] first = new int[arr.length][arr.length];
        int[][] second = new int[arr.length][arr.length];
        //先把对角线填好
        for (int i = 0; i < arr.length; i++) {
            first[i][i] = arr[i];
            second[i][i] = 0;
        }
        int row =0;
        int col=0;
        int rowStep =2;
        int colStep = 1;
        while (col<arr.length-1){
            row = arr.length-rowStep;
            col=row+colStep;
            while(row>=0){

                first[row][col] = Math.max(arr[row]+second[row+1][col],
                        arr[col]+second[row][col-1]);

                second[row][col]=Math.min(first[row+1][col],
                        first[row][col-1]);
                row--;
                col = row+colStep;
            }

            rowStep++;
            colStep++;
        }

//        System.out.println("first");
//        for (int i = 0; i < first.length; i++) {
//            for (int j = 0; j < first[0].length; j++) {
//                System.out.print(first[i][j]+"\t");
//            }
//            System.out.println();
//        }
//        System.out.println("second");
//        for (int i = 0; i < first.length; i++) {
//            for (int j = 0; j < first[0].length; j++) {
//                System.out.print(second[i][j]+"\t");
//            }
//            System.out.println();
//        }

        return Math.max(first[0][arr.length-1],
                second[0][arr.length-1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,50,100,5,200};
        System.out.println(getWinnerScore(arr));
        System.out.println(f(0,arr.length-1,arr));
        System.out.println(s(0,arr.length-1,arr));
        System.out.println("==========================");
        System.out.println(getWinnerScore2(arr));

    }
}
