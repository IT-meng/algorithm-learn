package binaryTree;

import java.util.Stack;

public class PostOrder {
    //递归后序遍历
    public static void postOrder1(BiNode root){
        if(root!=null){
            postOrder1(root.left);
            postOrder1(root.right);
            System.out.print(root.data+"\t");
        }

    }
    //非递归后续遍历
    public  static void postOrder2(BiNode root){
        Stack<BiNode> stack1=new Stack<>();
        Stack<BiNode> stack2=new Stack<>();
        //先让根节点入栈，当栈不空的时候每出栈一个元素，将其放入另一个栈并让其左孩子、右孩子依次入栈
        stack1.push(root);
        while(!stack1.isEmpty()){
            BiNode top=stack1.pop();
            stack2.push(top);
            if(top.left!=null)
            stack1.push(top.left);
            if(top.right!=null)
            stack1.push(top.right);

        }
        //将所有结点放入stack2之后，让stack2中的元素依次出栈
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data+"\t");
        }

    }

    public static void main(String[] args) {
        BiNode root=Generator.getFBT();
        postOrder1(root);
        System.out.println();
        System.out.println("====================================================");
        postOrder2(root);
    }
}
