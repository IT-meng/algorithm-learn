package dp;

public class CoinsWays {

    //给一个数组{21，5，10，20，50}表示货币的面值(每个面值的货币都有无数张)
    //给你一个target，你用数组中的面值把它组出来，一共有多少种方法

    public static int getWays(int[] coins , int target){
        return process(coins,0,target);
    }

    //arr[index...]自由选择，返回组成rest的方法数
    public static int process(int[] arr,int index,int rest){

        if(index==arr.length){
            //已经没有货币可以选择
            return rest==0?1:0;
        }
        //有枚举行为的尝试
        int ways = 0;
        for (int zhang = 0; arr[index]*zhang <= rest; zhang++) {
            ways+=process(arr,index+1,rest-arr[index]*zhang);
        }
        return ways;
    }


    //不优化枚举行为，直接照着递归改
    public static int dp1(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < aim + 1; j++) {
                int ways = 0;
                for (int zhang = 0; arr[i] * zhang <= j; zhang++) {
                    ways += dp[i + 1][j - arr[i] * zhang];
                }
                dp[i][j] = ways;
            }
        }

        return dp[0][aim];
    }


    //优化枚举行为
    public static int dp2(int[] arr,int aim){
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < aim + 1; j++) {
                //观察邻近的位置能否代替枚举行为
                dp[i][j] = dp[i+1][j];
                if(j-arr[i]>=0){
                    dp[i][j]+= dp[i][j-arr[i]];
                }
            }
        }

        return dp[0][aim];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,4,5,1,3};
        System.out.println(getWays(arr,10));
        System.out.println("================");
        System.out.println(dp1(arr,10));
        System.out.println("=================");
        System.out.println(dp2(arr,10));
    }

}
