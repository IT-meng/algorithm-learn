package dp;

public class MinCoins {

    //coins：提供coins.length个硬币，coins[i]表示第i个硬币的面值
    //返回组成aim数量的钱最少需要几枚硬币
    public static int getMinCoins(int[] coins , int aim){
        return process(0,aim,coins);
    }


    //coins[index...]自由选择返回组成aim需要的最少硬币数
    public static int process(int index, int aim, int[] coins) {
        //basecase
        if (aim < 0) {
            return -1;
        } else if (aim == 0) {
            return 0;
        }

        if (index == coins.length) {
            return -1;
        }


        //aim>0 && index<arr.length

        //剔除无效解
        int yesIndex = process(index + 1, aim - coins[index], coins);
        int noIndex = process(index + 1, aim, coins);
        if (yesIndex == -1 && noIndex == -1) {
            return -1;
        } else {
            if (yesIndex == -1) {
                return noIndex;
            }
            if (noIndex == -1) {
                return 1 + yesIndex;
            }
        }
        //index位置要和不要两种情况

        //1、要index号硬币  2、不要index号硬币
        return Math.min(1 + yesIndex,
                noIndex);

    }

    public static int getMinCoins1(int[] coins,int aim){
        int[][] dp = new int[coins.length+1][aim+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -2;
            }
        }
        return process1(dp,coins,0,aim);
    }

    //记忆化搜索

    public static int process1(int[][] dp, int[] coins, int index, int aim) {
        if (aim < 0) return -1;
        //之前已经填过直接返回
        if (dp[index][aim] != -2) {
            return dp[index][aim];
        }

        //没有填过，填上返回

        //basecase
        if (aim == 0) {
            dp[index][aim] = 0;
            return dp[index][aim];
        }

        if (index == coins.length) {
            dp[index][aim] = -1;
            return dp[index][aim];
        }

        //aim>0 && index<arr.length

        //剔除无效解
        int yesIndex = process1(dp, coins, index + 1, aim - coins[index]);
        int noIndex = process1(dp, coins, index + 1, aim);

        if (yesIndex == -1 && noIndex == -1) {
            dp[index][aim] = -1;
            return dp[index][aim];
        } else {
            if (yesIndex == -1) {
                dp[index][aim] = noIndex;
                return dp[index][aim];
            }
            if (noIndex == -1) {
                dp[index][aim] = 1 + yesIndex;
                return dp[index][aim];
            }
        }
        //index位置要和不要两种情况

        //1、要index号硬币  2、不要index号硬币
        dp[index][aim] = Math.min(1 + yesIndex,
                noIndex);

        return dp[index][aim];

    }

    //严格表结构
    public static int getMinCoins2(int[] coins , int aim){
        return process2(coins,aim);
    }

    private static int process2(int[] coins , int aim) {
        int[][] dp = new int[coins.length+1][aim+1];
        for (int i=1;i<dp[0].length;i++){
            dp[dp.length-1][i] = -1;
        }
        //从下往上填
        for (int i = dp.length-2; i >=0 ; i--) {
            for (int j=1;j<aim+1;j++){
                if(j-coins[i]<0){
                    //i，j位置所依赖的位置索引是越界的
                    dp[i][j] = -1;
                }else if(dp[i+1][j-coins[i]]!=-1&& dp[i+1][j]!=-1){
                    dp[i][j] = Math.min(1+dp[i+1][j-coins[i]]+1,dp[i+1][j]);
                }
                else if(dp[i+1][j-coins[i]]==-1 && dp[i+1][j]==-1){
                    dp[i][j] = -1;
                }else if(dp[i+1][j-coins[i]]==-1){
                    dp[i][j] = dp[i+1][j];
                }else if(dp[i+1][j]==-1){
                    dp[i][j]= dp[i+1][j-coins[i]]+1;
                }
            }
        }
        return dp[0][aim];
    }

    public static void main(String[] args) {
        System.out.println(getMinCoins(new int[]{2,3,7,8,10},15));
        System.out.println("==============================");
        System.out.println(getMinCoins1(new int[]{2,3,7,8,10},15));
        System.out.println("===============================");
        System.out.println(getMinCoins2(new int[]{2,3,7,8,10},15));
    }
}
