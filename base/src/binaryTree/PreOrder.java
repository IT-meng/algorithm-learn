package binaryTree;

import java.util.Stack;

public class PreOrder {
    //递归先序遍历
    public static void preOrder1(BiNode root){
        if(root!=null){
            System.out.print(root.data+"\t");
            preOrder1(root.left);
            preOrder1(root.right);
        }

    }
    //非递归先序遍历
    public static void preOrder2(BiNode root){
        Stack<BiNode> stack=new Stack<>();
        //先让root入栈
        stack.push(root);
        //当栈不空的时候,弹出栈顶元素并打印，并将其右孩子左孩子分别入栈
        while(!stack.isEmpty()){
            BiNode top=stack.pop();
            System.out.print(top.data+"\t");
            if(top.right!=null)
            stack.push(top.right);
            if(top.left!=null)
            stack.push(top.left);
        }
    }

    public static void main(String[] args) {
      BiNode root=Generator.getAVL();
        preOrder1(root);
        System.out.println();
        System.out.println("========================================");
        preOrder2(root);
    }
}
