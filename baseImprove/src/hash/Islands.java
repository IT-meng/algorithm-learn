package hash;

//给一个矩阵里面只有0和1，
// 每个位置和它的上下左右可以连通
//判断连通的区域有几片
public class Islands {
    public static int islandsNum(int[][] matrix){
        int row= matrix.length;//行
        int col=matrix[0].length;//列
        int count=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j]==1){
                    infect(matrix,i,j,row,col);
                    count++;
                }
            }
        }
        return count;
    }
    //感染过程
    //从matrix[i][j]位置开始感染
    public static void infect(int[][] matrix,int i,int j,int row,int col){
        if(i<0 || i>=row || j<0 || j>=col || matrix[i][j]!=1){
            return;
        }
        //位置合法，设置成2
        matrix[i][j] =2;
        //上下左右依次递归感染
        infect(matrix,i+1,j,row,col);
        infect(matrix,i-1,j,row,col);
        infect(matrix,i,j+1,row,col);
        infect(matrix,i,j-1,row,col);
    }

    public static void main(String[] args) {
        int[][] matrix={
                {1,1,0,0,1},
                {1,0,0,1,1},
                {0,1,0,0,0},
                {1,0,0,1,1}
        };
        System.out.println(islandsNum(matrix));
    }
}
