package binaryTree;
//平衡二叉树递归判断
public class AVLTreeJudge {
    /*
    一棵树是平衡二叉树需要满足的条件
    * 1、左子树是平衡二叉树
    * 2、右子树是平衡二叉树
    * 3、左右子树高度差不超过1
    *
    * */
public static boolean isAVL(BiNode root){
    /*
     * 我需要左子树给我的信息
     * 1、它是否是平衡二叉树
     * 2、它有多高
     * 我需要右子树给我的信息：
     * 1、它是否是平衡二叉树
     * 2、它有多高
     * */
  return process2(root).is;


}
    public static ReturnData2 process2(BiNode root){
    if(root==null){
        return new ReturnData2(0,true);
    }
    ReturnData2 leftData=process2(root.left);
    ReturnData2 rightData=process2(root.right);
    int height= (leftData.height>rightData.height? leftData.height : rightData.height)+1;
    boolean is=false;
    if(leftData.is&& rightData.is&&(Math.abs(leftData.height- rightData.height)<2))
    is=true;
        return new ReturnData2(height,is);
    }

    public static void main(String[] args) {
         BiNode root=Generator.onlyRight();
          System.out.println(isAVL(root));
          BiNode root2=Generator.getAVL();
        System.out.println("-----------------------");
        System.out.println(isAVL(root2));
    }
}
class ReturnData2{
    int height;
    boolean is;

    public ReturnData2(int height, boolean is) {
        this.height = height;
        this.is = is;
    }
}