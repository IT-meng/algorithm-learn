package binaryTree;

public class BSTJudge {


    public static boolean isBST(BiNode root) {
        if (root == null) return true;
        return process(root).isBst;
    }

    public static ReturnData process(BiNode root) {
        //1、左子树是BST
        //2、右子树是BST
        //所有左子树的值小于我，所有右子树的值大于我
        //3、自己是BST

        if (root == null) return new ReturnData(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        //向左子树要：max,是否是BST，
        //向右子树要：min,是否是BST
        ReturnData leftData = process(root.left);
        ReturnData rightData = process(root.right);
        int max = root.data;
        int min = root.data;
        max = max > (leftData.max > rightData.max ? leftData.max : rightData.max) ? max : (leftData.max > rightData.max ? leftData.max : rightData.max);
        min = min < (leftData.min < rightData.min ? leftData.min : rightData.min) ? min : (leftData.min < rightData.min ? leftData.min : rightData.min);
        boolean is = false;
        if (leftData.isBst && leftData.max < root.data && rightData.isBst && rightData.min > root.data) {
            is = true;
        }
        return new ReturnData(max, min, is);
    }

    public static boolean isBST2(BiNode root){
        //如果是BST对其进行中序遍历得到有序结果
        int preValue=Integer.MIN_VALUE;
        if(root==null)return true;
        boolean left=isBST2(root.left);
         if(!left)return false;
         if(root.data<preValue){
             return false;
         }
         else{
             preValue= root.data;
         }
         return isBST2(root.right);

    }

    public static void main(String[] args) {
        int[] arr={10,4,5,7,2,6,9,8,3,1};
        BiNode root1=new GenerateBST().createBST(arr);
        BiNode root2=Generator.getBiTree();
        System.out.println(isBST(root1));
        System.out.println(isBST2(root1));
        System.out.println("-------------------------------");
        System.out.println(isBST(root2));
        System.out.println(isBST2(root2));
    }
}
class ReturnData{
    int max;
    int min;
    boolean isBst;

    public ReturnData(int max, int min, boolean isBst) {
        this.max = max;
        this.min = min;
        this.isBst = isBst;
    }
}