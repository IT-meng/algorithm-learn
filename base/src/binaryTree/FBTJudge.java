package binaryTree;

public class FBTJudge {
    //递归实现
    //我需要左子树给我的信息：
    /*
    * 1、高度
    * 2.结点数
    * */
    //需要右子树给我的信息
    /*
    * 1、高度
    * 2、结点数
    * */
    //递归判断

    public  static boolean isFBT(BiNode root){
        ReturnData3 data3=process3(root);
        return data3.nodes==Math.pow(2, data3.height)-1?true:false;

    }
    public static ReturnData3 process3(BiNode root){
        if(root==null){
            return new ReturnData3(0,0);
        }
        ReturnData3 leftData=process3(root.left);
        ReturnData3 rightData=process3(root.right);
        int height=Math.max(leftData.height,rightData.height)+1;
        int nodes= leftData.nodes+rightData.nodes+1;
        return new ReturnData3(height,nodes);
    }
    //非递归判断
    public static boolean isFBT2(BiNode root){
        int height=getheight(root);
        int  nodes=getNodes1(root);
        return nodes==Math.pow(2,height)-1?true:false;
    }
    //获取二叉树的高度
    public static int getheight(BiNode root){
        if(root==null){
            return 0;
        }
        return Math.max(getheight(root.left),getheight(root.right))+1;

    }
    //获取二叉树的结点数
    public static int getNodes1(BiNode root){
        int nodes=0;
        if(root==null)return 0;
      return getNodes1(root.left)+getNodes1(root.right)+1;
    }
    public static void main(String[] args) {
        BiNode root=Generator.getFBT();
        System.out.println(isFBT(root));
        System.out.println(isFBT2(root));
        System.out.println("-----------------");
        System.out.println(isFBT(Generator.onlyRight()));
        System.out.println(isFBT2(Generator.onlyRight()));
        isFBT2(root);

    }
}
class ReturnData3{
    int height;
    int nodes;

    public ReturnData3(int height, int nodes) {
        this.height = height;
        this.nodes = nodes;
    }
}
