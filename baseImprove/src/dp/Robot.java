package dp;



//一共有1-N个位置，机器人刚开始在S位置
//机器人每次可以向左、或者向右走一步
//求机器人从S位置走到E位置必须要走K步，有多少种方法

public class Robot {


    public static int solve(int S, int E, int k, int N) {
        return f(S, E, k, N);
    }

//当前在cur位置，还剩下rest步可以走，返回到达E的方法数
    public static int f(int cur, int E ,int rest,int N){
        if(rest==0){
            //没有步数可以走
            if(cur==E){
                return 1;
            }else {
                return 0;
            }
        }

        if(cur==1){
            //在1位置只能向右走
            return f(cur+1,E,rest-1,N);
        }

        if(cur==N){
            //在N位置只能往左走
            return f(cur-1,E,rest-1,N);
        }

        //在中间位置可以往左也可以往右
        return f(cur-1,E,rest-1,N)+f(cur+1,E,rest-1,N);
    }


    //记忆化搜索的版本

    //将之前求出的结果存在数组里，避免重复递归求同一个位置的值
    public static int f2(int cur, int E, int rest, int N, int[][] dp) {
        if (dp[cur][rest] != -1) return dp[cur][rest];
        if (rest == 0) {
            //没有步数可以走
            if (cur == E) {
                dp[cur][rest] = 1;
            } else {
                dp[cur][rest] = 0;
            }
        }

        if (cur == 1) {
            //在1位置只能向右走
            dp[cur][rest] = f(cur + 1, E, rest - 1, N);
        } else if (cur == N) {
            //在N位置只能往左走
            dp[cur][rest] = f(cur - 1, E, rest - 1, N);
        } else {
            //在中间位置可以往左也可以往右
            dp[cur][rest] = f(cur - 1, E, rest - 1, N) + f(cur + 1, E, rest - 1, N);

        }

        return dp[cur][rest];
    }

    public static int solve2(int S,int E,int k,int N){
        //rest: 0-k
        //cur: 1-N
        int[][] dp = new int[N+1][k+1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j]= -1;
            }
        }
       return f2(S,E,k,N,dp);
    }


    //严格表结构

    public static int dpWalkWay(int S,int E,int k,int N) {
        int[][] dp = new int[N + 1][k + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (i == E) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = 0;
            }
        }

        for (int i = 1; i < dp[0].length; i++) {
            for (int j = 1; j < dp.length; j++) {
                if (j == 1) {
                    dp[j][i] = dp[j + 1][i - 1];
                }else if(j==N){
                    dp[j][i]=dp[j-1][i-1];
                }else {
                    dp[j][i] = dp[j-1][i-1] + dp[j+1][i-1];
                }
            }
        }

        return dp[S][k];
    }



    //zuo_Code

    public static int ways1(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        return process1(start, K, aim, N);
    }

    // 机器人当前来到的位置是cur，
    // 机器人还有rest步需要去走，
    // 最终的目标是aim，
    // 有哪些位置？1~N
    // 返回：机器人从cur出发，走过rest步之后，最终停在aim的方法数，是多少？
    public static int process1(int cur, int rest, int aim, int N) {
        if (rest == 0) { // 如果已经不需要走了，走完了！
            return cur == aim ? 1 : 0;
        }
        // (cur, rest)
        if (cur == 1) { // 1 -> 2
            return process1(2, rest - 1, aim, N);
        }
        // (cur, rest)
        if (cur == N) { // N-1 <- N
            return process1(N - 1, rest - 1, aim, N);
        }
        // (cur, rest)
        return process1(cur - 1, rest - 1, aim, N) + process1(cur + 1, rest - 1, aim, N);
    }

    public static int ways2(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = -1;
            }
        }
        // dp就是缓存表
        // dp[cur][rest] == -1 -> process1(cur, rest)之前没算过！
        // dp[cur][rest] != -1 -> process1(cur, rest)之前算过！返回值，dp[cur][rest]
        // N+1 * K+1
        return process2(start, K, aim, N, dp);
    }

    // cur 范: 1 ~ N
    // rest 范：0 ~ K
    public static int process2(int cur, int rest, int aim, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        // 之前没算过！
        int ans = 0;
        if (rest == 0) {
            ans = cur == aim ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(2, rest - 1, aim, N, dp);
        } else if (cur == N) {
            ans = process2(N - 1, rest - 1, aim, N, dp);
        } else {
            ans = process2(cur - 1, rest - 1, aim, N, dp) + process2(cur + 1, rest - 1, aim, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;

    }

    public static int ways3(int N, int start, int aim, int K) {
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for (int rest = 1; rest <= K; rest++) {
            dp[1][rest] = dp[2][rest - 1];
            for (int cur = 2; cur < N; cur++) {
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
            }
            dp[N][rest] = dp[N - 1][rest - 1];
        }
        return dp[start][K];
    }

    public static void main(String[] args) {

        System.out.println(ways1(5, 2, 4, 6));
        System.out.println(ways2(5, 2, 4, 6));
        System.out.println(ways3(5, 2, 4, 6));

        System.out.println("=============================");

        System.out.println(solve(2,4,6,5));
        System.out.println(solve2(2,4,6,5));
        System.out.println(dpWalkWay(2,4,6,5));

    }

}
