package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CBTJudge {
    //非递归实现
    public static boolean isCBT(BiNode root){
        /*
        * 对二叉树进行层次遍历，对于每一个节点
        * 如果其有右孩子却没有左孩子则判定其不是完全二叉树
        * 对于层次遍历中出现的第一个有左孩子没有右孩子的结点其后的所有结点都是叶子结点
        * 上述条件必须全部满足才是一颗完全二叉树*/
        if(root==null)return true;
        Queue<BiNode> queue=new LinkedList<>();
        queue.add(root);
        //进行中序遍历
        boolean flag=false;
        while(!queue.isEmpty()){
            BiNode Cur=queue.poll();
            if(Cur.left!=null){
                queue.add(Cur.left);
            }
            if(Cur.right!=null){
                queue.add(Cur.right);
            }
            if(flag&&(Cur.left!=null||Cur.right!=null)){
                return false;
            }
            if(Cur.right!=null&&Cur.left==null){
                return false;
            }
            if((Cur.left!=null&&Cur.right==null)||(Cur.left==null&&Cur.right==null)){
                flag=true;
            }

        }
        return true;

    }

    public static void main(String[] args) {
        BiNode root1=Generator.getBiTree();
        System.out.println(isCBT(root1));
        System.out.println("--------------------------------");
        BiNode root2=Generator.geteCBT();
        System.out.println(isCBT(root2));
    }
}
