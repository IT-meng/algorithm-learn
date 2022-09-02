package dp;

public class BobDie {

    public static long getLiveMethods(int row, int col, int x, int y, int step) {
        return process(row,col,x,y,step);
    }

    //N*M的区域：Bob在(row,col)位置，返回Bob走rest步还在N*M区域内的走法
    //每次可以向上下左右走一步
    public static long process(int N, int M, int row, int col, int rest) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }

        if (rest == 0) {
            return 1;
        }

        //往上走一步
        long live = process(N, M, row - 1, col, rest - 1);
        //向下走一步
        live += process(N, M, row + 1, col, rest - 1);
        //向左走一步
        live += process(N, M, row, col - 1, rest - 1);
        //向右走一步
        live += process(N, M, row, col + 1, rest - 1);

        return live;
    }

    public static long dpMethods(int N, int M, int row, int col, int rest) {
        int[][][] dp = new int[N][M][rest + 1];
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }

        if (rest == 0) {
            return 1;
        }
        //Base case
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dp[i][j][0] = 1;
            }
        }

        for (int z = 1; z < rest + 1; z++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    dp[i][j][z] = 0;
                    if (isLegal(N, M, i - 1, j)) {
                        dp[i][j][z] += dp[i - 1][j][z - 1];
                    }
                    if (isLegal(N, M, i + 1, j)) {
                        dp[i][j][z] += dp[i + 1][j][z - 1];
                    }

                    if (isLegal(N, M, i, j - 1)) {
                        dp[i][j][z] += dp[i][j - 1][z - 1];
                    }
                    if (isLegal(N, M, i, j + 1)) {
                        dp[i][j][z] += dp[i][j + 1][z - 1];
                    }
                }
            }
        }

        return dp[row][col][rest];
    }


    public static boolean isLegal(int N, int M, int i, int j) {
        if (i < 0 || i == N || j < 0 || j == M) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(process(4,5,3,2,5));
        System.out.println("=====================");
        System.out.println(dpMethods(4,5,3,2,5));
    }
}
