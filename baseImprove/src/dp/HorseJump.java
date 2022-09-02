package dp;

public class HorseJump {
    //10行9列的棋盘，“马”走“日”字，从(0,0)到(x,y)
    //从(0，0)位置出发，到达(x,y)位置,必须走step步，有多少种方法
    public static int getWays(int x, int y, int step) {
        return process(x, y, step);
    }

    //(0,0)-->(x,y) ways?
    public static int process(int x, int y, int step) {
        if (x < 0 || y < 0 || x > 9 || y > 8) {
            return 0;
        }
        if (step == 0) {
            if (x == 0 && y == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        return process(x - 1, y + 2, step - 1) +
                process(x + 1, y + 2, step - 1) +
                process(x + 2, y + 1, step - 1) +
                process(x + 2, y - 1, step - 1) +
                process(x + 1, y - 2, step - 1) +
                process(x - 1, y - 2, step - 1) +
                process(x - 2, y - 1, step - 1) +
                process(x - 2, y + 1, step - 1);

    }


    //严格表结构
    public static int getdpWays(int x, int y,int step){
        return dpWays(x,y,step);
    }

    public static int dpWays(int x, int y, int step) {
        //可变参数有三个x:0-9
        //y:0-8
        //step:0-step
        int[][][] dp = new int[10][9][step + 1];
        //把第一层填上
        dp[0][0][0] = 1;
        //从第二层开始填
        for (int z = 1; z < step + 1; z++) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 9; j++) {
                    dp[i][j][z] = 0;
                    if (isLegal(i - 1, j + 2)) {
                        dp[i][j][z] += dp[i - 1][j + 2][z - 1];
                    }

                    if (isLegal(i + 1, j + 2)) {
                        dp[i][j][z] += dp[i + 1][j + 2][z - 1];
                    }
                    if (isLegal(i + 2, j + 1)) {
                        dp[i][j][z] += dp[i + 2][j + 1][z - 1];
                    }
                    if (isLegal(i + 2, j - 1)) {
                        dp[i][j][z] += dp[i + 2][j - 1][z - 1];
                    }

                    if (isLegal(i + 1, j - 2)) {
                        dp[i][j][z] += dp[i + 1][j - 2][z - 1];
                    }
                    if (isLegal(i - 1, j - 2)) {
                        dp[i][j][z] += dp[i - 1][j - 2][z - 1];
                    }

                    if (isLegal(i - 2, j - 1)) {
                        dp[i][j][z] += dp[i - 2][j - 1][z - 1];
                    }

                    if (isLegal(i - 2, j + 1)) {
                        dp[i][j][z] += dp[i - 2][j + 1][z - 1];
                    }
                }
            }
        }

        return dp[x][y][step];

    }

    public static boolean isLegal(int i, int j) {
        //判断位置是否合法
        if (i < 0 || i > 9 || j < 0 || j > 8) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                getWays(5,6,5)
        );
        System.out.println("=====================");
        System.out.println(getdpWays(5,6,5));
    }

}
